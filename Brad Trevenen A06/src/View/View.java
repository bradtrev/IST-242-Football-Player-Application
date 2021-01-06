package View;

import java.awt.Color;
import static java.awt.Color.cyan;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class View
{
    private MainFrame mf;
    private int heightOfTable;


    public View()
    {
        mf = new MainFrame();
    }
    
    public void CenterInitialSetup(int linesDisplayed, int headerSize, ArrayList headers)
    {
        
        for(int i = 0; i < ((linesDisplayed + 1)* headerSize); i++)
        {
            mf.getCp().getCenterPanelButtons().add(new JButton());
            
            if (i < headerSize)
            {
                mf.getCp().getCenterPanelButtons().get(i).setBackground(Color.pink);
                mf.getCp().getCenterPanelButtons().get(i).setName(headers.get(i).toString());
            }
            
            mf.getCp().add(mf.getCp().getCenterPanelButtons().get(i));
        }
        
        
        mf.getCenterGrid().setColumns(headerSize);
        mf.getCenterGrid().setRows(linesDisplayed + 1);
    }
    
    public void CenterUpdate(ArrayList<ArrayList<String>> lines, ArrayList<String> headers)
    {
        
        for(int i = 0; i < headers.size(); i++)
        {
            mf.getCp().displayButtonString(i, headers.get(i));
        }
        
        for(int i = 0; i < (lines.size()); i++)
        {
            for(int j = 0; j < lines.get(i).size(); j++)
            {
                int index = (headers.size() + ((i*headers.size()) + j));
                
                mf.getCp().displayButtonString(index,
                    lines.get(i).get(j));
            }
        }
    }

    public MainFrame getMf(){
        return mf;
    }

    public void setMf(MainFrame mf){
        this.mf = mf;
    }
    
    public int getHeightOfTable() {
        return heightOfTable;
    }

    public void setHeightOfTable(int heightOfTable) {
        this.heightOfTable = heightOfTable;
    }
    
}
