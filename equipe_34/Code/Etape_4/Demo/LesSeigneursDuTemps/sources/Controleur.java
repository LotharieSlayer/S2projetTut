package equipe_34.lesSeigneursDuTemps;

import equipe_34.lesSeigneursDuTemps.metier.*;
import equipe_34.lesSeigneursDuTemps.ihm.*;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Controleur
{
	public  Jeu           metier;
	private FrameJoueur   ihm   ;

	public Controleur( String fic )
    {
		if ( fic == null )
		{
			this.metier       = new Jeu ();
			this.ihm    = new FrameJoueur ( this );
		}
		else
		{
			try
			{
				Scanner     sc1 = new Scanner(new FileInputStream("./scenarios/" + fic + ".data"), "UTF8");
				this.metier       = new Jeu (sc1);
				this.ihm    = new FrameJoueur ( this );
				this.ihm.maj( this );
			}catch(Exception e){ e.printStackTrace(); }
		}
	}

    public static void main(String[] a)
	{
		String fic = null;

		if ( a.length > 0 ) fic = a[0];

		new Controleur(fic);
	}

	public Galaxie getGalaxie(){ return this.metier.getGalaxie(); }
	public Jeu getJeu(){ return this.metier; }

	public Joueur determinerGagnant(){ 
		if(this.metier.getJoueurA().getNBbAnneaux() == 0 && this.metier.getJoueurB().getNBbAnneaux() == 0)
		{
			return this.metier.determinerGagnant();
		}
		else
			return null;
	}

	public Joueur getJoueurA(){ return this.metier.getJoueurA(); }
	public Joueur getJoueurB(){ return this.metier.getJoueurB(); }

	public int getTour()       { return this.metier.getTour()   ; }
	
	public void action ( String couleurSeigneur, char action, char systemeSolaire )
	{
		this.metier.action (couleurSeigneur, action, systemeSolaire );
	}

	public void majIHM(){ this.ihm.maj( this ); }
}