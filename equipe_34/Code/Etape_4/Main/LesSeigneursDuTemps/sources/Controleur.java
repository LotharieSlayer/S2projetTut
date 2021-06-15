package equipe_34.lesSeigneursDuTemps;

import equipe_34.lesSeigneursDuTemps.metier.*;
import equipe_34.lesSeigneursDuTemps.ihm.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.net.URL;

public class Controleur
{
	public  Jeu           metier;
	private FrameJoueur   ihm   ;
	private int 		  numErreur;

    public Controleur()
    {
		this.metier = new Jeu         (      );
		this.ihm    = new FrameJoueur ( this );

		//Chargement de l'icone dans une image
		final URL imageResource = Controleur.class.getClassLoader().getResource("./images/logo/icon.png");
		final Image image = Toolkit.getDefaultToolkit().getImage(imageResource);
		final Taskbar taskbar = Taskbar.getTaskbar();

		try {
		//setIcon pour MacOS et Linux
			taskbar.setIconImage(image);
		} catch (final UnsupportedOperationException e) {
			System.out.println("Tentative de setIcon dans la TaskBar Windows");
		}
 		//setIcon pour Windows
		try{
			this.ihm.setIconImage(image);
		} catch (final UnsupportedOperationException e) {
			System.out.println("Impossible de charger l'image dans l'icone taskbar, merci de bien vouloir regarder si vous avez gnome sur votre Linux.");
		}
	}
    
    public static void main(String[] a)
	{
		new Controleur();
	}

	public Galaxie getGalaxie(){ return this.metier.getGalaxie(); }
	public Jeu getJeu(){ return this.metier; }

	public Joueur getJoueurA(){ return this.metier.getJoueurA(); }
	public Joueur getJoueurB(){ return this.metier.getJoueurB(); }
	public Joueur getJoueurActif(){
		if(this.getTour() % 2 != 0){
			return this.getJoueurA();
		}
		else
		{
			return this.getJoueurB();
		}
	}	
	
	public Joueur getJoueurRival(){
		if(this.getTour() % 2 != 0){
			return this.getJoueurB();
		}
		else
		{
			return this.getJoueurA();
		}
	}		

	public Joueur determinerGagnant(){ 
		if(this.metier.getJoueurA().getNbAnneaux() == 0 && this.metier.getJoueurB().getNbAnneaux() == 0)
		{
			return this.metier.determinerGagnant();
		}
		else
			return null;
	}

	public int getTour()       						{ return this.metier.getTour()   ; }

	public void setErreur( int numErreur) 			{  this.numErreur = numErreur; }
	public int getErreur() 							{  return this.numErreur; }
	public int getNumPlanete(String planete)		{  return this.metier.getNumPlanete(planete);}
	public int getNumSystemeSolaire(String planete)	{  return this.metier.getNumSystemeSolaire(planete);}
	
	public void action ( String couleurSeigneur, char action, String planete )
	{
		this.metier.actionTour (couleurSeigneur, action, planete);
	}

	public void majIHM(){ this.ihm.maj( this ); }
	public FrameJoueur getIHM(){ return this.ihm; }
}