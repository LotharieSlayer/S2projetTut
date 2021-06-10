package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;


/*--------------------------------------------*/
/* Classe PanelImage                          */
/*--------------------------------------------*/
public class PanelTitle extends JPanel
{
	private Controleur  ctrl;

	//private JLabel lblTimer;
	private Image image;
	private String fichier;


	public PanelTitle(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		this.fichier = "./ihm/image/logo.png";
		this.ouvrirImage();
	}

	public void paint ( Graphics g )
	{
		g.drawImage( this.image, 650 , getInsets().top, null );
	}

	public void ouvrirImage()
	{
		this.image = Toolkit.getDefaultToolkit().getImage( this.fichier );

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