import java.util.Scanner;
import java.util.ArrayList;

public class Action
{
    private String action;
    private String planete;

    private final int Triälum    = 3;
    private final int Uninium    = 1;
    private final int Mervelléum = 7;
    private final int Quintum    = 5;

    public Action
    {
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

        private String génerationDesPositions() //genere les postion pour chaque planete
        {
			String tmp;
			String[] tabSystem = { "Triälum" , "Uninium", "Mervelléum" , "Quintum" } ;
            for ( int cpt = 0 , cpt < 10 , cpt++)
			{
				int rdm1  = Math.Random(4) ;
				int rdm2  = Math.Random(4) ;
				Sting tmp = tabSystem[rdm1];
				tabSystem[rdm1] = tabSystem[rdm2];
				tabSystem[rdm2] = tmp;
			}
        }
    }
}
