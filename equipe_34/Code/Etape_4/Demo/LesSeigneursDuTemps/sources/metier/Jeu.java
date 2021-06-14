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
    private boolean actionLibere = false;

    private final String COULEURA = "Noir";
    private final String COULEURB = "Blanc";
    

    public Jeu()
    {
        this.nomJoueurA = "Francis";

        this.nomJoueurB = "Michel";

        this.joueurA = new Joueur (this.nomJoueurA, COULEURA);
        this.joueurB = new Joueur (this.nomJoueurB, COULEURB);

        this.galaxie = new Galaxie();

        this.galaxie.debutDePartie();
    }

    public Jeu(Scanner sc1)
    {   
        this.data = Decomposer(sc1);

        this.joueurA = new Joueur(this.nomJoueurA, COULEURA);
        this.joueurB = new Joueur(this.nomJoueurB, COULEURB);

        this.galaxie = new Galaxie();

        this.galaxie.debutDePartie(true, this.data, this.joueurA, this.joueurB);
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
  
            if((action == 'C' || action == 'c' || action == 'L' || action == 'l' || action == 'R'|| action == 'd' || action == 'D' ) && 
                ((systemeSolaire == 'T' || systemeSolaire == 'U' || systemeSolaire == 'M' || systemeSolaire == 'Q') ||
                (systemeSolaire == 't' || systemeSolaire == 'u' || systemeSolaire == 'm' || systemeSolaire == 'q')))
            {
                debutTour= true;
                actionDeux(couleurSeigneur, action, systemeSolaire);
                action = ' ';
            }
            else if(action == 'C' || action == 'c' || action == 'L' || action == 'l' || action == 'd' || action == 'D'){
                System.out.println("Le système solaire sélectionné est incorrecte !");
            }
            else
            {
                 System.out.println("L'action sélectionné est incorrecte");
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
                    this.actionLibere = true;
                    this.numTour--;
                }
            }
            if(couleurSeigneur == COULEURB)
            {
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).libererPlanete(joueurB) == true)
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
                    if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurA, false) == true)
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
                    if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurB, false) == true)
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
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurB, true) == true)
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
                if(this.galaxie.getSystemesSolaires().get(numSystemSolaire).conquerirPlanete(joueurA, true) == true)
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

    public String[][] Decomposer(Scanner sc1)
    {
        String[] noms = sc1.nextLine().split("/");
        this.nomJoueurA = noms[0];
        this.nomJoueurB = noms[1];

        String[][] systemes = new String[4][3];
        int cptSystemes = 0;
        while(sc1.hasNextLine())
        {
            String[] systemesTemp = sc1.nextLine().split(", ");
            for (int i=0; i<3;i++) {
                systemes[cptSystemes][i] = systemesTemp[i];
            }
            cptSystemes++;
        }
        return systemes;
    }

    public Galaxie getGalaxie(){ return galaxie;      }
    public int     getTour()   { return this.numTour; }

    public boolean getActionLibere() { return this.actionLibere; }

    public Joueur     getJoueurA()   { return this.joueurA; }
    public Joueur     getJoueurB()   { return this.joueurB; }
}
