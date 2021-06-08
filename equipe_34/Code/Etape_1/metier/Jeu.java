package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.Scanner;
import java.util.ArrayList;
import iut.algo.Clavier;

public class Jeu
{
    private String nomJoueurA;
    private String nomJoueurB;
    private Joueur joueurA;
    private Joueur joueurB;
    private Joueur gagnant;

    private Galaxie galaxie;

    private int numTour = 1;

    private boolean debutTour;

    private final String COULEURA = "Noir";
    private final String COULEURB = "Blanc";
    

    public Jeu()
    {
        System.out.println("Comment s'apelle le joueur A ?");
        this.nomJoueurA = Clavier.lireString();
        System.out.println("Comment s'apelle le joueur B ?");
        this.nomJoueurB = Clavier.lireString();

        this.joueurA = new Joueur(this.nomJoueurA, COULEURA);
        this.joueurB = new Joueur(this.nomJoueurB, COULEURB);

        this.galaxie = new Galaxie();

        this.galaxie.debutDePartie();
        //afficherGalaxie();
        
        while(this.joueurA.getNbAnneaux() < 8 && this.joueurB.getNbAnneaux() < 8)
        {
            String couleurSeigneur, nomSeigneur;
            debutTour = false;
            if(this.numTour % 2 != 0)
            {
                couleurSeigneur = COULEURA;
                nomSeigneur = this.nomJoueurA;
            }
            else
            {
                couleurSeigneur = COULEURB;
                nomSeigneur = this.nomJoueurB;
            } 
                
            while(this.debutTour == false)
            {
                char action, systemeSolaire;

                int cpt = 0 ;
                String affichage = " ";
                while (cpt < 4)
                {
                    System.out.println(this.galaxie.getSystemesSolaires().get(cpt).getNom()); 
                    System.out.println("        Nombre de planètes                  :   " + this.galaxie.getSystemesSolaires().get(cpt).getNbPlanete()                       + " planètes" ); 
                    System.out.println("        Le Joueur A contrôle                :   " + this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurA()                + " planète(s)");
                    System.out.println("        Le joueur B contrôle                :   " + this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurB()                + " planète(s)");
                    System.out.println("        Nombre de Planète(s) Disponible(s)  :   " + (this.galaxie.getSystemesSolaires().get(cpt).getNbPlanete() - 
                    (this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurA() + this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurB() ) ) + " planète(s)" );

                    System.out.println();
                    cpt ++;
                }

                System.out.println("Voulez-vous conquérir ou libérer une planète Seigneur " + nomSeigneur + " ? (C/l)");
                action = Clavier.lire_char();

                System.out.println("Donnez la première lettre du Système Solaire où effectué l'action :");
                systemeSolaire = Clavier.lire_char();

                if((action == 'C' || action == 'c' || action == 'L' || action == 'l') && 
                   (systemeSolaire == 'T' || systemeSolaire == 'U' || systemeSolaire == 'M' || systemeSolaire == 'Q') ||
                   (systemeSolaire == 't' || systemeSolaire == 'u' || systemeSolaire == 'm' || systemeSolaire == 'q'))
                {
                    debutTour= true;
                    action(couleurSeigneur, action, systemeSolaire);
                }
            }
            this.numTour++;
        }
        System.out.println("Partie terminé !");
        gagnant = determinerGagnant();
        System.out.println("Le Seigneur du Temps qui a remporté ka partie est " + gagnant.getNom());
        System.out.println("Félicitations !");
    }

    public void action ( String couleurSeigneur, char action, char systemeSolaire)
	{
        int numSystemSolaire = 0;
        String nomSystemeSolaire = " ";

        switch(systemeSolaire)
        {
            case 'T':
                nomSystemeSolaire="Triälum";
                break;
            case 't':
                nomSystemeSolaire="Triälum";
                break;
            case 'U':
                nomSystemeSolaire="Uninium";
                break;
            case 'u':
                nomSystemeSolaire="Uninium";
                break;
            case 'M':
                nomSystemeSolaire="Mervelléum";
                break;
            case 'm':
                nomSystemeSolaire="Mervelléum";
                break;
            case 'Q':
                nomSystemeSolaire="Quintum";
                break;
            case 'q':
                nomSystemeSolaire="Quintum";
                break;
        }

        while(nomSystemeSolaire != this.galaxie.getSystemesSolaires().get(numSystemSolaire).getNom())
        {
            numSystemSolaire++;
        }

        if(action == 'C')
        {
            if(couleurSeigneur == COULEURA)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurA) == true)
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire + 1).ajouterPlaneteJoueurA();
                }
                else
                    this.debutTour=false;
            }
            if(couleurSeigneur == COULEURB)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurB) == true)
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire + 1).ajouterPlaneteJoueurB();
                }
                else
                    this.debutTour=false;
            }
        }
        else
        {
            if(couleurSeigneur == COULEURA)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).libererPlanete(joueurA) == true)
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire + 1).libererPlaneteJoueurA();
                }
                this.debutTour=false;
            }
            if(couleurSeigneur == COULEURB)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).libererPlanete(joueurB) == true)
                {
                    this.galaxie.getSystemesSolaires().get(numSystemSolaire + 1).libererPlaneteJoueurB();
                }
                this.debutTour=false;
            }
        }
	}
    public Joueur determinerGagnant()
    {
        int cpt=0;
        int nbPlanetesJoueurA = 0;
        int nbPlanetesJoueurB = 0;
        while(cpt < this.galaxie.getSystemesSolaires().get(3).getPlanetes().size())
        {
            if(this.galaxie.getSystemesSolaires().get(3).getPlanetes().get(cpt).getProprietaire().getNom() == joueurA.getNom())
            {
                nbPlanetesJoueurA++;
            }
            else
            {
                nbPlanetesJoueurB++;
            }
            cpt++;
        }
        if(nbPlanetesJoueurA > nbPlanetesJoueurB)
        {
            return joueurA;
        }
        else
        {
            return joueurB;
        }
    }

    /*public String toString()
    {
        int cpt = 0 ;
        String affichage = " ";
        while (cpt < 4)
        {
           return String affichage = interger.toString(this.galaxie.getSystemesSolaires().get(cpt).getNom() + this.galaxie.getSystemesSolaires().get(cpt).getNbPlanete() + this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurA() + this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurB() + (this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurA() - this.galaxie.getSystemesSolaires().get(cpt).getNBPlaneteJoueurB() ) );
        }
    }*/
}
