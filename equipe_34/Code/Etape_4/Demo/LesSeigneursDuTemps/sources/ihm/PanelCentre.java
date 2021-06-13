package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

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

public class PanelCentre extends JPanel
{
	// Attributs d'instance
	private Controleur ctrl      ;
	private String     fichier   ;
	private Image      image     ;

	private JLabel     lblPlanete;

	/*--------------*/
	/* Constructeur */
	/*--------------*/

	public PanelCentre(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		this.setLayout ( new GridLayout(2,0) );


		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/

		String      fName = "./fonts/FreePixel.ttf";
		InputStream fFont = PanelCentre.class.getResourceAsStream(fName);
		try 
		{
			Font font       = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font smallFont  = font.deriveFont(Font.PLAIN, 24           );	
			this.lblPlanete = new JLabel ( " Centre ", SwingConstants.SOUTH_EAST  );
			this.lblPlanete.setFont(smallFont); 
		}
		catch (IOException e)        { e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }


		/*----------------------------------------------*/
		/* Positionnement des Composants                */
		/*----------------------------------------------*/

		JPanel panelHaut  = new JPanel();
		JPanel panelBas   = new JPanel();
		panelHaut.setBackground ( Color.WHITE );
		panelBas.setBackground  ( Color.WHITE );
		
		//Panel Haut (Image selon objet Planète)
		try 
		{
			BufferedImage image    = ImageIO.read(new File("./images/systemes/Centre.png"));
			JLabel        lblImage = new JLabel(new ImageIcon(image), SwingConstants.SOUTH_EAST );
			panelBas.add(lblImage);
		} 
		catch (IOException e) { e.printStackTrace(); }

		//Panel Bas (Titre de la planète)
		panelBas.add ( this.lblPlanete, BorderLayout.CENTER );

		this.add     ( panelHaut );
		this.add     ( panelBas  );
	}
}