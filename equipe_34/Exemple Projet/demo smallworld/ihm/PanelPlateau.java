package smallworld.ihm;

import smallworld.Controleur;
import smallworld.SituationPlateau;

import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/** Panel pour le Plateau commun de Jeu.
  *
  * @author Philippe Le Pivert
  */
public class PanelPlateau extends JPanel
{
	private Controleur ctrl;

	public PanelPlateau ( Controleur ctrl )
	{
		this.ctrl = ctrl;


		this.addMouseListener ( new GereSouris() );
	}

	public void paintComponent(Graphics g)
	{
		String           sImage;
		Image            img;
		SituationPlateau sp;
		int              x, y;

		Graphics2D       g2 = (Graphics2D) g;


		super.paintComponent(g);


		// Dessine le fond
		sImage = ctrl.getFond();
		if ( sImage != null )
		{
			img = getToolkit().getImage ( sImage );
			g2.drawImage ( img, 0, 0, this );
		}

		g2.setFont ( new Font( "SansSerif", Font.BOLD, 22 ) );


		sp = ctrl.getSituationPlateau();

		// Dessine les Peuples
		for (int cpt=0; cpt < sp.nbTerritoire; cpt++ )
		{

			if ( sp.infoTerritoire[cpt] != null )
			{
				img = getToolkit().getImage ( sp.infoTerritoire[cpt].getImage() );
				x   = (int) sp.infoTerritoire[cpt].getPos().getX();
				y   = (int) sp.infoTerritoire[cpt].getPos().getY();

				g2.drawImage  ( img, x-18, y-18, this );
				g2.setColor ( new Color ( 236,229,216) );
				g2.fillRect   ( x+18, y+45, 25, 17 );

				g2.setColor ( Color.BLACK );
				g2.drawString ( "x" + sp.infoTerritoire[cpt].getNbJetons(), x+18, y+61 );
			}
		}
	}


	public class GereSouris extends MouseAdapter
	{
		public void mousePressed ( MouseEvent e )
		{
			System.out.println ( e.getX() + "," + e.getY() );
		}
	}

}