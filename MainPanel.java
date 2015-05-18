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
        
    }
        
    private void setSize(JComponent c, int x)
    {  
        c.setPreferredSize(new Dimension(x, 20));
        c.setMinimumSize(new Dimension(x, 20));
        c.setMaximumSize(new Dimension(x, 20));
    }
    
    private void build()
    {
        
    }
        
    private Box inputBox()
    {  
        return null;
    }
        
    private JList theList()
    {   
        return null;
    }
        
    private void clear()
    {
        
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
