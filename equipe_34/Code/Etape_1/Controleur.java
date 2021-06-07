package lesseigneursdutemps;

import java.util.Scanner;
import java.io.*;
import java.awt.Point;

public class Controleur
{
    public  static final String LANGUE = "FR";  // FR/ENG

    public Controleur()
    {

        /*public String action ()
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
            }
            else
            {
                System.out.println("Action saisie est indisponible");
            }
    
            // fermer les ressources
            clavier.close();
        }*/

        String action;
        Scanner clavier = new Scanner(System.in);
        System.out.print("Saisir votre action : ");
        action = clavier.nextLine();
        
        if (action == "n" || action == "b")
        {
                String planete;
                System.out.print("Saisir la planete de votre choix : ");
                planete = clavier.nextLine();
        }
        else
        {
            System.out.println("Action saisie est indisponible");
        }
    
        // fermer les ressources
        clavier.close();

        /*private String toString()
        {
            while (numSystem <= 4)
            {
                Systeme.out.println("Systeme" + numSystem + "planete dispo:" + nbDispo + "planete Noir" + nbNoir + "planete Blanche" + nbBlanche);
            }
        }*/
    }
}