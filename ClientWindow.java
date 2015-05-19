import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class ClientWindow extends JFrame
{
    public ClientWindow()
    {
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
        add(new ClientPanel());
    }
    
    private class ClientPanel extends JPanel implements View
    {
        private ClientTable model;
        private JTable table;
        
        public ClientPanel()
        {
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
            
            setBorder(BorderFactory.createLineBorder(Color.red));
            table.setBorder(BorderFactory.createLineBorder(Color.red));
            
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(80);
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
                return 4;
            }
            
            public int getColumnCount()
            {
                return cols;
            }
            
            public Object getValueAt(int row, int col)
            {
                switch(col) {
                    case 0: return ""; //client.name
                    case 1: return ""; //client.cash
                }
                
                return "";
            }
        }
    }
}