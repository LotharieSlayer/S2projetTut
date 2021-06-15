package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import java.util.ArrayList;
import iut.algo.Clavier;

public class Jeu
{
    private Joueur  joueurA;
    private Joueur  joueurB;
    private Joueur  gagnant;

    private Galaxie galaxie;

    private int     numTour = 1;
    private int     numPlaneteLibere = - 1; // - 1 Signifiant qu'il n'y a aucune planète libéré

    private boolean actionLibere = false;

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
                
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurA, numPlanete, true) == true)
                {
                    if(numSystemSolaire == 3)
                    {  
                        this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurA    ();
                    }
                    else
                    {
                        this.galaxie.getSystemesSolaires().get(numSystemSolaire + 1).ajouterPlaneteJoueurA();
                    }
                }
            }
            if(couleurSeigneur == COULEURB)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurB, numPlanete, true) == true)
                {
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
        }
        else if (action == 'L' || action == 'l')
        {
            if(couleurSeigneur == COULEURA)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).libererPlanete(joueurA, numPlanete) == true)
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire ).libererPlaneteJoueurA();
                    this.numPlaneteLibere = numSystemSolaire;
                    this.actionLibere = true;
                    this.numTour--;
                }
            }
            if(couleurSeigneur == COULEURB)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).libererPlanete(joueurB, numPlanete) == true)
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire ).libererPlaneteJoueurB();
                    this.numPlaneteLibere = numSystemSolaire;
                    this.actionLibere = true;
                    this.numTour--;
                }
            }
        }
        else if(action == 'R')
        {

            if(couleurSeigneur == COULEURA)
            {

                if(numSystemSolaire < this.numPlaneteLibere)
                {
                    if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurA, numPlanete, false) == true)
                    {
                        this.numPlaneteLibere = -1;
                        this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurA();
                        this.actionLibere = true;
                    }
                }
                else
                {
                    System.out.println("Erreur, le système solaire sélectionné est plus proche du centre de la Galaxie ou est le même que le système libéré");
                }
            }

            if(couleurSeigneur == COULEURB)
            {
                if(numSystemSolaire < this.numPlaneteLibere)
                {
                    if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurB, numPlanete, false) == true)
                    {
                        this.numPlaneteLibere = -1;
                        this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurB();
                        this.actionLibere = true;
                    }
                }
                else
                {
                    System.out.println("Le système solaire sélectionné est plus proche du centre de la Galaxie ou est le même que le système libéré");
                }
            }
        }
        else if(action == 'd' || action == 'D')
        {

            if(couleurSeigneur == COULEURA)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurB, numPlanete, true) == true)
                {
                    if(numSystemSolaire == 3)
                    {
                        this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurB();
                    }
                    else
                    {
                        this.galaxie.getSystemesSolaires().get(numSystemSolaire + 1).ajouterPlaneteJoueurB();
                    }
                }
            }
            if(couleurSeigneur == COULEURB)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurA, numPlanete, true) == true)
                {
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

    public Galaxie getGalaxie(){ return galaxie;      }
    public int     getTour()   { return this.numTour; }

    public boolean getActionLibere() { return this.actionLibere; }

    public Joueur     getJoueurA()   { return this.joueurA; }
    public Joueur     getJoueurB()   { return this.joueurB; }
}
