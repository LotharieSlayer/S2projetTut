package equipe_34.lesSeigneursDuTemps;

import equipe_34.lesSeigneursDuTemps.ihm.FrameJoueur;

import java.awt.Color;

/*---------------------------------------------------*/
/* Classe Controleur                                 */
/* Cette classe est en charge de faire la passerelle */
/* entre la partie Métier et la partie IHM          */
/*---------------------------------------------------*/
public class Controleur
{
	//private Metier      metier;
	private FrameJoueur   ihm;

	public Controleur ()
	{
		//this.metier = new Metier();
		this.ihm    = new FrameJoueur ( this );

	}

	public static void main(String[] a)
	{
		new Controleur();
	}
}