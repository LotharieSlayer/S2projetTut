package equipe_34.lesSeigneursDuTemps;

import equipe_34.lesSeigneursDuTemps.metier.Jeu;

import java.util.Scanner;

public class Controleur
{
	private Jeu metier;

    public Controleur()
    {
		this.metier       = new Jeu ();
	}
    
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