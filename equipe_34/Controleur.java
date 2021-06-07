import java.util.Scanner;

public class Controleur
{
    public Controleur()
    {
        String action;
        Scanner clavier = new Scanner(System.in);
        System.out.print("Saisir votre action : ");
        action = clavier.nextLine();

        if (action == "n" || action == "b")
        {
            String planete;
            System.out.print("Saisir la planete de votre choix : ");
            planete = clavier.nextLine();

            if (planete == "1" || planete == "2" || planete == "3" || planete == "4")
            {

            }
            else
            {
                System.out.println("Planete choisi est invalide")
            }
        }
        else
        {
            System.out.println("Action saisie est indisponible")
        }
    
            // fermer les ressources
            clavier.close();
        }

        /*private String action ()
        {
            String action;
            Scanner clavier = new Scanner(System.in);
            System.out.print("Saisir votre action : ");
            action = clavier.nextLine();
            if (action == "n" || action == "b")
            {
                String planete;
                System.out.print("Saisir la planete de votre choix : ");
                planete = clavier.nextLine();
                if (planete == "1" || planete == "2" || planete == "3" || planete == "4")
                {
                }
                else
                {
                    System.out.println("Planete choisi est invalide")
                }
            }
            else
            {
                System.out.println("Action saisie est indisponible")
            }
    
            // fermer les ressources
            clavier.close();
        }*/

        /*private String toString()
        {
            while (numSystem <= 4)
            {
                Systeme.out.println("Systeme" + numSystem + "planete dispo:" + nbDispo + "planete Noir"+ nbNoir + "planete Blanche" + nbBlanche);
            }
        }*/
    }
}