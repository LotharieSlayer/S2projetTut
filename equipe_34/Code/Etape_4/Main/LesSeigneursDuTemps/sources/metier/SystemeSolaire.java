package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.ArrayList;

public class SystemeSolaire 
{

    private String             nom      ;
    private int                nbPlanete;
    private int                nbA      ;
    private int                nbB      ;
    private ArrayList<Planete> planetes ;
    private Galaxie            galaxie  ;

	public SystemeSolaire (String nom, int nbPlanete, Galaxie galaxie)
	{
        this.nom       = nom                     ;
        this.nbPlanete = nbPlanete               ;
        this.galaxie   = galaxie                 ;
        this.planetes  = new ArrayList<Planete>();
    }

    public void ajouterPlanete(Planete planete)
    {
        planetes.add(planete);
    }

    public void conquerirPlanete(Joueur seigneurProprietaire, int numPlanete)
    {
        planetes.get(numPlanete).changerProprietaire(seigneurProprietaire);
        seigneurProprietaire.conquerirPlanete();
        galaxie.avancerSystemeSolaire(this); 
    } 

    public void libererPlanete(Joueur seigneurProprietaire, int numPlanete)
    {
        planetes.get(numPlanete).libererProprietaire();
        seigneurProprietaire.libererPlanete  ();
    }

    public String getNom()   { return this.nom             ;}
    public int getNbPlanete(){ return this.nbPlanete       ;}

    public void ajouterPlaneteJoueurA(){ this.nbA++        ;}
    public void ajouterPlaneteJoueurB(){ this.nbB++        ;}

    public void libererPlaneteJoueurA(){ this.nbA--        ;}
    public void libererPlaneteJoueurB(){ this.nbB--        ;}

    public int getNBPlaneteJoueurA(){ return this.nbA      ;}
    public int getNBPlaneteJoueurB(){ return this.nbB      ;}
    
    public ArrayList<Planete> getPlanetes(){return planetes;}
}