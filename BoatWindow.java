import model.*;

import java.awt.*;
import java.awt.event.*;
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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
        
    private void build(Boat boat)
    {
        add(new BoatPanel(boat));
    }
    
    private class BoatPanel extends JPanel implements View
    {  
        private Boat boat;
        private BoatTable model;
        private JTable table;
        
        public BoatPanel(Boat boat)
        {
            this.boat = boat;
            this.boat.attach(this);
            
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
            model = new BoatTable();
            table = new JTable(model);
            
            setBorder(BorderFactory.createLineBorder(Color.green));
            table.setBorder(BorderFactory.createLineBorder(Color.green));
            //table.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.green));
            
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
        }
        
        private void build()
        {
            Box mainBox = Box.createHorizontalBox();
            
            Box tableBox = Box.createVerticalBox();
            tableBox.add(table.getTableHeader());
            tableBox.add(table);
            mainBox.add(tableBox);
            
            //Box buttonBox = Box.createVerticalBox();
            mainBox.add(Box.createHorizontalStrut(5));
            JButton goButton = new JButton("GO");
            Listener listener = new Listener();
            listener.setBoat(boat);
            goButton.addActionListener(listener);
            //buttonBox.add( Box.createVerticalGlue() );
            mainBox.add(goButton);
            //buttonBox.add( Box.createVerticalGlue() );
            //mainBox.add(buttonBox);
            
            add(mainBox);
        }
        
        private class Listener implements ActionListener
        {
            private Boat boat;
            
            public void setBoat(Boat boat)
            {
                this.boat = boat;
            }
            
            public void actionPerformed(ActionEvent e)
            {
                //boat.go();
                update();
            }
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
                switch(col) {
                    case 0: return row;
                    case 1: return boat.on(row);
                    case 2: return boat.off(row);
                }
                
                return "";
            }
        }
    }
}