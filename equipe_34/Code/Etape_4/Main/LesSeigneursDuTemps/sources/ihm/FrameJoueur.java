package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
	private JPanel				 pnlStatut;

	private PanelJoueur          pnlJoueur;
	private PanelTitle 			 pnlTitle;
	private PanelAnneaux		 pnlAnneaux;
	private PanelAction			 pnlAction;

	private JLabel				 lblStatut;

	private Icon				 tIcon1; 
	private Icon				 tIcon2; 
	private Icon				 tIcon3; 
	private Icon				 tIcon4; 
	private Icon				 tIcon5; 
	private Icon				 tIcon6; 
	private Icon				 tIcon7; 
	private Icon				 tIcon8; 
	private Icon				 tIcon9; 
	private Icon				 tIcon10; 
	private Icon				 tIcon11; 
	
	
	/**
	 * Objet FrameJoueur JFrame (fenetre principal)
	 * @param ctrl Apporte la gestion avec le controleur
	 */
    public FrameJoueur(Controleur ctrl)
    {
		this.tIcon1 = new ImageIcon("./images/msgStatut/RectangleN.png");
		this.tIcon2 = new ImageIcon("./images/msgStatut/RectangleB.png");
		this.tIcon3 = new ImageIcon("./images/msgStatut/winNoir.gif");
		this.tIcon4 = new ImageIcon("./images/msgStatut/winBlanc.gif");
		this.tIcon5 = new ImageIcon("./images/erreurs/1-noPlanetSelected.png");
		this.tIcon6 = new ImageIcon("./images/erreurs/2-conquerirAfterRelease.png");
		this.tIcon7 = new ImageIcon("./images/erreurs/3-systemTropProcheOuSystemeLibere.png");
		this.tIcon8 = new ImageIcon("./images/erreurs/4-planetAlreadyTaken.png");
		this.tIcon9 = new ImageIcon("./images/erreurs/5-noControlPlanet.png");
		this.tIcon10 = new ImageIcon("./images/erreurs/6-noMoreRings.png");
		this.tIcon11 = new ImageIcon("./images/erreurs/7-noMoreRingsRival.png");

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
		this.pnlJoueur  	= new PanelJoueur  (ctrl);				// Main 	w/ Panel joueur où on joue
		this.pnlAnneaux 	= new PanelAnneaux(ctrl);				// Footer	w/ Panel des anneaux restants pour chaque joueurs 
		this.pnlAction 		= new PanelAction(ctrl);				// Footer 	w/ Panel des actions
		this.pnlStatut	 	= new JPanel();							// Main 	w/ Panel tour, erreurs, winner
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
		this.pnlStatut.setBackground(Color.WHITE);
		this.pnlFooter.setBackground(Color.WHITE);

		this.lblStatut = StatutLabel.label("./images/msgStatut/RectangleN.png");


		/* ---------------------------- */
		/* Postionnement des composants */
		/* ---------------------------- */

		this.pnlMain.add(this.pnlTitle ,    BorderLayout.NORTH );
		this.pnlMain.add(this.pnlJoueur,    BorderLayout.CENTER);
		this.pnlMain.add(this.pnlCoteLeft,  BorderLayout.WEST  );
		this.pnlMain.add(this.pnlCoteRight, BorderLayout.EAST  );

		this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);

		this.pnlStatut.add(this.lblStatut);

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

		System.out.println(ctrl.getJeu().getJoueurA().getNbAnneaux());
		System.out.println(ctrl.getJeu().getJoueurB().getNbAnneaux());
		
		this.afficherErreur(ctrl, ctrl.getErreur());

		if(ctrl.determinerGagnant() == ctrl.getJoueurA())
		{
			this.pnlAnneaux.setVisible(false);
			this.pnlAction.setVisible(false);
			this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
			this.lblStatut.setIcon( this.tIcon3 );
		}
		else if(ctrl.determinerGagnant() == ctrl.getJoueurB())
		{
			this.pnlAnneaux.setVisible(false);
			this.pnlAction.setVisible(false);
			this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
			this.lblStatut.setIcon( this.tIcon4 );
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
			this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
			this.lblStatut.setIcon( this.tIcon1 );
		}
		else
		{
			this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
			this.lblStatut.setIcon( this.tIcon2 );
		}
	}

	public void afficherErreur(Controleur ctrl,int numMessage){
		switch(numMessage){
			case 1:
				this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
				this.lblStatut.setIcon( this.tIcon5 );
				break;
			case 2:
				this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
				this.lblStatut.setIcon( this.tIcon6 );
				break;
			case 3:
				this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
				this.lblStatut.setIcon( this.tIcon7 );
				break;
			case 4:
				this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
				this.lblStatut.setIcon( this.tIcon8 );
				break;
			case 5:
				this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
				this.lblStatut.setIcon( this.tIcon9 );
			case 6:
				this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
				this.lblStatut.setIcon( this.tIcon10 );
				break;
			case 7:
				this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
				this.lblStatut.setIcon( this.tIcon11 );
				break;
		}
		ctrl.setErreur(0);
	}
}
