import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainPanel extends JPanel implements View
{  
    private DefaultListModel<String> model = new DefaultListModel<String>();
    private JList list = new JList(model);
    private JTextField name = new JTextField(9);
    private JTextField start = new JTextField(9);
    private JTextField end = new JTextField(9);
    private Boats boats;

    public MainPanel(Boats boats)
    {
        this.boats = boats;
        for (Boat boat: boats.boats())
            boat.attach(this);
        setup();
        build();
        update();
    }
        
    private void setup()
    {
        setBorder(BorderFactory.createLineBorder(Color.blue));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new Listener());
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
        box.add(theList());
        box.add(Box.createHorizontalStrut(30));
        add(box);
    }
        
    private Box inputBox()
    {  
        Box box = Box.createVerticalBox();
        box.add(pair("Name", name));
        box.add(pair("  Start", start));
        box.add(pair("   End", end));
        return box;
    }
        
    private JList theList()
    {   
        return list;
    }
    
    private Box pair(String label, JTextField field)
    {
        Box box = Box.createHorizontalBox();
        box.add(new JLabel(label));
        box.add(Box.createHorizontalStrut(10));
        box.add(field);
        box.setAlignmentX(0);
        return box;
    }
        
    private void clear()
    {
        name.setText("");
        start.setText("");
        end.setText("");
        list.clearSelection();
    }
    
    public void update()
    {
        model.clear();
        for (Boat boat: boats.boats())
            model.addElement("Boat " + boat.id());
    }
        
    private class Listener implements ListSelectionListener
    {  
        public void valueChanged(ListSelectionEvent e)
        {
            if (e.getValueIsAdjusting())
                return;
            if (list.getSelectedIndex() == -1)
                return;
            Boat boat = boats.boat(list.getSelectedIndex());
            boat.book(name.getText(), Integer.parseInt(start.getText()), Integer.parseInt(end.getText()));;
            //clear();
        }
    }
}
