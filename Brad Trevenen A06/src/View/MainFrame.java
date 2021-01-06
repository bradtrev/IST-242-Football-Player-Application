package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MainFrame extends JFrame 
{

    private InitialPanel ip;
    private GridBagLayout initialGrid = new GridBagLayout();
    private CenterPanel cp;
    private GridLayout centerGrid = new GridLayout();
    private WestPanel wp;
    private GridLayout westGrid = new GridLayout();
    private NorthPanel np;
    private GridLayout northGrid = new GridLayout();
    
    public MainFrame()
    {
        super("A06");
        
        ip = new InitialPanel();
        ip.setLayout(initialGrid);
        GridBagConstraints ipgbc = new GridBagConstraints();
        
        np = new NorthPanel();
        northGrid = new GridLayout();
        northGrid.setColumns(1);
        northGrid.setRows(1);
        np.setLayout(northGrid);
//        ipgbc.fill = GridBagConstraints.HORIZONTAL;
        ipgbc.gridx = 2;
        ipgbc.gridy = 0;
        ipgbc.gridwidth = 2;
        ipgbc.ipady = 15;
        ip.add(np, ipgbc);
        
        wp = new WestPanel();
        westGrid = new GridLayout();
        westGrid.setColumns(1);
        westGrid.setRows(4);
        wp.setLayout(westGrid);
        ipgbc.fill = GridBagConstraints.BOTH;
        ipgbc.gridx = 0;
        ipgbc.gridy = 1;
        ipgbc.ipadx = 0;
        ip.add(wp, ipgbc);
        
        cp = new CenterPanel();
        centerGrid = new GridLayout();
        cp.setLayout(centerGrid);
        ipgbc.fill = GridBagConstraints.BOTH;
        ipgbc.weightx = 0.6;
        ipgbc.gridx = 2;
        ipgbc.gridy = 1;
        ipgbc.ipadx = 400;
        ip.add(cp, ipgbc);
        
        add(ip);

        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setVisible(true);
    }

    public InitialPanel getIp(){
        return ip;
    }

    public void setIp(InitialPanel ip){
        this.ip = ip;
    }
    
    public GridBagLayout getInitialGrid() {
        return initialGrid;
    }

    public void setInitialGrid(GridBagLayout initialGrid) {
        this.initialGrid = initialGrid;
    }
   
    public CenterPanel getCp() {
        return cp;
    }

    public void setCp(CenterPanel cp) {
        this.cp = cp;
    }
    
    public GridLayout getCenterGrid() {
        return centerGrid;
    }

    public void setCenterGrid(GridLayout centerGrid) {
        this.centerGrid = centerGrid;
    }
    
    public GridLayout getWestGrid() {
        return westGrid;
    }

    public void setWestGrid(GridLayout westGrid) {
        this.westGrid = westGrid;
    }
    
    public WestPanel getWp() {
        return wp;
    }

    public void setWp(WestPanel wp) {
        this.wp = wp;
    }
    
    public NorthPanel getNp() {
        return np;
    }

    public void setNp(NorthPanel np) {
        this.np = np;
    }
}
