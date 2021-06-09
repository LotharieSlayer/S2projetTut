import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;

public class FrameJoueur extends JFrame
{
	private JPanel				 pnlMain;
	private PanelJoueur          pnlJoueur;
	private PanelTitle 			 pnlTitle;
	private PanelMessageStatut	 pnlStatut;

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
		this.pnlStatut = new PanelMessageStatut(ctrl);
		this.pnlStatut.setPreferredSize(new Dimension(1600,400));
		
		this.pnlJoueur  = new PanelJoueur  (ctrl);

		/* ---------------------------- */
		/* Postionnement des composants */
		/* ---------------------------- */
		this.pnlMain.add(this.pnlTitle , BorderLayout.NORTH);
		this.pnlMain.add(this.pnlJoueur, BorderLayout.CENTER);
		this.pnlMain.add(this.pnlStatut, BorderLayout.SOUTH);
		this.pnlMain.setBackground(Color.WHITE);
		this.add(this.pnlMain);
		

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);
	}

}
