package seigneurdutemps;

import seigneurdutemps.metier.Jeu;

import java.util.Scanner;

public class Controleur
{
    public Controleur()
    {
        
        public void action ( int couleurSeigneur, char action )
	{
		this.metier.action ( couleurSeigneur, action );

		//if ( numJoueur == 1 ) this.frameJoueur1.maj();
		//if ( numJoueur == 2 ) this.frameJoueur2.maj();

		//this.framePlateau.maj();

	}

    public static void main(String[] a)
	{
		new Controleur();
	}
}