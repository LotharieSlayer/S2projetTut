import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;

import equipe_34.lesSeigneursDuTemps.metier.*;

import javax.swing.*;

/*--------------------------------------------------------------*/
/* PanelSelctCouleur                                            */
/*--------------------------------------------------------------*/
public class PanelSelectSysteme extends JPanel
{
	// Attributs d'instance
	private Planete    pl;
	private Controleur ctrl;

	private JLabel lblPlanete;

	private JScrollBar sbCouleur;

	private JTextField txtDecimal;
	private JTextField txtHexaDecimal;

	private boolean    activeScrollAdjustement;

	/*--------------*/
	/* Constructeur */
	/*--------------*/

	// Ce Panel est constitué de deux sous-Panel que je définie directement,
	// dans le constructeur sans passer par des nouvelles classes.
	//
	// Le type correspond à une des trois constante de classe ROUGE VERT BLEU

	public PanelSelectSysteme()//Planete pl, Controleur ctrl)
	{
		this.pl                    = pl;
		this.ctrl                  = ctrl;
		this.setBackground(Color.WHITE);

		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/


		Font smallFont = new Font("Free Pixels", Font.PLAIN, 10);  
		Font bigFont = new Font("Montserrat", Font.BOLD, 18);
		

		this.lblPlanete = new JLabel ( " Trialum ", JLabel.CENTER );
		this.lblPlanete.setFont(bigFont);
		this.lblPlanete.setBackground ( Color.WHITE );


		this.sbCouleur      = new JScrollBar ( JScrollBar.HORIZONTAL, 0, 15, 0, 265 ); // @1
		this.sbCouleur.setBlockIncrement(32);
		this.sbCouleur.setUnitIncrement (16);


		// Partie Basse
		this.txtDecimal     = new JTextField ( "000" );
		this.txtHexaDecimal = new JTextField ( "00"  );


		/*----------------------------------------------*/
		/* Positionnement des Composants                */
		/*----------------------------------------------*/

		this.setLayout ( new GridLayout(2,1) );

		JPanel panelHaut  = new JPanel();
		JPanel panelBas   = new JPanel();


		this.add ( panelHaut );
		this.add ( panelBas  );

		// Elaboration du Panel Haut BorderLayout
		panelHaut.setLayout ( new BorderLayout(2,0) );

		panelHaut.add ( this.lblPlanete,         BorderLayout.CENTER );


		// Elaboration du Panel Bas FlowLayout
		panelBas.add ( new JLabel ( "dec :", JLabel.RIGHT ) );
		panelBas.add ( this.txtDecimal                      );
		panelBas.add ( new JLabel ( "hex :", JLabel.RIGHT ) );
		panelBas.add ( this.txtHexaDecimal                  );

	}
}