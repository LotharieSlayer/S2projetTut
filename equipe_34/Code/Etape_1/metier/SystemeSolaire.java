package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.ArrayList;

public class SystemeSolaire {

    private String nom     ;
    private int    nbPlanete;

	public SystemeSolaire (String nom, int nbPlanete)
	{
        this.nom      = nom     ;
        this.nbPlanete = nbPlanete;
    }

    public SystemeSolaire creerSystemeSolaire (String nom, int nbPlanete)
    {
    		if (nom != "Triälum" || nom != "Uninium" || nom != "Mervelléum" || nom != "Quintum") return null;
            else return new SystemeSolaire(nom, nbPlanete);
    }

    public String getNom(){ return this.nom; }

	/*public String toString ()
	{
    }*/
}