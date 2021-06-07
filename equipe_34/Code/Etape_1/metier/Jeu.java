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

    public void action ( int numJoueur, char action, int nbBlanche, int nbNoi, nbDispo )
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

    private String generationDesPositions() //genere les postion pour chaque planete
    {
		String tmp;
		String[] tabSystem = { "Triälum" , "Uninium", "Mervelléum" , "Quintum" } ;
        for ( int cpt = 0 , cpt < 10 , cpt++)
		{
			int rdm1  = Math.Random(4) ;
			int rdm2  = Math.Random(4) ;
			tmp = tabSystem[rdm1];
			tabSystem[rdm1] = tabSystem[rdm2];
			tabSystem[rdm2] = tmp;
		}
    }

    private String avancerPlanete (int planete)
    {
        Sting tmp = tabSystem[planete];
        tabSystem[planete] = tabSystem[planete + 1];
        tabSystem[planete + 1] = tabSystem[planete];
    }
}
