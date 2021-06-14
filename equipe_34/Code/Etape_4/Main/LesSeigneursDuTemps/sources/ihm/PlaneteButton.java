package equipe_34.lesSeigneursDuTemps.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PlaneteButton
{
    
    public static JButton planete(int x, int y, String image)
    {
        Icon icon              = new ImageIcon(image);
        JButton btn            = new JButton(icon);
 
        btn.setBounds(x,y,34,34       );
        btn.setOpaque(false           );
        btn.setContentAreaFilled(false); //Transparence
        btn.setBorderPainted(false    );
        btn.setFocusPainted(false     );
        btn.setPreferredSize(new Dimension (icon.getIconWidth(), icon.getIconHeight()));

        return btn;
    }
}