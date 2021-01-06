package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import javax.swing.*;

public class InitialPanel extends JPanel
{
    private ArrayList<JButton> buttons;
    private int units = 0;
    
    public InitialPanel()
    {
        super();
        
        buttons = new ArrayList<JButton>();
        
    }
    
    public void displayButtonString(int buttonIndex, String buttonString)
    {
        buttons.get(buttonIndex).setText(buttonString);
    }

}
