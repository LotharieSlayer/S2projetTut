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


public class PanelAnneaux extends JPanel
{
	// Attributs d'instance
	private Controleur ctrl    ;
	private String     fichier ;
	private Image      image   ;

	private JLabel     lblNoir ;
	private JLabel     lblBlanc;

	private JPanel pnlAnneauxBlanc = new JPanel( new GridLayout(1,8) );
	private JPanel pnlAnneauxNoir  = new JPanel( new GridLayout(1,8) );

	private JPanel pnlMain  = new JPanel( new GridLayout(2,1) );
	private JPanel pnlBlanc = new JPanel();
	private JPanel pnlNoir  = new JPanel();

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

		this.pnlBlanc.setBackground ( Color.WHITE );
		pnlNoir.setBackground  ( Color.WHITE );
		this.pnlAnneauxBlanc.setBackground ( Color.WHITE );
		this.pnlAnneauxNoir.setBackground  ( Color.WHITE );


		String      fName = "./fonts/FreePixel.ttf";
		InputStream fFont = PanelAnneaux.class.getResourceAsStream(fName);
		try 
		{
			Font font = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font smallFont = font.deriveFont(Font.PLAIN, 16);	
			this.lblNoir = new JLabel ( " Seigneur Noir ", JLabel.LEFT );
			this.lblNoir.setFont (smallFont); 
			this.lblBlanc = new JLabel (" Seigneur Blanc ", JLabel.LEFT);
			this.lblBlanc.setFont(smallFont); 
		}
		catch (IOException e)        { e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }


		/*----------------------------------------------*/
		/* Positionnement des Composants                */
		/*----------------------------------------------*/

		//Panel Gauche (Titre de la planète)
		this.pnlBlanc.add ( this.lblNoir );

		for(int i=0; i< ctrl.getJeu().getJoueurA().getNbAnneaux(); i++)
		{
			//Anneaux Noir
			try 
			{
				BufferedImage image    = ImageIO.read(new File("./images/action/anneau_noir.png"));
				JLabel        lblImage = new JLabel(new ImageIcon(image));
				this.pnlAnneauxNoir.add(lblImage);
			} 
			catch (IOException e) { e.printStackTrace();}
		}
		
		for(int i=0; i< ctrl.getJeu().getJoueurB().getNbAnneaux(); i++)
		{
			//Anneaux Blanc
			try 
			{
				BufferedImage image    = ImageIO.read(new File("./images/action/anneau_blanc.png"));
				JLabel        lblImage = new JLabel(new ImageIcon(image));
				this.pnlAnneauxBlanc.add(lblImage);
			} 
			catch (IOException e) { e.printStackTrace();}
		}
		
		this.pnlNoir.add(this.lblNoir)         ;
		this.pnlNoir.add(this.pnlAnneauxNoir)  ;
		this.pnlBlanc.add(this.lblBlanc)       ;
		this.pnlBlanc.add(this.pnlAnneauxBlanc);

		this.pnlMain.add ( this.pnlNoir  );
		this.pnlMain.add ( this.pnlBlanc );
		this.add ( this.pnlMain, BorderLayout.SOUTH );
	}

	public void maj(Controleur ctrl)
	{
		this.pnlAnneauxNoir.removeAll();
		this.pnlAnneauxBlanc.removeAll();

		//Panel Gauche (Titre de la planète)
		this.pnlBlanc.add ( this.lblNoir );

		for(int i=0; i< ctrl.getJeu().getJoueurA().getNbAnneaux(); i++)
		{
			//Anneaux Noir
			try 
			{
				BufferedImage image    = ImageIO.read(new File("./images/action/anneau_noir.png"));
				JLabel        lblImage = new JLabel(new ImageIcon(image));
				this.pnlAnneauxNoir.add(lblImage);
			} 
			catch (IOException e) { e.printStackTrace();}
		}
		
		for(int i=0; i< ctrl.getJeu().getJoueurB().getNbAnneaux(); i++)
		{
			//Anneaux Blanc
			try 
			{
				BufferedImage image    = ImageIO.read(new File("./images/action/anneau_blanc.png"));
				JLabel        lblImage = new JLabel(new ImageIcon(image));
				this.pnlAnneauxBlanc.add(lblImage);
			} 
			catch (IOException e) { e.printStackTrace();}
		}
		
		this.pnlNoir.add(lblNoir)         ;
		this.pnlNoir.add(this.pnlAnneauxNoir)  ;
		this.pnlBlanc.add(lblBlanc)       ;
		this.pnlBlanc.add(this.pnlAnneauxBlanc);
		
		this.repaint();


	}
}