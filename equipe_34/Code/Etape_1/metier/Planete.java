package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.*;
public class Planete {

    private static int numPlanete;
    private String nom;
    private SystemeSolaire systemeSolaire;
    private Joueur seigneurProprietaire;

	public Planete(String nom, SystemeSolaire systemeSolaire)
	{
        this.nom = nom;
        this.systemeSolaire = systemeSolaire;
    }

    public String getNom(){ return this.nom; }

    public SystemeSolaire getSystemeSolaire(){ return this.systemeSolaire; }

    public void changerProprietaire(Joueur seigneurProprietaire){
        this.seigneurProprietaire = seigneurProprietaire;
    }

    public void libererPlanete()
    {
        this.seigneurProprietaire = null;
    }

	/*public String toString ()
	{
        System.out.println("Diapo" + this.iNumDiapo);

        int cpt = 0;
        while(cpt < nbElements){
            System.out.println("\t" + cpt + " " + alElement.get(cpt));
        }
    }*/
}
