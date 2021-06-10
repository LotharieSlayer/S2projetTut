package smallworld.metier;

import smallworld.*;


import java.util.List;
import java.util.ArrayList;

import java.awt.Point;


/** Cette Classe est le point d'entrée de la partie Metier.
  * elle est la cabine d'aiguillage entre les Territoire et les Peuple.
  *
  * Attention pour le Controleur le numero de Joueur et 1 ou 2
  *           dans la partie métier nous utilisons des Tableau, il faudra passer à 0 ou 1.
  *
  * @author Philippe Le Pivert
  */
public class Jeu implements java.io.Serializable
{
	private List<Territoire>  ensTerritoire;
	private Joueur[]          tabJoueur;
	private Peuple[]          tabPeuple;

	private String[]          tabMessage;


	public Jeu ()
	{
		this.ensTerritoire = Territoire.initMap();
		this.tabJoueur     = new Joueur[2];
		this.tabPeuple     = new Peuple[2];
		this.tabMessage    = new String[2];

		this.tabJoueur[0]  = new Joueur ("Spirou"   );
		this.tabJoueur[1]  = new Joueur ("Fantasio" );

		this.tabPeuple[0]  = new Peuple ( "Mage", "des Forêts",   9 );
		this.tabPeuple[1]  = new Peuple ( "Nain", "des Cavernes", 8 );
	}



	// Redonne le dernier Message affecté leors de la dernière action.
	public String getMessage ( int numJoueur )
	{
		return this.tabMessage[numJoueur-1];
	}


	public void action ( int numJoueur, char action, int numTerritoire )
	{
		// action [A]jouter [E]nlever

		switch ( action )
		{
			case 'A': // récupération du nombe de Territoire Occupée par un Peuple, pour règle de pose dans ajouterPeuple
			          int nb = this.getNbTerritoire(numJoueur);
			          this.tabMessage[numJoueur-1] = this.ensTerritoire.get(numTerritoire).ajouterPeuple ( this.tabPeuple[numJoueur-1], nb );
			          break;

			case 'E': // Enlever
					    this.tabMessage[numJoueur-1] = this.ensTerritoire.get(numTerritoire).enleverPeuple ( this.tabPeuple[numJoueur-1] );
					    break;

			default : this.tabMessage[numJoueur-1] = Message.ERR_ACTION_INVALID.getLib();
		}
	}


	/*-----------------------------------*/
	/* Méthodes liées aux Territoires    */
	/*-----------------------------------*/
	public int getNbTerritoire() { return this.ensTerritoire.size(); }

	public String getLibTerritoire(int numTerr)
	{
		return this.ensTerritoire.get(numTerr).getNature().getLib();
	}


	public String getLibPeupleTerr (int numTerr)
	{
		Peuple p = this.ensTerritoire.get(numTerr).getPeuple();

		if ( p==null) return null;

		return p.getNom();
	}

	// retourne une copie pour éviter les modifications
	public Point  getPointTerr     (int numTerr) { return new Point (this.ensTerritoire.get(numTerr).getPoint());  }

	public int    getNbPionTerr    (int numTerr) { return this.ensTerritoire.get(numTerr).getNbPion();        }

	/*-----------------------------------*/
	/* Méthodes liées au Joueur(Peuple)  */
	/*-----------------------------------*/

	/** Retourne le nombre de pion en Main du joueur numJoueur */
	public int getNbPionEnMain     ( int numJoueur )
	{
		return this.tabPeuple[numJoueur-1].getNbPionEnMain ();
	}

	/** Retourne le nombre de pion sur le Plateau du joueur numJoueur */
	public int getNbPionSurPlateau ( int numJoueur )
	{
		int nb = 0;

		for ( Territoire t : this.ensTerritoire )
		{
			if ( t.getPeuple() == this.tabPeuple[numJoueur-1] )
				nb += t.getNbPion();
		}

		return nb;
	}

	/** Retroune le nom du Peuple du joueur numJoueur */
	public String getLibPeuple ( int numJoueur )
	{
		return this.tabPeuple[numJoueur-1].getNom();
	}

	/** Retourne le nom du Joueur avec le nom et pouvoir de son Peuple */
	public String getLibJoueur ( int numJoueur )
	{
		return this.tabJoueur[numJoueur-1].getNom() + " " +
		       this.tabPeuple[numJoueur-1].getNom() + " " +
		       this.tabPeuple[numJoueur-1].getPouvoir();
	}

	/** Retourne le nombre de Territoire du Joueur numJoueur */
	public int   getNbTerritoire ( int numJoueur )
	{
		int nb=0;

		for ( Territoire t : this.ensTerritoire )
			if ( t.getPeuple() == this.tabPeuple[numJoueur-1] )
				nb++;

		return nb;
	}

	public SituationPlateau getSituationPlateau()
	{
		SituationPlateau sp = new SituationPlateau();

		sp.nbTerritoire = this.ensTerritoire.size();

		sp.infoTerritoire = new InfoTerritoire[sp.nbTerritoire];

		Point  p;
		String lib;
		int    nbPion;

		for (int cpt=0; cpt< sp.nbTerritoire; cpt++)
		{
			lib = this.getLibPeupleTerr(cpt);

			if ( lib != null )
			{
				lib    = "./images/pion_" + lib.toLowerCase() + ".png";
				p      = this.getPointTerr  ( cpt );
				nbPion = this.getNbPionTerr ( cpt );

				sp.infoTerritoire[cpt] = new InfoTerritoire ( lib, p, nbPion );
			}
		}

		return sp;

	}


}