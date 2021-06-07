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

    private String action (int nbDispo, int nbNoir, int nbBlanche)
    {

        Scanner clavier = new Scanner(System.in);
        System.out.print("Saisir votre action : ");
        action = clavier.nextLine();

        if (action == "n" || action == "b")
        {
            System.out.print("Saisir la planete de votre choix : ");
            planete = clavier.nextLine();

            if (planete == "1" || planete == "2" || planete == "3" || planete == "4")
            {

            }
            else
            {
                System.out.println("Planete choisi est invalide");
            }
        }
        else
        {
            System.out.println("Action saisie est indisponible");
        }
        
        // fermer les ressources
        clavier.close();
    }

    public void action ( int numJoueur, char action, int nbBlanche, int nbNoi, nbDispo )
	{
		// action [A]jouter [R]etirer

		switch ( action )
		{
			case 'a' || 'A': // Ajouter un anneau
			     this.nbBlanche.ajouterAnneauBlanc;
			         
			    break;

			case 'r' || 'R': // Retirer un anneau
				this.nbBlanche.retirerAnneauBlanc;
			    break;

			default : 
		}
	}

    private int ajouterAnneauBlanc ()
    {
        nbDispo = nbDispo - 1;
        return nbBlanche ++;
    }

    private int ajouterAnneauNoir ()
    {
        nbDispo = nbDispo - 1;
        return nbNoir ++;
    }

    private int retirerAnneauBlanc(int nbBlanche)
    {
        nbDispo ++;
        return nbBlanche = nbBlanche - 1;
    }

    private String retirerAnneauNoir(int nbNoir)
    {
        nbDispo ++;
        return nbNoir = nbNoir - 1;
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

        private String avancerPlanete (int planete)
        {
            Sting tmp = tabSystem[planete];
            tabSystem[planete] = tabSystem[planete + 1];
            tabSystem[planete + 1] = tabSystem[planete];
        }
    }
}
