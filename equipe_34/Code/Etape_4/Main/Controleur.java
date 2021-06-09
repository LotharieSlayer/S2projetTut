package equipe_34.lesSeigneursDuTemps;

import equipe_34.lesSeigneursDuTemps.metier.Jeu;
import equipe_34.lesSeigneursDuTemps.ihm.*;

public class Controleur
{
	private Jeu metier;
	private FrameJoueur   ihm;

    public Controleur()
    {
		this.ihm    = new FrameJoueur ( this );
		this.metier = new Jeu ();
		
	}
    
    public static void main(String[] a)
	{
		new Controleur();
	}
}