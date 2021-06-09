package equipe_34.lesSeigneursDuTemps;

import equipe_34.lesSeigneursDuTemps.metier.Jeu;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
				Scanner     sc1 = new Scanner(new FileInputStream(fic + ".data"), "UTF8");
				this.metier       = new Jeu (sc1);
			}catch(Exception e){ e.printStackTrace(); }
		}
	}
    
    public static void main(String[] a)
	{
		String fic = null;

		if ( a.length > 0 ) fic = a[0];

		new Controleur(fic);
	}
}