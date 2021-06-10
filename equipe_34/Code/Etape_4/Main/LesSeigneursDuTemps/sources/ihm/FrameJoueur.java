package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;
import java.io.*;


public class FrameJoueur extends JFrame
{
	private JPanel				 pnlMain;
	private JPanel				 pnlCoteLeft;
	private JPanel				 pnlCoteRight;
	private JPanel				 pnlFooter;
	private JPanel				 pnlFooterMilieu;

	private PanelJoueur          pnlJoueur;
	private PanelTitle 			 pnlTitle;
	private PanelStatutNoir		 pnlStatutN;
	private PanelStatutBlanc	 pnlStatutB;
	private PanelAnneaux		 pnlAnneaux;
	private PanelAction			 pnlAction;
	
    public FrameJoueur(Controleur ctrl)
    {
		this.setLocation(160,50);
		
		this.setSize(1600,900);
		this.setResizable(false);
		this.setTitle ( "Les Seigneurs du Temps" );

		/* ----------------------- */
		/* Création des composants */
		/* ----------------------- */

		// PANEL DU HAUT
		this.pnlMain = new JPanel( new BorderLayout() );
		this.pnlFooter = new JPanel( new GridLayout(1,3) );
		this.pnlFooter.setPreferredSize(new Dimension(1600, 160));


		this.pnlTitle = new PanelTitle(ctrl);
		this.pnlTitle.setPreferredSize(new Dimension(1600,150));

	
		this.pnlStatutN = new PanelStatutNoir(ctrl);
		this.pnlStatutN.setPreferredSize(new Dimension(1600,225));

		this.pnlStatutB = new PanelStatutBlanc(ctrl);
		this.pnlStatutB.setPreferredSize(new Dimension(1600,225));
		
		this.pnlCoteLeft = new JPanel();
		this.pnlCoteLeft.setPreferredSize(new Dimension(80,0));
		this.pnlCoteLeft.setBackground(Color.WHITE);

		this.pnlCoteRight = new JPanel();
		this.pnlCoteRight.setPreferredSize(new Dimension(80,0));
		this.pnlCoteRight.setBackground(Color.WHITE);

		// PANEL DU BAS
		// this.pnlFooterMilieu = new JPanel();
		// this.pnlFooterMilieu.setPreferredSize(new Dimension(1000,0));
		// this.pnlFooterMilieu.setBackground(Color.WHITE);
		// this.pnlFooter.add(this.pnlFooterMilieu, BorderLayout.CENTER);

		this.pnlAnneaux = new PanelAnneaux(ctrl);
		this.pnlFooter.add(this.pnlAnneaux, BorderLayout.WEST); //PANEL ANNEAUX
		
		this.pnlAction = new PanelAction(ctrl);
		this.pnlFooter.add(this.pnlAction, BorderLayout.EAST);

		this.pnlJoueur  = new PanelJoueur  (ctrl);

		/* ---------------------------- */
		/* Postionnement des composants */
		/* ---------------------------- */
		this.pnlMain.add(this.pnlTitle , BorderLayout.NORTH);
		this.pnlMain.add(this.pnlJoueur, BorderLayout.CENTER);
		this.pnlMain.add(this.pnlCoteLeft, BorderLayout.WEST);
		this.pnlMain.add(this.pnlCoteRight, BorderLayout.EAST);

		 //mettre le message au tour du noir
		this.pnlMain.add(this.pnlStatutB, BorderLayout.SOUTH); //mettre le message au tour du blanc
		this.pnlMain.add(this.pnlStatutN, BorderLayout.SOUTH);

		this.pnlMain.setBackground(Color.WHITE);
		this.add(this.pnlMain);
		this.add(this.pnlFooter, BorderLayout.SOUTH);
		

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);
	}
	public void maj(Controleur ctrl)
	{
		this.setTour(ctrl);
		this.pnlJoueur.maj(ctrl);
	}

	public void setTour(Controleur ctrl)
	{
		if(ctrl.getTour() % 2 != 0)
		{
			this.pnlMain.add(this.pnlStatutN, BorderLayout.SOUTH);
			this.pnlStatutN.setVisible(true);
			this.pnlStatutB.setVisible(false);
		}
		else
		{
			this.pnlMain.add(this.pnlStatutB, BorderLayout.SOUTH); 
			this.pnlStatutN.setVisible(false);
			this.pnlStatutB.setVisible(true);
		}
	}
}
