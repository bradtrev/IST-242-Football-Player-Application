/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;



public class CenterPanel extends JPanel
{
    private ArrayList<JButton> centerPanelButtons;
    
    public CenterPanel()
    {
        super();
        
        setBackground(Color.red);
        
        centerPanelButtons = new ArrayList<JButton>();

    } 
    
    public int compareSourceHeaderButtonString(String sourceString, ArrayList headers){
        int i;
        int returnInt = 0;

        for(i = 0; i < headers.size(); i++){
            if(sourceString == headers.get(i).toString()){
                returnInt = i;
            }
        }
        return returnInt;
    }
    
    public void displayButtonString(int buttonIndex, String buttonString)
    {
        centerPanelButtons.get(buttonIndex).setText(buttonString);
    }    
    
    public ArrayList<JButton> getCenterPanelButtons() {
        return centerPanelButtons;
    }

    public void setCenterPanelButtons(ArrayList<JButton> centerPanelButtons) {
        this.centerPanelButtons = centerPanelButtons;
    }
    
    public void changeButtonColor(int buttonIndex, Color newColor)
    {
        centerPanelButtons.get(buttonIndex).setBackground(newColor);
    }

}

