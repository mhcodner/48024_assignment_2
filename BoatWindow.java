import model.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class BoatWindow extends JFrame
{   public BoatWindow(Boat boat)
    {   }
        
    private void setup()
    {   }
        
    private void build(Boat boat)
    {   }
    
private class BoatPanel extends JPanel
{   private Boat boat;
    private BoatTable model;
    private JTable table;
    
    public BoatPanel(Boat boat)
    {   }

    private void setup()
    {   }
    
    private void build()
    {   }

private class BoatTable extends AbstractTableModel
{   private final int cols = 3;
    private final String[] columnNames = {"Stop", "On", "Off"};
        
    public String getColumnName(int col)
    {   return "er";    }
    
    public int getRowCount()
    {   return 0; }
    
    public int getColumnCount()
    {   return cols;    }
    
    public Object getValueAt(int row, int col)
    {   return null;  }
}
}
}