package lesseigneurdutemps.metier;

import seigneurdutemps.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Jeu
{
    private String action;
    private String planete;

    private final int Triälum    = 3;
    private final int Uninium    = 1;
    private final int Mervelléum = 7;
    private final int Quintum    = 5;

    public Jeu
    {
        
    }

    public void action ( int couleurSeigneur, char action)
	{
		// determine quel joueur joue
        if (this.couleurSeigneur == "noir")
        {
            // action [A]jouter [R]etirer
            switch ( action )
            {
                case 'a' || 'A': // Ajouter un anneau
                    this.ajouterAnneauBlanc();
                    this.avancerPlanete();
                    break;

                case 'r' || 'R': // Retirer un anneau
                    this.retirerAnneauBlanc();
                    break;

                default : System.out.println("Action invalide")
            }
        }
        else
        {
            switch ( action )
            {
                case 'a' || 'A': // Ajouter un anneau
                    this.ajouterAnneauNoir();
                    this.avancerPlanete();
                        
                    break;

                case 'r' || 'R': // Retirer un anneau
                    this.retirerAnneauNoir();
                    break;

                default : System.out.println("Action invalide")
            }
        }
	}

    private int ajouterAnneauBlanc ()
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
    }
}
