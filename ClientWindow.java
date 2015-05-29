import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.text.DecimalFormat;

public class ClientWindow extends JFrame
{
    private Boats boats;
    
    public ClientWindow(Boats boats)
    {
        this.boats = boats;
        
        setup();
        build();
        pack();
        setVisible(true);
    }
    
    private void setup()
    {
        setLocation(500, 620);
        setTitle("Clients");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void build()
    {
        add(new ClientPanel(this.boats));
    }
    
    private class ClientPanel extends JPanel implements View
    {
        private ClientTable model;
        private JTable table;
        
        
        public ClientPanel(Boats boats)
        {
            for (Boat boat: boats.boats())
                boat.attach(this);
            
            setup();
            build();
        }
        
        public void update()
        {
            setup();
            build();
        }
        
        private void setup()
        {
            model = new ClientTable();
            table = new JTable(model);
            
            //setBorder(BorderFactory.createLineBorder(Color.red));
            table.setBorder(BorderFactory.createLineBorder(Color.red));
            table.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.red));
            
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(70);
        }
        
        private void build()
        {
            Box box = Box.createVerticalBox();
            box.add(table.getTableHeader());
            box.add(table);
            add(box);
        }
        
        private class ClientTable extends AbstractTableModel
        {
            private final int cols = 2;
            private final String[] columnNames = {"Name", "Cash"};
            
            public String getColumnName(int col)
            {
                return columnNames[col];
            }
            
            public int getRowCount()
            {
                return Client.all().size();
            }
            
            public int getColumnCount()
            {
                return cols;
            }
            
            public Object getValueAt(int row, int col)
            {
                Client client = Client.all().get(row);
                
                switch(col) {
                    case 0: return "    " + client.name;
                    case 1: return "  $" + new DecimalFormat("#.00").format(client.money);
                }
                
                return "";
            }
        }
    }
}