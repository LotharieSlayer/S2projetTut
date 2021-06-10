package smallworld.ihm;

import smallworld.Controleur;
import smallworld.Message;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/** Panel pour le plateau individuel du Joueur
  *
  * @author Philippe Le Pivert
  */
public class PanelJoueur extends JPanel implements ActionListener
{
	private Controleur         ctrl;
	private int                numJoueur;

	private JRadioButton       rbAjouter, rbEnlever;
	private JComboBox<String>  cbxTerritoire;

	private JLabel            lblInfo1;
	private JLabel            lblInfo2;
	private JLabel            lblMessage;

	private JButton           btnValider;


	public PanelJoueur ( Controleur ctrl, int numJoueur )
	{
		String  dir;
		Boolean pluriel;

		JLabel lblTitre;
		JPanel panelSaisie, panelSaisieInfo, panelSaisieAction, panelSaisieTerritoire, panelSaisieValider;

		ButtonGroup       bgAction;

		this.ctrl      = ctrl;
		this.numJoueur = numJoueur;


		/*---------------------------------*/
		/* Création des composants         */
		/*---------------------------------*/
		lblTitre            = new JLabel ( this.ctrl.getLibJoueur(this.numJoueur), JLabel.CENTER );

		this.lblInfo1       = new JLabel ( this.getInfo(1), JLabel.CENTER );
		this.lblInfo2       = new JLabel ( this.getInfo(2), JLabel.CENTER );

		lblMessage          = new JLabel ( "", JLabel.CENTER );

		this.rbAjouter      = new JRadioButton ( Message.LIB_AJOUTER.getLib() );
		this.rbEnlever      = new JRadioButton ( Message.LIB_ENLEVER.getLib() );

		bgAction = new ButtonGroup();
		bgAction.add ( this.rbAjouter );
		bgAction.add ( this.rbEnlever );


		this.cbxTerritoire       = new JComboBox<String>  ( this.ctrl.getListTerritoire() );

		this.btnValider          = new JButton ( Message.LIB_VALIDER.getLib() );
		this.btnValider.setMnemonic( Message.LIB_VALIDER.getMnemonic() );


		panelSaisie           = new JPanel( new GridLayout ( 4,1 ) );
		panelSaisieInfo       = new JPanel ();
		panelSaisieAction     = new JPanel ();
		panelSaisieTerritoire = new JPanel ();
		panelSaisieValider    = new JPanel ();


		/*---------------------------------*/
		/* Positionnement des composants   */
		/*---------------------------------*/
		this.setLayout ( new BorderLayout() );

		this.add ( lblTitre,   BorderLayout.NORTH );
		this.add ( lblMessage, BorderLayout.SOUTH );

		if ( numJoueur == 1 ) dir = BorderLayout.WEST; else dir = BorderLayout.EAST;
		this.add ( new JLabel ( new ImageIcon(this.ctrl.getImagePeuple ( this.numJoueur )) ), dir  );

		this.add ( panelSaisie );


		panelSaisie.add ( panelSaisieInfo       );
		panelSaisie.add ( panelSaisieAction     );
		panelSaisie.add ( panelSaisieTerritoire );
		panelSaisie.add ( panelSaisieValider    );


		panelSaisieInfo      .add ( this.lblInfo1   );
		panelSaisieInfo      .add ( this.lblInfo2   );

		panelSaisieAction    .add ( this.rbAjouter );
		panelSaisieAction    .add ( this.rbEnlever );

		panelSaisieTerritoire.add ( new JLabel (  Message.LIB_TERRITOIRE.getLib() + " : " ) );
		panelSaisieTerritoire.add ( this.cbxTerritoire );

		panelSaisieValider   .add ( this.btnValider );

		/*---------------------------------*/
		/* Activation des composants       */
		/*---------------------------------*/
		this.btnValider.addActionListener ( this );
	}

	private String getInfo(int numInfo)
	{
		String info=null;
		int    nb;

		if ( numInfo == 1 )
		{
			nb = this.ctrl.getNbPionEnMain(this.numJoueur);
			info = nb + " " + Message.LIB_JETON_MAIN.getLib(nb>1) + "\n";
		}

		if ( numInfo == 2 )
		{
			nb = this.ctrl.getNbPionSurPlateau(this.numJoueur);
			info = nb + " " + Message.LIB_JETON_PLATEAU.getLib(nb>1);
		}

		return info;
	}


	public void maj()
	{
		this.lblInfo1  .setText ( this.getInfo        (1)              );
		this.lblInfo2  .setText ( this.getInfo        (2)              );
		this.lblMessage.setText ( this.ctrl.getMessage(this.numJoueur) );
	}

	public void actionPerformed(ActionEvent e)
	{
		char action = ' ';
		if ( this.rbAjouter.isSelected() ) action = 'A';
		if ( this.rbEnlever.isSelected() ) action = 'E';
		this.ctrl.action ( this.numJoueur, action, this.cbxTerritoire.getSelectedIndex() );
	}

}