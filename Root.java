// 11989668 Michael Codner
// 12147221 Gareth Stokes

import model.*;

import java.awt.*;
import javax.swing.*;

public class Root extends JFrame
{  
    public static void main(String[] args)
    {
        new Root(new Boats());
    }
    
    public Root(Boats boats)
    {
        setup();
        build(boats);
        pack();
        setVisible(true);
    }
        
    private void setup()
    {
        setLocation(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
        
    private void build(Boats boats)
    {
        add(new MainPanel(boats));
        for (Boat boat: boats.boats())
            new BoatWindow(boat);
        new ClientWindow(boats);
    }
}
