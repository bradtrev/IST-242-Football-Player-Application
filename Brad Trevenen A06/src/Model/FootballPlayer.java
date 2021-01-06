package Model;

import java.util.ArrayList;

public class FootballPlayer extends Person implements TableMember, Comparable
{
    //public String name;
    //public Height height;
    //public int weight;
    //public String hometown;
    private int number;
    private String position;
    private String highSchool;

    //default constructor
    public FootballPlayer()
    {
        number = -99;
//        super.name = "N/A";
        position = "N/A";
//        super.height = new Height( -9, -9);
//        super.weight = -99;
//        super.hometown = "N/A";
        highSchool = "N/A";
    }
    
    //constructor
    public FootballPlayer(int number, String name, String position, 
            int feet, int inches, int weight, String hometown, 
            String highSchool)
    {
        super(name, feet, inches, weight, hometown);
        this.number = number;
        //name = inf_name;
        this.position = position;
        //height = new Height(inf_feet, inf_inches);
        //weight = inf_weight;
        //hometown = inf_hometown;
        this.highSchool = highSchool;
    }

    
    //methods
    @Override
    public String toString()
    {
        return super.toString() + " His number is " + getNumber() + " and he plays "
                + getPosition() + ". He went to " + getHighSchool() + ".";
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public void setNumber(int number)
    {
        this.number = number;
    }
    
    public String getPosition()
    {
        return position;
    }
    
    public void setPosition(String position)
    {
        this.position = position;
    }
    
    public String getHighSchool()
    {
        return highSchool;
    }
    
    public void setHighSchool(String highSchool)
    {
        this.highSchool = highSchool;
    }

    @Override
    public String getAttributeName(int n) 
    {
        int x = n;
        
        switch(n)
        {
            case 0:
                return "Number";
//                break;
//                would need if nothing returned
            case 1:
                return "Name";
//                break;
            case 2:
                return "Position";
//                break;
            case 3:
                return "Height";
//                break;
            case 4:
                return "Weight";
//                break;
            case 5:
                return "Hometown";
//                break;
            case 6:
                return "High School";
//                break;
            default:
                return "error";
        }
    }

    @Override
    public ArrayList<String> getAttributeNames()
    {
        ArrayList<String> attributeNames = new ArrayList<String>();
        
        for (int i = 0; i < 7; i++)
        {
            attributeNames.add(getAttributeName(i));
        }
        
        return attributeNames;
    }
    
    @Override
    public String getAttribute(int n)
    {
        int x = n;
        
        switch(n)
        {
            case 0:{
                if(number < 10){
                    return "0" + Integer.toString(number);
                }
                else
                    return Integer.toString(number);
            }
//                break;
//                would need if nothing returned
            case 1:
                return getName();
//                break;
            case 2:
                return position;
//                break;
            case 3:
                return getHeight().toString();
//                break;
            case 4:
                return Integer.toString(getWeight());
//                break;
            case 5:
                return getHometown();
//                break;
            case 6:
                return highSchool;
//                break;
            default:
                return "getAttribute error";
        }
    }
    
    @Override
    public ArrayList<String> getAttributes()
    {
        ArrayList<String> attributes = new ArrayList<String>();
        
        for (int i = 0; i < 7; i++)
        {
            attributes.add(getAttribute(i));
        }
        
        return attributes;
    }
    
    public int numberCompareTo(FootballPlayer fp){
        return fp.getNumber() - number;
    }
    
    public int nameCompareTo(FootballPlayer fp){
        return name.compareTo(fp.getName());
    }
    
    public int positionCompareTo(FootballPlayer fp){
        return position.compareTo(fp.getPosition());
    }
    
    public int heightCompareTo(FootballPlayer fp){
        return fp.getHeight().toInches() - height.toInches();
    }
    
    public int weightCompareTo(FootballPlayer fp){
        return fp.getWeight() - weight;
    }
    
    public int hometownCompareTo(FootballPlayer fp){
        return hometown.compareTo(fp.getHometown());
    }
    
    public int highschoolCompareTo(FootballPlayer fp){
        return highSchool.compareTo(fp.getHighSchool());
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}