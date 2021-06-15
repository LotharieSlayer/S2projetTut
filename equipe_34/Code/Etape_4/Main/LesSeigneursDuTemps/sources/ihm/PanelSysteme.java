package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.Controleur;


import javax.imageio.ImageIO;

import java.io.InputStream;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FontFormatException;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*--------------------------------------------*/
/* Classe PanelSysteme                        */
/*--------------------------------------------*/
public class PanelSysteme extends JPanel
{
	private Controleur         ctrl   ;
	private JPanel		       pnlMain;

	private PanelSelectSysteme panelSelectSysteme       ;
	private JLabel			   lblPlanete = new JLabel();

	public PanelSysteme( Controleur ctrl, int NumPlaceSysteme)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		this.setLayout( new BorderLayout() );

		this.panelSelectSysteme = new PanelSelectSysteme(this.ctrl, NumPlaceSysteme);

			
		//Création et attribution de la font sur le JLabel Subtitle
		String      fName = "./fonts/Montserrat/Montserrat-Bold.ttf"           ;
		InputStream fFont = PanelSelectSysteme.class.getResourceAsStream(fName);
		try 
		{
			Font font    = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font bigFont = font.deriveFont(Font.PLAIN, 42);
			
			this.lblPlanete.setText(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom());
			this.lblPlanete.setHorizontalAlignment(JLabel.CENTER);
			this.lblPlanete.setFont(bigFont);
			this.lblPlanete.setForeground(Color.BLACK);

		}
		catch (IOException e)        { e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }

		this.add(this.panelSelectSysteme, BorderLayout.CENTER);
		this.add(this.lblPlanete, BorderLayout.SOUTH);
	}

	/**
	 * Méthode qui permet de mettre à jour l'interface.
	 * @param ctrl Apporte la gestion avec le controleur
	 */
	public void maj(Controleur ctrl, int NumPlaceSysteme)
	{
		this.panelSelectSysteme.maj(ctrl, NumPlaceSysteme);
		this.lblPlanete.setText(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom());
	}
}