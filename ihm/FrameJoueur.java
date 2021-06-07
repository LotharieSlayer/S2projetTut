import java.awt.BorderLayout;


import javax.swing.*;

public class FrameJoueur extends JFrame
{

	PanelJoueur          panelJoueur;

    public FrameJoueur(Controleur ctrl)
    {
		this.setLocation(160,50);
		
		this.setSize(1600,900);

		this.setTitle ( "Les Seigneurs du Temps" );

		this.panelJoueur  = new PanelJoueur  (ctrl);

		this.add ( this.panelJoueur, BorderLayout.NORTH );


		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  // Attention ne fonctionne qu'en Swing
		this.setVisible(true);
	}

}
