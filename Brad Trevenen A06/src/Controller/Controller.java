package Controller;

import Model.Model;
import Model.Student;
import View.View;
import java.awt.Color;
import static java.awt.Color.cyan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

public class Controller
{

    private Model model;
    private View view;
    
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
        
        view.setHeightOfTable(25);
        model.getFpData().setFirstLineToDisplay(0);
        model.getFpData().setLastLineToDisplay(view.getHeightOfTable());
        
        view.CenterInitialSetup(model.getFpData().getLinesBeingDisplayed(), 
            model.getFpData().getHeaders().size(), model.getFpData().getHeaders());
        
        view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), 
            model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
        
        addCpScrolling(model.getFpData().getLastLineToDisplay());
        
        addHeaderListeners();
        
        addSortListeners();
        
        addSearchListener();
        
    }
    
    private void addSearchListener() {
        view.getMf().getNp().getSearchField().addKeyListener(new KeyListener()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                String sfText;
                
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    sfText = view.getMf().getNp().getSearchField().getText();
                    model.getFpData().search(sfText);
                    
                    int headerSize = model.getFpData().getHeaders().size();
                    
                    if(model.getFpData().getFound()){
                        // CHANGING JTEXTFIELD
                        view.getMf().getNp().changeTfColor(true);
                        // END
                        
                        // RESET BUTTON COLORS EXCEPT HEADERS
                        for(int j = model.getFpData().getHeaders().size(); j < view.getMf().getCp().getCenterPanelButtons().size(); j++){
                            view.getMf().getCp().getCenterPanelButtons().get(j).setBackground(new JButton().getBackground());
                        }
                        // END
                        
                        // SETTING FIRST AND LAST LINES TO DISPLAY
                        model.getFpData().setFirstLineToDisplay(model.getFpData().getFoundIndex());
                        model.getFpData().setLastLineToDisplay(model.getFpData().getFirstLineToDisplay() + view.getHeightOfTable());
                        int initialFirstLine = model.getFpData().getFirstLineToDisplay(); // setting temporary first line
                        if(model.getFpData().getFirstLineToDisplay() > (model.getFpData().getPlayers().size() - view.getHeightOfTable())){
                            model.getFpData().setFirstLineToDisplay(model.getFpData().getPlayers().size() - view.getHeightOfTable());
                            model.getFpData().setLastLineToDisplay(model.getFpData().getFirstLineToDisplay() + view.getHeightOfTable());
                        }
                        // END
                        
                        // HIGHLIGHT RESULT INDEX ROW //
                        if(initialFirstLine <= (model.getFpData().getPlayers().size() - view.getHeightOfTable())){
                            for(int k = (headerSize); k < (headerSize * 2); k++){
                                view.getMf().getCp().getCenterPanelButtons().get(k).setBackground(Color.magenta);
                            }
                        }
                        if(initialFirstLine >  (model.getFpData().getPlayers().size() - view.getHeightOfTable())){
                            int difference = model.getFpData().getPlayers().size() - model.getFpData().getFoundIndex() -1 ;
                            for(int k = ((view.getHeightOfTable() - difference) * headerSize); k < ((view.getHeightOfTable() - difference) * headerSize) + headerSize; k++){
                                view.getMf().getCp().getCenterPanelButtons().get(k).setBackground(Color.magenta);
                            }
                        }
                        // END //

                        // UPDATE PANEL WITH NEW STRINGS //
                        view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(),
                                model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                        // END
                        
                        
                    }
                    else
                        view.getMf().getNp().changeTfColor(false);
                    
                    
                }   
            }

            @Override
            public void keyTyped(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
   
    }
    
    private void addCpScrolling(int lastLine)
    {
        view.getMf().getIp().addMouseWheelListener(new MouseWheelListener()
        {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                int units = e.getUnitsToScroll();
                
                int lowerBound = lastLine - 1;
                
                int upperBound = (model.getFpData().getPlayers().size() + 1);
                
                int rowValue = (model.getFpData().getLastLineToDisplay() + units);
               
                if(rowValue > lowerBound && rowValue < upperBound)
                {
                    model.getFpData().setLastLineToDisplay(model.getFpData().getLastLineToDisplay() + units);
                    model.getFpData().setFirstLineToDisplay(model.getFpData().getFirstLineToDisplay() + units);
                    
                    view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), 
                        model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                }
                
                for(int j = model.getFpData().getHeaders().size(); j < view.getMf().getCp().getCenterPanelButtons().size(); j++){
                    view.getMf().getCp().getCenterPanelButtons().get(j).setBackground(new JButton().getBackground());
                }
            }
        }
            );
    }
    
    private void addHeaderListeners()
    {
        for(int i = 0; i < model.getFpData().getHeaders().size(); i++)
        {
            view.getMf().getCp().getCenterPanelButtons().get(i).addActionListener(
                    new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            Object source = e.getSource();
                            
                            for(int j = 0; j < model.getFpData().getHeaders().size(); j++)
                            {
                                view.getMf().getCp().getCenterPanelButtons().get(j).setBackground(Color.pink);
                            }
                            
                            if(source instanceof JButton)
                            {
                                ((JButton) source).setBackground(Color.cyan);
                                
                                //GETTING-SETTING SORT FIELD & SORTING PLAYERS
                                int sortField = view.getMf().getCp().compareSourceHeaderButtonString(
                                    ((JButton) source).getName(), model.getFpData().getHeaders());
                                model.getFpData().setSortField(sortField);
                                model.getFpData().sort(model.getFpData().getSortType(), model.getFpData().getSortField());
                                //END
                                
                                //SETTING SEARCH FIELD
                                int searchFieldIndex = view.getMf().getCp().compareSourceHeaderButtonString(
                                    ((JButton) source).getName(), model.getFpData().getHeaders());
                                model.getFpData().setSearchByField(searchFieldIndex);
                                //END
                                
                                view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), 
                                    model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                            }
                        }
                    }
                );
        }
    }

    private void addSortListeners(){
        for(int i = 0; i < view.getMf().getWp().getWestPanelButtons().size(); i++){
            view.getMf().getWp().getWestPanelButtons().get(i).addActionListener(
                    new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            Object radioSource = e.getSource();
                            
                            if(radioSource instanceof JRadioButton){
                                
                                int sortType = view.getMf().getWp().compareSourceRbString(
                                        ((JRadioButton) radioSource).getText(), view.getMf().getWp().getWestPanelButtons());
                               
                                model.getFpData().setSortType(sortType);
                                
                                model.getFpData().sort(model.getFpData().getSortType(), model.getFpData().getSortField());
                                
                                view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), 
                                    model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                            }
                        }
                    }
                );
        }
    }

    public Model getModel()
    {
        return model;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public View getView()
    {
        return view;
    }

    public void setView(View view)
    {
        this.view = view;
    }


}
