package equipe_34.lesSeigneursDuTemps;

import equipe_34.lesSeigneursDuTemps.metier.Jeu;

import java.util.Scanner;

public class Controleur
{
	private Jeu metier;

    public Controleur()
    {
		this.metier = new Jeu ();
	}
    
    public static void main(String[] a)
	{
		new Controleur();
	}
}