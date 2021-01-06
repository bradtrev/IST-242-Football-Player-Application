package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FootballPlayerData implements TableData, Displayable, Sortable, Searchable
{

    private ArrayList<FootballPlayer> players;
    private FootballPlayer pArray[];
    private int firstLine;
    private int lastLine;
    private int numberOfLines;
    private int getLineToHighlight;
    private int sortType;
    private int sortField;
    private int fieldIndex;
    private boolean searchResult;
    private int tableMemberIndex;
    private ArrayList<HashMap> hashmaps;

    
    
    
    public FootballPlayerData()
    {
        
        players = new ArrayList<>();
//        FootballPlayer pArray[] = new FootballPlayer[players.size()];
        hashmaps = new ArrayList<>();
        

        sortType = 0;
        sortField = 0;
        fieldIndex = 0;
        
        loadTable();
        
        for(int j = 0; j < 7; j++){
            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
            for(int i = 0; i < players.size(); i++){
                hashMap.put(players.get(i).getAttribute(j), i);
            }
            hashmaps.add(hashMap);
        }
    }

    public void ReadPlayersFromXML()
    {
        try
        {
            FootballPlayer fp;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
            fp = new FootballPlayer();
            while (fp != null)
            {
                try
                {
                    fp = (FootballPlayer) decoder.readObject();
                    players.add(fp);
                    

                } catch (ArrayIndexOutOfBoundsException theend)
                {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // BEGIN SORTABLE /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    @Override
    public void sort(int sortType, int sortField){
        Comparator comparator;
        switch(sortField){
            case 0:
                comparator = new NumberComparator();
                break;
            case 1:
                comparator = new NameComparator();
                break;
            case 2:
                comparator = new PositionComparator();
                break;
            case 3:
                comparator = new HeightComparator();
                break;
            case 4:
                comparator = new WeightComparator();
                break;
            case 5:
                comparator = new HometownComparator();
                break;
            default:
                comparator = new HighschoolComparator();
                break;
        }

        // SELECTION SORT //
        if(sortType == 0){
            for(int j = 0; j < getPlayers().size()-1; j++){
                int min = j;
                for(int k=j+1; k < getPlayers().size(); k++){
                    if(getPlayers().get(k).getAttribute(sortField).
                            compareTo(getPlayers().get(min).getAttribute(sortField)) < 0){
                        min = k;
                    }
                }
                
                FootballPlayer temp = getPlayers().get(j);
                swapPlayers(min, j);
            }
        }
        // END SELECTION SORT //
        
        // MERGE SORT //
        if(sortType == 1){
            Collections.sort(players, comparator);
        }
        // END MERGE SORT //
        
        // QUICK SORT //
        if(sortType == 2){
                FootballPlayer[] playerArray = (FootballPlayer[]) players.toArray(new FootballPlayer[players.size()]); //new FootballPlayer[players.size()];
                Arrays.sort(playerArray, comparator);
                ArrayList<FootballPlayer> playersTemp = new ArrayList<FootballPlayer>(Arrays.asList(playerArray));
                players = playersTemp;
               
                Object[] array = players.toArray();
                players.clear();
                for(Object object : array){
                   FootballPlayer fp = (FootballPlayer)object;
                   players.add(fp);

            }
        }
        // END QUICK SORT //
    }
    
    private void quickSort(int left, int right, Comparator comparator){
        if(left >= right)
            return;
        // Middle index as pivot
        FootballPlayer pivot = players.get(right);
        int partition = partition(left, right, pivot, comparator);
        // quickSort called recursively with different right and left values
        quickSort(0, partition-1, comparator);
        quickSort(partition+1, right, comparator);
    }
    
    private int partition(int left, int right, FootballPlayer pivot, Comparator comparator){
        int leftCursor = left-1;
        int rightCursor = right;
        while(leftCursor < rightCursor){
            while(comparator.compare(players.get(++leftCursor), pivot) < 0);
            while(rightCursor > 0 
                    && comparator.compare(players.get(--rightCursor), pivot) >= 0);
            if(leftCursor >= rightCursor){
                break;
            }
            else{
                swapPlayers(leftCursor, rightCursor);
            }
        }
        swapPlayers(leftCursor, right);
        return leftCursor;
    }
    
    private void swapPlayers(int index1, int index2){
        FootballPlayer temp = players.get(index2);
        players.set(index2, players.get(index1));
        players.set(index1, temp);
    }
    
    @Override
    public int getSortType() {
        return sortType;
    }

    @Override
    public void setSortType(int sortType) {
            this.sortType = sortType;
        }

    @Override
    public int getSortField() {
        return sortField;
    }

    @Override
    public void setSortField(int sortField) {
        this.sortField = sortField;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // END SORTABLE ///////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    public ArrayList<FootballPlayer> getPlayers(){
        return players;
    }

    void setPlayers(ArrayList players){
        this.players = players;
    }
    
    @Override
    public void loadTable() {
        ReadPlayersFromXML();
    }

    @Override
    public ArrayList getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getHeaders(){
        FootballPlayer fp = new FootballPlayer();
        return fp.getAttributeNames();
        //alternate syntax
        //return new FootballPlayer().getAttributeNames();
    }

    @Override
    public ArrayList<String> getLine(int line) {
        return players.get(line).getAttributes();
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i < lastLine; i++){
            lines.add(getLine(i));
        }
        return lines;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // BEGIN DISPLAYABLE //////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    @Override
    public int getLinesBeingDisplayed(){
        return getLastLineToDisplay() - getFirstLineToDisplay();
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLine;
    }

    @Override
    public int getLineToHighlight() {
       return getLineToHighlight;
    }

    @Override
    public int getLastLineToDisplay() 
    {
        return lastLine;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLine = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.getLineToHighlight = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLine = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // END DISPLAYABLE ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    public void setCurrentLine(int currentLine){
        
    }

    ///////////////////////////////////////////////////////////////////////////
    // BEGIN SEARCHABLE ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    @Override
    public boolean search(String searchTerm) {
        boolean found = false;
        
        if(hashmaps.get(getSearchByField()).containsKey(searchTerm)){
            found = true;
        }

        setFound(found);

        setFoundIndex(retrieveFoundIndex(searchTerm));

        return found;
    }

    @Override
    public int getFoundIndex() {
        return tableMemberIndex;
    }

    @Override
    public void setFoundIndex(int tableMemberIndex) {
        this.tableMemberIndex = tableMemberIndex;
    }

    @Override
    public boolean getFound() {
        return searchResult;
    }

    @Override
    public void setFound(boolean searchResult) {
        this.searchResult = searchResult;
    }

    @Override
    public int getSearchByField() {
        return fieldIndex;
    }

    @Override
    public void setSearchByField(int fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

    ///////////////////////////////////////////////////////////////////////////
    // END SEARCHABLE /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
//    public HashMap getHashMap(){
//        HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
//        for(int i = 0; i < players.size(); i++){
//            hash_map.put(players.get(i).getAttribute(getSearchByField()), i);
//        }
//        return hash_map;
//    }
    
    public ArrayList<HashMap> getHashmaps() {
        return hashmaps;
    }

    public void setHashmaps(ArrayList<HashMap> hashmaps) {
        this.hashmaps = hashmaps;
    }
    
    public int retrieveFoundIndex(String searchTerm){
        int j = 0;
        for(int x = 0; x < players.size(); x++){
            if((players.get(x).getAttribute(getSearchByField())).equals(searchTerm)){
                return x;
            }
        }
        return -1;
    }
}