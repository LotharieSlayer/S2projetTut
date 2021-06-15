package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;

import java.util.ArrayList;

import iut.algo.Clavier;

public class Jeu
{
    private Joueur  joueurA;
    private Joueur  joueurB;
    private Joueur  gagnant;

    private Galaxie galaxie;

    private int     numTour = 1;

    private boolean actionLibere = false;
    private int numSystemeSolaireLibere = -1;

    private final String COULEURA = "Noir";
    private final String COULEURB = "Blanc";
    

    public Jeu()
    {
        this.joueurA = new Joueur (COULEURA);
        this.joueurB = new Joueur (COULEURB);

        this.galaxie = new Galaxie();

        this.galaxie.debutDePartie();
    }

    public void actionTour ( String couleurSeigneur, char action, String planete)
	{
        if(this.numTour % 2 != 0)
        {
            couleurSeigneur = COULEURA       ;
        }
        else
        {
            couleurSeigneur = COULEURB       ;
        } 
        action(couleurSeigneur, action, planete);
        action = ' ';
  
        this.numTour++;
	}

    public void action(String couleurSeigneur, char action, String planete)
    {
        int numSystemSolaire     = 0  ;
        int numPlanete     = 0  ;

        String nomSystemeSolaire = " ";

        for (int i=0;i<this.galaxie.getSystemesSolaires().size();i++) {
            for (int j=0;j<this.galaxie.getSystemesSolaires().get(i).getPlanetes().size();j++) {
                if(planete == this.galaxie.getSystemesSolaires().get(i).getPlanetes().get(j).getNom()){ 
                    numSystemSolaire = i;
                    numPlanete = j;
                }
            }
        }

        if(action == 'C' || action == 'c')
        {
            if(couleurSeigneur == COULEURA)
            {
                this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurA, numPlanete);
                if(numSystemSolaire == 3)
                {  
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurA    ();
                }
                else
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire + 1).ajouterPlaneteJoueurA();
                }
            }
            if(couleurSeigneur == COULEURB)
            {
                this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurB, numPlanete);
                if(numSystemSolaire == 3)
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurB    ();
                }
                else
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire + 1).ajouterPlaneteJoueurB();
                }
            }
        }
        else if (action == 'L' || action == 'l')
        {
            if(couleurSeigneur == COULEURA)
            {
                this.galaxie.getSystemesSolaires().get(numSystemSolaire).libererPlanete(joueurA, numPlanete);
                this.galaxie.getSystemesSolaires().get(numSystemSolaire ).libererPlaneteJoueurA();
                this.numTour--;
                this.numSystemeSolaireLibere = numSystemSolaire;
                this.actionLibere = true;
            }
            if(couleurSeigneur == COULEURB)
            {
                this.galaxie.getSystemesSolaires().get(numSystemSolaire).libererPlanete(joueurB, numPlanete);
                this.galaxie.getSystemesSolaires().get(numSystemSolaire ).libererPlaneteJoueurB();
                this.numTour--;
                this.numSystemeSolaireLibere = numSystemSolaire;
                this.actionLibere = true;
            }
        }
        else if(action == 'R')
        {

            if(couleurSeigneur == COULEURA)
            {
                this.galaxie.getSystemesSolaires().get(numSystemSolaire).replacerPlanete(joueurA, numPlanete);
                this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurA();
                this.actionLibere = false;
            }
            if(couleurSeigneur == COULEURB)
            {
                this.galaxie.getSystemesSolaires().get(numSystemSolaire).replacerPlanete(joueurB, numPlanete);
                this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurB();
                this.actionLibere = false;
            }
        }
        else if(action == 'd' || action == 'D')
        {

            if(couleurSeigneur == COULEURA)
            {
                this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurB, numPlanete);
                if(numSystemSolaire == 3)
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurB();
                }
                else
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire + 1).ajouterPlaneteJoueurB();
                }
            }
            if(couleurSeigneur == COULEURB)
            {
                this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurA, numPlanete);
                if(numSystemSolaire == 3)
                {  
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurA();
                }
                else
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire + 1).ajouterPlaneteJoueurA();
                } 
            }
        }
    }

    public Joueur determinerGagnant()
    {
        if(this.galaxie.getSystemesSolaires().get(3).getNBPlaneteJoueurA() > this.galaxie.getSystemesSolaires().get(3).getNBPlaneteJoueurB())
        {
            return joueurA;
        }
        else
        {
            return joueurB;
        }
    }

    public boolean checkPlaneteLiberable(int numSystemeSolaire)
    {
        boolean checkPlaneteLiberable = false;
        if(numSystemeSolaire == 0)
        {
            checkPlaneteLiberable = false;
        }
        else
        {
            for (int i=0;i<numSystemeSolaire - 1;i++) {
                for (int j=0;j<this.galaxie.getSystemesSolaires().get(i).getPlanetes().size();j++) {
                    if(this.galaxie.getSystemesSolaires().get(i).getPlanetes().get(j).getProprietaire() == null){ 
                        checkPlaneteLiberable = true;
                    }
                }
            }
        }
        return checkPlaneteLiberable;
    }

    public int     getNumPlanete(String planete){

        int numSystemSolaire     = 0  ;
        int numPlanete     = 0  ;

        for (int i=0;i<this.galaxie.getSystemesSolaires().size();i++) {
            for (int j=0;j<this.galaxie.getSystemesSolaires().get(i).getPlanetes().size();j++) {
                if(planete == this.galaxie.getSystemesSolaires().get(i).getPlanetes().get(j).getNom()){ 
                    numPlanete = j;
                }
            }
        }
        return numPlanete;
    }

    public int     getNumSystemeSolaire(String planete){

        int numSystemeSolaire     = 0  ;
        int numPlanete     = 0  ;

        for (int i=0;i<this.galaxie.getSystemesSolaires().size();i++) {
            for (int j=0;j<this.galaxie.getSystemesSolaires().get(i).getPlanetes().size();j++) {
                if(planete == this.galaxie.getSystemesSolaires().get(i).getPlanetes().get(j).getNom()){ 
                    numSystemeSolaire = i;
                }
            }
        }
        return numSystemeSolaire;
    }
    public int getNumSystemeSolaireLibere() { return this.numSystemeSolaireLibere; }

    public Galaxie getGalaxie(){ return galaxie;      }
    public int     getTour()   { return this.numTour; }

    public boolean getActionLibere() { return this.actionLibere; }

    public Joueur     getJoueurA()   { return this.joueurA; }
    public Joueur     getJoueurB()   { return this.joueurB; }
}
