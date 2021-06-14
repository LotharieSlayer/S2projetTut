package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;
import java.io.*;

/*--------------------------------------------*/
/* Classe FrameJoueur                         */
/*--------------------------------------------*/

public class FrameJoueur extends JFrame
{
	private JPanel				 pnlMain;
	private JPanel				 pnlCoteLeft;
	private JPanel				 pnlCoteRight;
	private JPanel				 pnlFooter;
	private JPanel				 pnlFooterMilieu;

	private PanelJoueur          pnlJoueur;
	private PanelTitle 			 pnlTitle;
	private JPanel				 pnlStatut;
	private PanelAnneaux		 pnlAnneaux;
	private PanelAction			 pnlAction;
	
	/**
	 * Objet FrameJoueur JFrame (fenetre principal)
	 * @param ctrl Apporte la gestion avec le controleur
	 */
    public FrameJoueur(Controleur ctrl)
    {
		this.setLocation(160,50);
		
		this.setSize(1600,900)  ;
		this.setResizable(false);
		this.setTitle ( "Les Seigneurs du Temps" );
		
		/* ----------------------- */
		/* Création des composants */
		/* ----------------------- */

		this.pnlMain 		= new JPanel( new BorderLayout()  ); 	// this 	w/ Panel du haut
		this.pnlFooter 		= new JPanel( new GridLayout(1,3) ); 	// this 	w/ Panel du bas
		this.pnlTitle 		= new PanelTitle(ctrl);					// Main 	w/ Panel titre
		this.pnlStatut	 	= PanelStatut.panel("./images/msgStatut/RectangleN.png"); // Main 	w/ Panel tour, erreurs, winner
		this.pnlJoueur  	= new PanelJoueur  (ctrl);				// Main 	w/ Panel joueur où on joue
		this.pnlAnneaux 	= new PanelAnneaux(ctrl);				// Footer	w/ Panel des anneaux restants pour chaque joueurs 
		this.pnlAction 		= new PanelAction(ctrl);				// Footer 	w/ Panel des actions
		this.pnlCoteLeft 	= new JPanel();
		this.pnlCoteRight 	= new JPanel();

		// Size panels
		this.pnlFooter.setPreferredSize(new Dimension(1600, 160));
		this.pnlTitle.setPreferredSize(new Dimension(1600,150));
		this.pnlStatut.setPreferredSize(new Dimension(1600,225));
		this.pnlCoteLeft.setPreferredSize(new Dimension(80,0));
		this.pnlCoteRight.setPreferredSize(new Dimension(80,0));

		this.pnlCoteLeft.setBackground(Color.WHITE);
		this.pnlMain.setBackground(Color.WHITE);
		this.pnlCoteRight.setBackground(Color.WHITE);


		/* ---------------------------- */
		/* Postionnement des composants */
		/* ---------------------------- */

		this.pnlMain.add(this.pnlTitle ,    BorderLayout.NORTH );
		this.pnlMain.add(this.pnlJoueur,    BorderLayout.CENTER);
		this.pnlMain.add(this.pnlCoteLeft,  BorderLayout.WEST  );
		this.pnlMain.add(this.pnlCoteRight, BorderLayout.EAST  );

		this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);

		this.pnlFooter.add(this.pnlAnneaux, BorderLayout.WEST);
		this.pnlFooter.add(this.pnlAction, BorderLayout.EAST);

		this.add(this.pnlMain);
		this.add(this.pnlFooter, BorderLayout.SOUTH);
		

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);
	}

	/**
	 * Méthode qui permet de mettre à jour l'interface.
	 * @param ctrl Apporte la gestion avec le controleur
	 */
	public void maj(Controleur ctrl)
	{
		this.setTour(ctrl);
		this.pnlJoueur.maj(ctrl);
		this.pnlAnneaux.maj(ctrl);

		if(ctrl.determinerGagnant() != null)
		{
			System.out.println("Gagnant");
		}
	}

	/**
	 * Méthode qui permet de dire à qui est le tour en affichant le message.
	 * @param ctrl Apporte la gestion avec le controleur
	 */
	public void setTour(Controleur ctrl)
	{
		if(ctrl.getTour() % 2 != 0)
		{
			this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);/* 
			this.pnlStatutN.setVisible(true );
			this.pnlStatutB.setVisible(false); */
		}
		else
		{
			this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH); /* 
			this.pnlStatutN.setVisible(false);
			this.pnlStatutB.setVisible(true ); */
		}
	}
}
