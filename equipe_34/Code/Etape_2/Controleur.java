package equipe_34.lesSeigneursDuTemps;

import equipe_34.lesSeigneursDuTemps.metier.Jeu;

import java.util.Scanner;

public class Controleur
{
	private Jeu metier;

    public Controleur( String fic )
    {
		if ( fic == null )
		{
			this.metier       = new Jeu ();
		}
		else
		{
			try
			{
				ObjectInputStream in = new ObjectInputStream( new FileInputStream( fic + ".data" ) );
				this.metier = (Jeu) in.readObject();
				in.close();
			}catch(Exception e){ e.printStackTrace(); }
		}
	}
    
    public static void main(String[] a)
	{
		new Controleur();

		String fic = null;

		if ( a.length > 0 ) fic = a[0];

		new Controleur(fic);
	}
}