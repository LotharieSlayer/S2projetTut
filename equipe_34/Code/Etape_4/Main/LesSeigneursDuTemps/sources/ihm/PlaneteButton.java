package equipe_34.lesSeigneursDuTemps.ihm;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Dimension;

/*--------------------------------------------*/
/* Classe PlaneteButton                       */
/*--------------------------------------------*/
public class PlaneteButton
{
    /**
	 * Permet l'affichage de chaque bouton.
	 * @param x Position X en int
	 * @param y Position Y en int
	 * @param image L'image de la planète qui sera sur le bouton.
	 */
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