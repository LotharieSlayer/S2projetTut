import java.awt.*;
import java.awt.image.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;

import java.io.*;
import javax.imageio.ImageIO;

import equipe_34.lesSeigneursDuTemps.metier.*;

import javax.swing.*;

/*--------------------------------------------------------------*/
/* PanelSelctCouleur                                            */
/*--------------------------------------------------------------*/
public class PanelCentre extends JPanel
{
	// Attributs d'instance
	private Controleur ctrl;
	private String fichier;
	private Image image;

	private JLabel lblPlanete;

	/*--------------*/
	/* Constructeur */
	/*--------------*/

	// Ce Panel est constitué de deux sous-Panel que je définie directement,
	// dans le constructeur sans passer par des nouvelles classes.
	//
	// Le type correspond à une des trois constante de classe ROUGE VERT BLEU

	public PanelCentre()
	{
		//this.pl                    = pl;
		//this.ctrl                  = ctrl;
		this.setBackground(Color.WHITE);
		this.setLayout ( new GridLayout(2,0) );


		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/

		String fName = "./assets/fonts/FreePixel.ttf";
		InputStream fFont = PanelMessageStatut.class.getResourceAsStream(fName);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font smallFont = font.deriveFont(Font.PLAIN, 24);	
			this.lblPlanete = new JLabel ( " Centre ", JLabel.CENTER );
			this.lblPlanete.setFont(smallFont); 

	
		}
		catch (IOException e){ e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }


		/*----------------------------------------------*/
		/* Positionnement des Composants                */
		/*----------------------------------------------*/

		JPanel panelHaut  = new JPanel();
		JPanel panelBas   = new JPanel();
		panelHaut.setBackground ( Color.WHITE );
		panelBas.setBackground  ( Color.WHITE );
		
		//Panel Haut (Image selon objet Planète)
		try {
			BufferedImage image = ImageIO.read(new File("assets/systemes/Centre.png"));
			JLabel lblImage = new JLabel(new ImageIcon(image));
			panelHaut.add(lblImage);
		} catch (IOException e) { e.printStackTrace(); }

		//Panel Bas (Titre de la planète)
		panelBas.add ( this.lblPlanete, BorderLayout.CENTER );

		this.add ( panelHaut );
		this.add ( panelBas  );

	}
}