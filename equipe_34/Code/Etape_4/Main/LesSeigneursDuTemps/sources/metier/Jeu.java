package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import java.util.ArrayList;
import iut.algo.Clavier;

public class Jeu
{
    private String  nomJoueurA;
    private String  nomJoueurB;

    private Joueur  joueurA;
    private Joueur  joueurB;
    private Joueur  gagnant;

    private Galaxie galaxie;

    private int     numTour = 1;
    private int     numPlaneteLibere = - 1; // - 1 Signifiant qu'il n'y a aucune planète libéré

    private boolean debutTour;

    private final String COULEURA = "Noir";
    private final String COULEURB = "Blanc";
    

    public Jeu()
    {
        System.out.println("Comment s'apelle le joueur A ?");
        this.nomJoueurA = "Francis";

        System.out.println("Comment s'apelle le joueur B ?");
        this.nomJoueurB = "Michel";

        this.joueurA = new Joueur (this.nomJoueurA, COULEURA);
        this.joueurB = new Joueur (this.nomJoueurB, COULEURB);

        this.galaxie = new Galaxie();

        this.galaxie.debutDePartie();
        //afficherGalaxie();
    }

    public void action ( String couleurSeigneur, char action, char systemeSolaire)
	{
        if(this.joueurA.getNbAnneaux() != 0 || this.joueurB.getNbAnneaux() != 0)
        {
            String nomSeigneur;
            debutTour = false;

            if(this.numTour % 2 != 0)
            {
                couleurSeigneur = COULEURA       ;
                nomSeigneur     = this.nomJoueurA;
            }
            else
            {
                couleurSeigneur = COULEURB       ;
                nomSeigneur     = this.nomJoueurB;
            } 
                
            while(this.debutTour == false)
            {

                if(this.numPlaneteLibere > -1)
                {
                    action = 'R'; //Action de replacer
                    System.out.println("Donnez la première lettre du Système Solaire où conquérir la planète :");
                }
                else
                {
                    System.out.println("Voulez-vous conquérir ou libérer une planète Seigneur " + nomSeigneur + " ? (C/l)");
                    //action = Clavier.lire_char();
                    System.out.println("Donnez la première lettre du Système Solaire où effectué l'action :");
                }

                if((action == 'C' || action == 'c' || action == 'L' || action == 'l' || action == 'R') && 
                   ((systemeSolaire == 'T' || systemeSolaire == 'U' || systemeSolaire == 'M' || systemeSolaire == 'Q') ||
                   (systemeSolaire == 't' || systemeSolaire == 'u' || systemeSolaire == 'm' || systemeSolaire == 'q')))
                {
                    debutTour= true;
                    actionDeux(couleurSeigneur, action, systemeSolaire);
                }
                else if(action == 'C' || action == 'c' || action == 'L' || action == 'l'){
                    System.out.println("Le système solaire sélectionné est incorrecte !");
                }
                else
                {
                    System.out.println("L'action sélectionné est incorrecte");
                } 
            }
            this.numTour++;
        }
        else
        {
            System.out.println("Partie terminé !");
            System.out.println(toString()        );
            gagnant = determinerGagnant()         ;
            System.out.println("Le Seigneur du Temps qui a remporté la partie est " + gagnant.getNom());
            System.out.println("Félicitations !" );
        }
	}

    public void actionDeux(String couleurSeigneur, char action, char systemeSolaire)
    {
        int numSystemSolaire     = 0  ;
        String nomSystemeSolaire = " ";

        switch(systemeSolaire)
        {
            case 'T':
                nomSystemeSolaire="Triälum"   ;
                break;
            case 't':
                nomSystemeSolaire="Triälum"   ;
                break;
            case 'U':
                nomSystemeSolaire="Uninium"   ;
                break;
            case 'u':
                nomSystemeSolaire="Uninium"   ;
                break;
            case 'M':
                nomSystemeSolaire="Mervelléum";
                break;
            case 'm':
                nomSystemeSolaire="Mervelléum";
                break;
            case 'Q':
                nomSystemeSolaire="Quintum"   ;
                break;
            case 'q':
                nomSystemeSolaire="Quintum"   ;
                break;
        }

        while(nomSystemeSolaire != this.galaxie.getSystemesSolaires().get(numSystemSolaire).getNom())
        {
            numSystemSolaire++;
        }

        if(action == 'C' || action == 'c')
        {

            if(couleurSeigneur == COULEURA)
            {
                
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurA, true) == true)
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
                else
                {
                    this.debutTour=false;
                }   
            }
            if(couleurSeigneur == COULEURB)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurB, true) == true)
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
                else
                    this.debutTour=false;
            }
        }
        else if (action == 'L' || action == 'l')
        {
            if(couleurSeigneur == COULEURA)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).libererPlanete(joueurA) == true)
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire ).libererPlaneteJoueurA();
                    this.numPlaneteLibere = numSystemSolaire;
                }
                this.debutTour=false;
            }
            if(couleurSeigneur == COULEURB)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).libererPlanete(joueurB) == true)
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire ).libererPlaneteJoueurB();
                    this.numPlaneteLibere = numSystemSolaire;
                }
                this.debutTour=false;
            }
        }
        else if(action == 'R')
        {

            if(couleurSeigneur == COULEURA)
            {

                if(numSystemSolaire < this.numPlaneteLibere)
                {
                    if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurA, false) == true)
                    {
                        this.numPlaneteLibere = -1;
                        this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurA();
                    }
                    else
                    {
                        this.debutTour=false;
                    }
                }
                else
                {
                    System.out.println("Erreur, le système solaire sélectionné est plus proche du centre de la Galaxie ou est le même que le système libéré");
                    this.debutTour=false;
                }
            }

            if(couleurSeigneur == COULEURB)
            {
                if(numSystemSolaire < this.numPlaneteLibere)
                {
                    if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurB, false) == true)
                    {
                        this.numPlaneteLibere = -1;
                        this.galaxie.getSystemesSolaires().get(numSystemSolaire).ajouterPlaneteJoueurB();
                    }
                    else
                    {
                        this.debutTour=false;
                    }      
                }
                else
                {
                    System.out.println("Le système solaire sélectionné est plus proche du centre de la Galaxie ou est le même que le système libéré");
                    this.debutTour=false;
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

    public Galaxie getGalaxie(){ return galaxie;      }
    public int     getTour()   { return this.numTour; }
    
    public String toString()
    {
        String s         = "";
        int cpt          = 0 ;
        while (cpt < 4)
        {
            s += String.format("%s", this.galaxie.getSystemesSolaires().get(cpt).getNom()) + "\n"    + 
             "        Nombre de planètes                  :   " + String.format("%d",this.galaxie.getSystemesSolaires().get(cpt).getNbPlanete())             + " planètes"   + "\n" + 
             "        Le Joueur A contrôle                :   " + String.format("%d", this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurA())     + " planète(s)" + "\n" +
             "        Le joueur B contrôle                :   " + String.format("%d", this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurB())     + " planète(s)" + "\n" +
             "        Nombre de Planète(s) Disponible(s)  :   " + String.format("%d", (this.galaxie.getSystemesSolaires().get(cpt).getNbPlanete() - 
                (this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurA() + this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurB() ) ) ) + " planète(s)" + "\n" ;

            cpt ++;        
        }
        return s;
    }
}
