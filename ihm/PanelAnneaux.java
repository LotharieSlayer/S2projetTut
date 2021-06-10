package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.Controleur;

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

import javax.swing.*;


public class PanelAnneaux extends JPanel
{
	// Attributs d'instance
	private Controleur ctrl;
	private String fichier;
	private Image image;

	private JLabel lblNoir;
	private JLabel lblBlanc;

	/*--------------*/
	/* Constructeur */
	/*--------------*/

	public PanelAnneaux(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		this.setLayout ( new BorderLayout() );


		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/

		JPanel pnlBlanc = new JPanel();
		JPanel pnlNoir = new JPanel();
		JPanel pnlAnneauxBlanc = new JPanel( new GridLayout(1,8) );
		JPanel pnlAnneauxNoir = new JPanel( new GridLayout(1,8) );
		pnlBlanc.setBackground  ( Color.WHITE );
		pnlNoir.setBackground  ( Color.WHITE );
		pnlAnneauxBlanc.setBackground  ( Color.WHITE );
		pnlAnneauxNoir.setBackground  ( Color.WHITE );


		String fName = "./assets/fonts/FreePixel.ttf";
		InputStream fFont = PanelAnneaux.class.getResourceAsStream(fName);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font smallFont = font.deriveFont(Font.PLAIN, 16);	
			this.lblNoir = new JLabel ( " Seigneur Noir ", JLabel.LEFT );
			this.lblNoir.setFont(smallFont); 
			this.lblBlanc = new JLabel ( " Seigneur Blanc ", JLabel.LEFT );
			this.lblBlanc.setFont(smallFont); 

	
		}
		catch (IOException e){ e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }


		/*----------------------------------------------*/
		/* Positionnement des Composants                */
		/*----------------------------------------------*/

		JPanel pnlAnneaux  = new JPanel();
		pnlAnneaux.setBackground ( Color.WHITE );

		//Panel Gauche (Titre de la planète)
		pnlBlanc.add ( this.lblNoir );
		
		for(int i=0; i<8; i++){
			//Anneaux Blanc
			try {
				BufferedImage image = ImageIO.read(new File("ihm/assets/action/anneau_blanc.png"));
				JLabel lblImage = new JLabel(new ImageIcon(image));
				pnlAnneauxBlanc.add(lblImage);
			} catch (IOException e) { e.printStackTrace(); }
		}

		for(int i=0; i<8; i++){
			//Anneaux Noir
			try {
				BufferedImage image = ImageIO.read(new File("ihm/assets/action/anneau_noir.png"));
				JLabel lblImage = new JLabel(new ImageIcon(image));
				pnlAnneauxNoir.add(lblImage);
			} catch (IOException e) { e.printStackTrace(); }
		}


		pnlNoir.add(lblNoir);
		pnlNoir.add(pnlAnneauxNoir);
		pnlBlanc.add(lblBlanc);
		pnlBlanc.add(pnlAnneauxBlanc);

		this.add ( pnlNoir, BorderLayout.NORTH  );
		this.add ( pnlBlanc, BorderLayout.SOUTH  );

	}
}