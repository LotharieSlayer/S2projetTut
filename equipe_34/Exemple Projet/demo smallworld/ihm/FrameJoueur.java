package smallworld.ihm;

import smallworld.Controleur;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;


/** Frame pour le plateau individuel des Joueurs
  *
  * @author Philippe Le Pivert
  */
public class FrameJoueur extends JFrame
{
	private Controleur   ctrl;
	private PanelJoueur  panelJoueur;
	private int          numJoueur;

	public FrameJoueur ( Controleur ctrl, int numJoueur )
	{
		this.ctrl      = ctrl;
		this.numJoueur = numJoueur;

		this.panelJoueur = new PanelJoueur ( ctrl, numJoueur );

		this.add ( this.panelJoueur );

		this.setUndecorated(true);

		if ( this.numJoueur == 1 )	this.setLocation ( 210,680 ); else this.setLocation ( 820,680 );

		this.setSize     ( 600,200 );

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		this.setVisible  ( true );
	}

	public void maj()
	{
		this.panelJoueur.maj();
	}

}