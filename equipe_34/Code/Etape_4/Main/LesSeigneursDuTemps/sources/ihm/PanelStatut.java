package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import javax.swing.*;
import java.awt.*;


/*--------------------------------------------*/
/* Classe PanelImage                          */
/*--------------------------------------------*/
public class PanelStatut
{
	public static JPanel panel(String img)
	{
        Icon icon              = new ImageIcon(img);
        JPanel panel           = new JPanel();
        JLabel setIcon         = new JLabel(icon);
 
		// setIcon.setBounds(0,30,0,0);
		panel.add(setIcon);
        panel.setOpaque(false);

        return panel;
	}

}