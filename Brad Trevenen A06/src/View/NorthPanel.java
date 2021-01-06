/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NorthPanel extends JPanel {
    
    private JTextField searchField;

    Dimension tfDimension;
    
    public NorthPanel(){
        searchField = new JTextField();
        tfDimension = new Dimension();
        tfDimension.width = 200;
        tfDimension.height = 15;
        searchField.setMinimumSize(tfDimension);
        
        add(searchField);
        
        setBackground(Color.LIGHT_GRAY);
    }
    
    public void changeTfColor(boolean change){
        if(change){
            searchField.setBackground(Color.green);
        }
        else
            searchField.setBackground(Color.red);
    }
    
    public JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public Dimension getTfDimension() {
        return tfDimension;
    }

    public void setTfDimension(Dimension tfDimension) {
        this.tfDimension = tfDimension;
    }
}



