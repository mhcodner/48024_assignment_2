import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainPanel extends JPanel
{  
    private JTextField name = new JTextField(9);
    private JTextField start = new JTextField(9);
    private JTextField end = new JTextField(9);
    private JList list;
    private Boats boats;

    public MainPanel(Boats boats)
    {
        this.boats = boats;
        setup();
        build();
    }
        
    private void setup()
    {
        setBorder(BorderFactory.createLineBorder(Color.blue));
        setSize(name, 100);
        setSize(start, 50);
        setSize(end, 50);
    }
        
    private void setSize(JComponent c, int x)
    {  
        c.setPreferredSize(new Dimension(x, 20));
        c.setMinimumSize(new Dimension(x, 20));
        c.setMaximumSize(new Dimension(x, 20));
    }
    
    private void build()
    {
        Box box = Box.createHorizontalBox();
        box.add(inputBox());
        box.add(Box.createHorizontalStrut(30));
        //box.add(theList());
        add(box);
    }
        
    private Box inputBox()
    {  
        Box box = Box.createVerticalBox();
        box.add(pair("Name",  name));
        box.add(pair("Start",  start));
        box.add(pair("End",  end));
        return box;
    }
        
    private JList theList()
    {   
        return null;
    }
    
    private Box pair(String label, JTextField field)
    {
        Box box = Box.createHorizontalBox();
        box.add(new JLabel(label));
        box.add(Box.createHorizontalStrut(10));
        box.add(field);
        box.add(Box.createHorizontalStrut(5));
        return box;
    }
        
    private void clear()
    {
        name.setText("");
        start.setText("");
        end.setText("");
        list.clearSelection();
    }
        
    private class Listener implements ListSelectionListener
    {  
        public void valueChanged(ListSelectionEvent e)
        {
            if (e.getValueIsAdjusting())
                return;
            if (list.getSelectedIndex() == -1)
                return;
        }
    }
}
