package lesseigneurdutemps.metier;

import lesseigneurdutemps.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Jeu
{
    private String action;
    private String planete;
    private Joueur joueurB;
    private Joueur joueurN;

    private final int Trialum    = 3;
    private final int Uninium    = 1;
    private final int Mervelleum = 7;
    private final int Quintum    = 5;
    

    public Jeu()
    {
        this.joueurN = new Joueur("Francis", "noir");
        this.joueurB = new Joueur("Ara", "blanc");
    }

    public void action ( int couleurSeigneur, char action)
	{
		// determine quel joueur joue
        if (this.joueurN.getCouleur() == "noir")
        {
            // action [A]jouter [R]etirer
            switch ( action )
            {
                case 'A': // Ajouter un anneau
                    //this.ajouterAnneauBlanc();
                    //this.avancerPlanete();
                    System.out.println("ANoir");
                    break;

                case 'R': // Retirer un anneau
                    //this.retirerAnneauBlanc();
                    System.out.println("BNoir");
                    break;

                default : System.out.println("Action invalide");
            }
        }
        else
        {
            switch ( action )
            {
                case 'A': // Ajouter un anneau
                    //this.ajouterAnneauNoir();
                    //this.avancerPlanete();
                    System.out.println("A");
                    break;

                case 'R': // Retirer un anneau
                    //this.retirerAnneauNoir();
                    System.out.println("R");
                    break;

                default : System.out.println("Action invalide");
            }
        }
	}

    /*private int ajouterAnneauBlanc ()
    {
        this.nbDispo = this.nbDispo - 1;
        return this.nbBlanche ++;
    }

    private int ajouterAnneauNoir ()
    {
        this.nbDispo = this.nbDispo - 1;
        return this.nbNoir ++;
    }

    private int retirerAnneauBlanc(int nbBlanche)
    {
        this.nbDispo ++;
        return this.nbBlanche = this.nbBlanche - 1;
    }

    private String retirerAnneauNoir(int nbNoir)
    {
        this.nbDispo ++;
        return this.nbNoir = this.nbNoir - 1;
    }*/
}
