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
	public int getTour()       { return this.metier.getTour()   ; }
	
	public void action ( String couleurSeigneur, char action, char systemeSolaire )
	{
		this.metier.action (couleurSeigneur, action, systemeSolaire );

		this.ihm.maj( this );
	}
}