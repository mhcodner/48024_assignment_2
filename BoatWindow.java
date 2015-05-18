import model.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class BoatWindow extends JFrame
{  
    private Boat _boat;
    
    public BoatWindow(Boat boat)
    {
        this._boat = boat;
        setup();
        build(_boat);
        pack();
        setVisible(true);
    }
        
    private void setup()
    {
        setLocation(800, 500 + (_boat.id() - 1) * 150);
        setTitle("Boat " + _boat.id());
    }
        
    private void build(Boat boat)
    {
        add(new BoatPanel(boat));
    }
    
    private class BoatPanel extends JPanel
    {  
        private Boat boat;
        private BoatTable model;
        private JTable table;
        
        public BoatPanel(Boat boat)
        {
            this.boat = boat;
        }
    
        private void setup()
        {
            
        }
        
        private void build()
        {
            
        }
    
        private class BoatTable extends AbstractTableModel
        {  
            private final int cols = 3;
            private final String[] columnNames = {"Stop", "On", "Off"};
                
            public String getColumnName(int col)
            {
                return columnNames[col];
            }
            
            public int getRowCount()
            {
                return boat.stops();
            }
            
            public int getColumnCount()
            {
                return cols;
            }
            
            public Object getValueAt(int row, int col)
            {
                
                return null;
            }
        }
    }
}