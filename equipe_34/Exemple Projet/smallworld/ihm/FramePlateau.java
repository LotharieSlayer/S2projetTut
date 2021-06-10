package smallworld.ihm;

import smallworld.Controleur;


import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/** Frame pour le plateau de Jeu
  *
  * @author Philippe Le Pivert
  */
public class FramePlateau extends JFrame
{
	private Controleur   ctrl;
	private PanelPlateau panelPlateau;


	public FramePlateau ( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.panelPlateau = new PanelPlateau ( ctrl );

		this.add ( this.panelPlateau );

		this.setLocation ( 200,1 );
		this.setSize     ( 1236, 687 );

		this.setTitle    ( "SmallWorld" );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		this.addWindowListener   ( new GereWindow       () );
		this.addComponentListener( new GereDeplacerFrame() );

		this.setVisible  ( true );

	}


	/** En détactant la fermeture de cette Frame, on va provoquer la fermeture des autres Frame(Joueur) */
	private class GereWindow extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			FramePlateau.this.ctrl.fermer();
		}
	}

	/** Lors du déplacement de cette Frame, les autres Frame(Joueur) vont suivre */
	private class GereDeplacerFrame extends ComponentAdapter
	{
		public void componentMoved(ComponentEvent e)
		{
			FramePlateau.this.ctrl.moveFrame("P");
		}
	}

	/** Permet de mettre à jour la partie dessiner sur le PanelPlateau.
	    il y a sur ce Panel que des informations dessinées. */
	public void maj()
	{
		this.panelPlateau.repaint();
	}

}