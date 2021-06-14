package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.RoundRectangle2D;
import javax.imageio.ImageIO;
import java.io.*;


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
 
		panel.add(setIcon);
        panel.setOpaque(false);

        return panel;
	}

}