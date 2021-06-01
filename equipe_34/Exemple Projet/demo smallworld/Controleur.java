package smallworld;

import smallworld.metier.Jeu;

import smallworld.ihm.FramePlateau;
import smallworld.ihm.FrameJoueur;

import java.io.*;
import java.awt.Point;


/** Cette classe permet de faire le lien entre la partie Metier et IHM.
  * Metier : Jeu  Territoire Joueur Peuple Nature Message
  * IHM    : FamePlateau/PanelPlateau  FrameJoueur/PanelJoueur
  *
  * @author Philippe Le Pivert
  */
public class Controleur
{
	public  static final String LANGUE = "FR";  // FR/ENG

	private Jeu          metier;

	private FramePlateau framePlateau;
	private FrameJoueur  frameJoueur1, frameJoueur2;

	public Controleur ( String fic)
	{
		if ( fic == null )
		{
			this.metier       = new Jeu ();
		}
		else
		{
			try
			{
				ObjectInputStream in = new ObjectInputStream( new FileInputStream( fic + ".data" ) );
				this.metier = (Jeu) in.readObject();
				in.close();
			}catch(Exception e){ e.printStackTrace(); }
		}

		this.framePlateau = new FramePlateau ( this );

		this.frameJoueur1 = new FrameJoueur  ( this, 1 );
		this.frameJoueur2 = new FrameJoueur  ( this, 2 );
	}


	public SituationPlateau getSituationPlateau()
	{
		return this.metier.getSituationPlateau();
	}


	/*
	public int getNbTerritoire()
	{
		return this.metier.getNbTerritoire();
	}
	*/

	public String getFond ()             { return "./images/plateau2J.jpg"; }

	public String getImagePeuple (int numJoueur)
	{
		String lib = this.metier.getLibPeuple ( numJoueur );

		lib = "./images/" + lib.toLowerCase() + ".png";

		return lib;
	}


	/*
	public InfoPion getInfoPion(int numTerr)
	{
		Point  p;
		String lib;
		int    nbPion;

		lib = this.metier.getLibPeupleTerr(numTerr);


		if ( lib == null ) return null;

		lib    = "./images/pion_" + lib.toLowerCase() + ".png";
		p      =  this.metier.getPointTerr ( numTerr );
		nbPion = this.metier.getNbPionTerr ( numTerr );

		return new InfoPion ( lib, p, nbPion );

	}*/

	// orig : P pour plateau  J pour Joueur
	public void moveFrame ( String orig )
	{
		java.awt.Point p;

		if ( orig.equals ("P") && this.framePlateau != null && this.frameJoueur1 != null && this.frameJoueur2 != null )
		{
			p = this.framePlateau.getLocation();
			this.frameJoueur1.setLocation ( p.x      ,p.y + 690 );
			this.frameJoueur2.setLocation ( p.x + 620,p.y + 690 );
		}
	}


	public int    getNbPionEnMain     ( int numJoueur ) { return this.metier.getNbPionEnMain    (numJoueur); }
	public int    getNbPionSurPlateau ( int numJoueur ) { return this.metier.getNbPionSurPlateau(numJoueur); }
	public String getLibJoueur        ( int numJoueur ) { return this.metier.getLibJoueur       (numJoueur); }
	public String getMessage          ( int numJoueur ) { return this.metier.getMessage         (numJoueur); }


	public String[] getListTerritoire ()
	{
		String[] tab = new String[this.metier.getNbTerritoire()];

		for ( int cpt=0 ; cpt<tab.length ; cpt++ )
			tab[cpt] = (cpt+1) + " " + this.metier.getLibTerritoire(cpt);

		return tab;
	}

	public void action ( int numJoueur, char action, int numTerritoire )
	{
		this.metier.action ( numJoueur, action, numTerritoire );

		if ( numJoueur == 1 ) this.frameJoueur1.maj();
		if ( numJoueur == 2 ) this.frameJoueur2.maj();

		this.framePlateau.maj();

	}

	public void fermer ()
	{
		this.frameJoueur1.dispose();
		this.frameJoueur2.dispose();

		// uniquement pour la constitution des scenarios
		/*
		try
		{
			ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("scenario_01.data") );
			out.writeObject(this.metier);
			out.close();
		}catch(Exception e){ e.printStackTrace(); }
		*/
	}

	public static void main(String[] a)
	{
		String fic = null;

		if ( a.length > 0 ) fic = a[0];

		new Controleur(fic);
	}

}