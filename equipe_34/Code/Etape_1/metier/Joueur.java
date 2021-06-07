package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.ArrayList;

public class Joueur {

    private String nom;
    private String couleurSeigneur;
    private int nbAnneaux;

    //private ArrayList<Planete> planetesControlees;

	public Joueur ( String nom, String couleurSeigneur )
	{
        this.nom = nom;
        this.couleurSeigneur = couleurSeigneur;
    }
    
    public static Joueur creerJoueur ( String nom, String couleurSeigneur )
	{
		if ( nom == null || couleurSeigneur != "Noir" && couleurSeigneur != "Blanc")  return null;

		return new Joueur (nom, couleurSeigneur);
	}

    public String getNom() { return this.nom; }

    public int getNbAnneaux() { return this.nbAnneaux;}

    public String getCouleur() { return this.couleurSeigneur; }

    public void conquerirPlanete(){ this.nbAnneaux = this.nbAnneaux--; };

    public void libererPlanete(){ this.nbAnneaux = this.nbAnneaux++; };

}
