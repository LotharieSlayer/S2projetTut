package equipe_34.lesSeigneursDuTemps;

import equipe_34.lesSeigneursDuTemps.metier.*;
import equipe_34.lesSeigneursDuTemps.ihm.*;

public class Controleur
{
	public  Jeu           metier;
	private FrameJoueur   ihm   ;

    public Controleur()
    {
		this.metier = new Jeu         (      );
		this.ihm    = new FrameJoueur ( this );
	}
    
    public static void main(String[] a)
	{
		new Controleur();
	}

	public Galaxie getGalaxie(){ return this.metier.getGalaxie(); }
	public Jeu getJeu(){ return this.metier; }

	public Joueur getJoueurA(){ return this.metier.getJoueurA(); }
	public Joueur getJoueurB(){ return this.metier.getJoueurB(); }

	public Joueur determinerGagnant(){ 
		if(this.metier.getJoueurA().getNBbAnneaux() == 0 && this.metier.getJoueurB().getNBbAnneaux() == 0)
		{
			return this.metier.determinerGagnant();
		}
		else
			return null;
	}

	public int getTour()       { return this.metier.getTour()   ; }
	
	public void action ( String couleurSeigneur, char action, char systemeSolaire )
	{
		this.metier.action (couleurSeigneur, action, systemeSolaire );
	}

	public void majIHM(){ this.ihm.maj( this ); }
}