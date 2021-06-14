package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

public class SystemeSolaire 
{
    private String nom      ;
    private int    nbPlanete;
    private int    nbA;
    private int    nbB;
    private ArrayList<Planete> planetes;
    private Galaxie galaxie;

	public SystemeSolaire (String nom, int nbPlanete, Galaxie galaxie)
	{
        this.nom       = nom      ;
        this.nbPlanete = nbPlanete;
        this.galaxie   = galaxie;
        this.planetes  = new ArrayList<Planete>();
    }

    public void ajouterPlanete(Planete planete)
    {
        planetes.add(planete);
    }

    //methode permettant de verifier si une planete peut appartenir a un joueur et retourne un message d'erreur si elle n'est pas disponible
    public boolean conquerirPlanete(Joueur seigneurProprietaire, boolean AvancerSystemeSolaire)
    {
        int cpt = 0;
        while(planetes.get(cpt).getProprietaire() != null && cpt < planetes.size() - 1)
        {
            cpt++;
        }
        if(planetes.get(cpt).getProprietaire() == null)
        {
            planetes.get(cpt).changerProprietaire(seigneurProprietaire);               //ajoute un proprietaire a la planete
            seigneurProprietaire.conquerirPlanete();
            if(AvancerSystemeSolaire == true){ galaxie.avancerSystemeSolaire(this); }  //verifier la position du systeme solaire et le raproche sur centre de la galaxie si c'est possible
            return true;
        }
        else
        {
            System.out.println("Erreur, le système solaire séléctionné n'a plus de planètes de libre"); //message d'erreur
            return false;
        }
    }

    //methode permettant de verifier si une planete peut etre liberer de son proprietaire et retourne un message d'erreur si ce n'est pas le cas
    public boolean libererPlanete(Joueur seigneurProprietaire)
    {
        int cpt = 0;
        boolean planeteTrouve = false;
        while (planeteTrouve == false && cpt < planetes.size() - 1) //tans que la planete n'est pas trouvée on continue de parcourir les planetes
        {
            if(planetes.get(cpt).getProprietaire() == null)
            {
                cpt++;
            }
            else if (planetes.get(cpt).getProprietaire() == seigneurProprietaire)
            {
                planeteTrouve = true;
            }
            else
            {
                cpt++;
            }
        }
        if(planeteTrouve == true)  // si la planete existe avec le bon proprietaire alors on lui retire son proprietaire
        {
            planetes.get(cpt).libererProprietaire();
            seigneurProprietaire.libererPlanete();
            return true;
        }
        else
        {
            System.out.println("Erreur, le système solaire séléctionné n'a aucune planète contrôlé par vous !"); //message d'erreur
            return false;
        }
    }

    //methode retournant un valeur simple propre a Systeme solaire
    public String getNom()                 { return this.nom;       }
    public int    getNbPlanete()           { return this.nbPlanete; }
    public int    getNBPlaneteJoueurA()    { return this.nbA;}
    public int    getNBPlaneteJoueurB()    { return this.nbB;}
    public ArrayList<Planete> getPlanetes(){return planetes;}

    //methode permettant de compter les planetes de chaque joueur au fure et à mesure des actions de la parties
    public void   ajouterPlaneteJoueurA(){ this.nbA++;  }
    public void   ajouterPlaneteJoueurB(){ this.nbB++;  }
    public void   libererPlaneteJoueurA(){ this.nbA--;  }
    public void   libererPlaneteJoueurB(){ this.nbB--;  }
}