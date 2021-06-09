package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

public class SystemeSolaire {

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
        this.galaxie = galaxie;
        this.planetes = new ArrayList<Planete>();
    }

    public void ajouterPlanete(Planete planete)
    {
        planetes.add(planete);
    };

    public boolean conquerirPlanete(Joueur seigneurProprietaire, boolean AvancerSystemeSolaire)
    {
        int cpt = 0;
        while(planetes.get(cpt).getProprietaire() != null && cpt < planetes.size() - 1)
        {
            cpt++;
        }
        if(planetes.get(cpt).getProprietaire() == null)
        {
            planetes.get(cpt).changerProprietaire(seigneurProprietaire);
            seigneurProprietaire.conquerirPlanete();
            if(AvancerSystemeSolaire == true){ galaxie.avancerSystemeSolaire(this); }
            return true;
        }
        else
        {
            System.out.println("Erreur, le système solaire séléctionné n'a plus de planètes de libre");
            return false;
        }
    }

    public boolean libererPlanete(Joueur seigneurProprietaire)
    {
        int cpt = 0;
        boolean planeteTrouve = false;
        while (planeteTrouve == false && cpt < planetes.size() - 1)
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
                cpt++;
        }
        if(planeteTrouve == true)
        {
            planetes.get(cpt).libererProprietaire();
            seigneurProprietaire.libererPlanete();
            return true;
        }
        else
            {
                System.out.println("Erreur, le système solaire séléctionné n'a aucune planète contrôlé par vous !");
                return false;
            }
    }

    public String getNom()   { return this.nom;       }
    public int getNbPlanete(){ return this.nbPlanete; }

    public void ajouterPlaneteJoueurA(){ this.nbA++;  }
    public void ajouterPlaneteJoueurB(){ this.nbB++;  }

    public void libererPlaneteJoueurA(){ this.nbA--;  }
    public void libererPlaneteJoueurB(){ this.nbB--;  }

    public int getNBPlaneteJoueurA(){ return this.nbA;}
    public int getNBPlaneteJoueurB(){ return this.nbB;}
    
    public ArrayList<Planete> getPlanetes(){return planetes;}
}