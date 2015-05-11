import model.*;

import java.awt.*;
import javax.swing.*;

public class Root extends JFrame
{   public static void main(String[] args)
    {   new Root(new Boats());    }
    
    public Root(Boats boats)
    {   setup();
        build(boats);
        pack();
        setVisible(true);   }
        
    private void setup()
    {   }
        
    private void build(Boats boats)
    {   }
}
