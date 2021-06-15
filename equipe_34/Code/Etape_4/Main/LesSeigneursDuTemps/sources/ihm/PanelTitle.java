package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import javax.swing.JPanel;

import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


/*--------------------------------------------*/
/* Classe PanelTitle                          */
/*--------------------------------------------*/
public class PanelTitle extends JPanel
{
	private Controleur  ctrl   ;

	//private JLabel lblTimer;
	private Image       image  ;
	private String      fichier;

	/**
	 * Objet PanelTitle qui permet d'afficher le logo en haut.
	 * @param ctrl Apporte la gestion avec le controleur
	 */
	public PanelTitle(Controleur ctrl)
	{
		this.ctrl    = ctrl;
		this.setBackground(Color.WHITE);
		this.fichier = "./images/logo/logo.png";
		this.ouvrirImage();
	}

	/**
	 * Méthode qui permet d'afficher le logo en haut.
	 * @param g Dessine le logo
	 */
	public void paint ( Graphics g )
	{
		g.drawImage( this.image, 650 , getInsets().top, null );
	}

	/**
	 * Méthode qui permet d'ouvrir l'image.
	 */
	public void ouvrirImage()
	{
		this.image         = Toolkit.getDefaultToolkit().getImage( this.fichier );

		MediaTracker track = new MediaTracker( this );

		// 0 est l'identifiant de l'image à charger.
		track.addImage( this.image, 0 );

		try
		{
			track.waitForID( 0 );
		}
		catch ( InterruptedException e ) { e.printStackTrace(); }

		Insets in = getInsets();
	}
}