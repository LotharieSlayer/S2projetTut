package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.ArrayList;

public class Joueur 
{
    private String couleurSeigneur;

    private int    nbAnneaux = 8  ;

	public Joueur ( String couleurSeigneur )
	{
        this.couleurSeigneur = couleurSeigneur;
    }
    
    public static Joueur creerJoueur ( String nom, String couleurSeigneur )
	{
		if ( nom == null || couleurSeigneur != "Noir" && couleurSeigneur != "Blanc")  return null;

		return new Joueur (couleurSeigneur);
	}

    public int    getNbAnneaux()    { return this.nbAnneaux;       }
    public String getCouleur()      { return this.couleurSeigneur; }
    public void   conquerirPlanete(){ this.nbAnneaux--;            }
    public void   libererPlanete()  { this.nbAnneaux++;            }

}
