package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;


public class FrameJoueur extends JFrame
{
	private JPanel				 pnlMain;
	private JPanel				 pnlCoteLeft;
	private JPanel				 pnlCoteRight;

	private PanelJoueur          pnlJoueur;
	private PanelTitle 			 pnlTitle;
	private PanelStatutNoir		 pnlStatutN;
	private PanelStatutBlanc	 pnlStatutB;
	//private PanelFooter			 pnlFooter;

    public FrameJoueur(Controleur ctrl)
    {
		this.setLocation(160,50);
		
		this.setSize(1600,900);
		this.setResizable(false);
		this.setTitle ( "Les Seigneurs du Temps" );

		/* ----------------------- */
		/* Création des composants */
		/* ----------------------- */
		pnlMain = new JPanel();
		this.pnlMain.setLayout( new BorderLayout() );

		this.pnlTitle = new PanelTitle(ctrl);
		this.pnlTitle.setPreferredSize(new Dimension(1600,150));
		this.pnlStatutN = new PanelStatutNoir(ctrl);
		this.pnlStatutN.setPreferredSize(new Dimension(1600,400));
		this.pnlStatutB = new PanelStatutBlanc(ctrl);
		this.pnlStatutB.setPreferredSize(new Dimension(1600,400));
		
		this.pnlCoteLeft = new JPanel();
		this.pnlCoteLeft.setPreferredSize(new Dimension(80,0));
		this.pnlCoteLeft.setBackground(Color.WHITE);

		this.pnlCoteRight = new JPanel();
		this.pnlCoteRight.setPreferredSize(new Dimension(80,0));
		this.pnlCoteRight.setBackground(Color.WHITE);



		this.pnlJoueur  = new PanelJoueur  (ctrl);

		/* ---------------------------- */
		/* Postionnement des composants */
		/* ---------------------------- */
		this.pnlMain.add(this.pnlTitle , BorderLayout.NORTH);
		this.pnlMain.add(this.pnlJoueur, BorderLayout.CENTER);
		
		
		
		this.pnlMain.add(this.pnlCoteLeft, BorderLayout.WEST);
		this.pnlMain.add(this.pnlCoteRight, BorderLayout.EAST);
		
		//this.pnlMain.add(this.pnlStatutN, BorderLayout.SOUTH); //mettre le message au tour du noir
		this.pnlMain.add(this.pnlStatutB, BorderLayout.SOUTH); //mettre le message au tour du blanc
		this.pnlMain.setBackground(Color.WHITE);
		this.add(this.pnlMain);
		

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);
	}

}
