package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;

import java.util.ArrayList;

public class Joueur 
{
    private String couleurSeigneur;

    private int    nbAnneaux = 8  ;

    //private ArrayList<Planete> planetesControlees;

	public Joueur ( String couleurSeigneur )
	{
        this.couleurSeigneur = couleurSeigneur;
    }
    
    public static Joueur creerJoueur ( String couleurSeigneur )
	{
		if (couleurSeigneur != "Noir" && couleurSeigneur != "Blanc")  return null;

		return new Joueur (couleurSeigneur);
	}

    public String getCouleur()      { return this.couleurSeigneur; }
    public void   conquerirPlanete(){ this.nbAnneaux--;            }
    public void   libererPlanete()  { this.nbAnneaux++;            }
    public int    getNbAnneaux()    { return this.nbAnneaux;       }


}