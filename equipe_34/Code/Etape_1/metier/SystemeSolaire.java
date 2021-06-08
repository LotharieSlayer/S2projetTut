package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.ArrayList;

public class SystemeSolaire {

    private String nom      ;
    private int    nbPlanete;
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

    public boolean conquerirPlanete(Joueur seigneurProprietaire)
    {
        int cpt = 0;
        while(planetes.get(cpt).getProprietaire() != null || cpt < planetes.size() - 1)
        {
            cpt++;
        }
        if(planetes.get(cpt).getProprietaire() == null)
        {
            planetes.get(cpt).changerProprietaire(seigneurProprietaire);
            seigneurProprietaire.conquerirPlanete();
            galaxie.avancerSystemeSolaire(this);
            System.out.println("Système déplacé !");
            return true;
        }
        else
        {
            System.out.println("Erreur, le système solaire séléctionné n'a plus de planèters de libre");
            return false;
        }
    }

    public void libererPlanete(Joueur seigneurProprietaire)
    {
        int cpt = 0;
        while(planetes.get(cpt).getProprietaire().getNom() != seigneurProprietaire.getNom() || cpt < planetes.size() - 1)
        {
            cpt++;
        }
        if(planetes.get(cpt).getProprietaire() != null)
        {
            planetes.get(cpt).libererProprietaire();
            seigneurProprietaire.libererPlanete();

        }
        else
            System.out.println("Erreur, le système solaire séléctionné n'a aucune planète contrôlé par vous !");
    }

    public String getNom(){ return this.nom; }
    
    public ArrayList<Planete> getPlanetes(){return planetes;}
}