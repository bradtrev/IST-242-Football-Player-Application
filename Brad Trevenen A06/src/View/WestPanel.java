/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class WestPanel extends JPanel {
    
    private ArrayList<JRadioButton> westPanelButtons;
    private final JLabel chooseSort;
    private ButtonGroup rbGroup;

    private final JRadioButton selection;
    private final JRadioButton merge;
    private final JRadioButton quick;
    

    public WestPanel(){
        super();
        
        setBackground(Color.green);
        
        westPanelButtons = new ArrayList<JRadioButton>();
        rbGroup = new ButtonGroup();
        
        chooseSort = new JLabel("Choose a SORT type");
        chooseSort.setOpaque(true);
        chooseSort.setBackground(Color.DARK_GRAY);
        chooseSort.setForeground(Color.white);
        add(chooseSort);
        
        selection = new JRadioButton("(1) Selection/Write Yourself");
        westPanelButtons.add(selection);
        rbGroup.add(selection);
        add(selection);
        
        merge = new JRadioButton("(2) Merge/ArrayList()");
        westPanelButtons.add(merge);
        rbGroup.add(merge);
        add(merge);
        
        quick = new JRadioButton("(3) Quick/Arrays[]");
        westPanelButtons.add(quick);
        rbGroup.add(quick);
        add(quick);
    }
    
    public int compareSourceRbString(String sourceString, ArrayList wpButtons){
        int i;
        int returnInt = 0;

        for(i = 0; i < wpButtons.size(); i++){
            if(sourceString == westPanelButtons.get(i).getText()){
                returnInt = i;
            }
        }
        return returnInt;
    }
    
    public ArrayList<JRadioButton> getWestPanelButtons() {
        return westPanelButtons;
    }

    public void setWestPanelButtons(ArrayList<JRadioButton> WestPanelButtons) {
        this.westPanelButtons = WestPanelButtons;
    }
    
    public ButtonGroup getRbGroup() {
        return rbGroup;
    }

    public void setRbGroup(ButtonGroup rbGroup) {
        this.rbGroup = rbGroup;
    }
}
