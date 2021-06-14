package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import javax.swing.*;
import java.awt.*;

public class StatutLabel
{
	public static JLabel label(String img)
	{
                Icon icon              = new ImageIcon(img);
                JLabel setIcon         = new JLabel(icon, JLabel.CENTER);

                setIcon.setOpaque(false);

                return setIcon;
	}

}