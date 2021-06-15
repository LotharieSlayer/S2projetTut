package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.io.InputStream;

/*--------------------------------------------*/
/* Classe PanelAction                         */
/*--------------------------------------------*/

public class PanelAction extends JPanel implements ActionListener
{
	private Controleur    ctrl;

	private JLabel  lblSubtitle;
	private JPanel  pnlMain    ;
	private JPanel  pnlMessage ;
	private JPanel  pnlSubtitle;

	private JButton btnConqerir		;
	private JButton btnLiberer 		;
	private JButton btnConAdversaire;

	private Image   imgFond    ;

	/**
	 * PanelAction, le panel où les actions peuvent etre actionné via les bouttons
	 * @param ctrl Apporte la gestion avec le controleur
	 */
	public PanelAction(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);

		//Création et attribution de la font sur le JLabel Subtitle
		this.lblSubtitle = new JLabel("Jouer le tour :", JLabel.RIGHT);
		String fName = "./fonts/FreePixel.ttf";
		InputStream fFont = PanelAction.class.getResourceAsStream(fName);
		try 
		{
			Font font = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font smallFont = font.deriveFont(Font.PLAIN, 16);
			this.lblSubtitle.setFont(smallFont);
			this.lblSubtitle.setForeground(Color.BLACK);
			this.add(this.lblSubtitle);
		}
		catch (IOException e)        { e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }

		/* ------------------------------ */
		/* Création des boutons d'actions */
		/* ------------------------------ */
		this.btnConqerir = new JButton(new ImageIcon("./images/action/Bouton_conquerir.png"));
		this.btnConqerir.setBackground(Color.BLACK);
		this.btnConqerir.setOpaque(false);
		this.btnConqerir.setBorderPainted(false);
		this.btnConqerir.setFocusPainted(false);
		this.add(this.btnConqerir);

		this.btnLiberer = new JButton(new ImageIcon("./images/action/Bouton_liberer.png"));
		this.btnLiberer.setBackground(Color.BLACK);
		this.btnLiberer.setOpaque(false);
		this.btnLiberer.setBorderPainted(false);
		this.btnLiberer.setFocusPainted(false);
		this.add(this.btnLiberer);

		this.btnConAdversaire = new JButton(new ImageIcon("./images/action/Bouton_conAdversaire.png"));
		this.btnConAdversaire.setBackground(Color.BLACK);
		this.btnConAdversaire.setOpaque(false);
		this.btnConAdversaire.setBorderPainted(false);
		this.btnConAdversaire.setFocusPainted(false);
		this.add(this.btnConAdversaire);

		/* ------------------------- */
		/* Activation des composants */
		/* ------------------------- */
		this.btnConqerir.addActionListener		( this );
		this.btnLiberer.addActionListener 		( this );
		this.btnConAdversaire.addActionListener ( this );
	}

	/**
	 * Une méthode qui permet, une fois les boutons pressés, de jouer au jeu.
	 * @param e ActionEvent des boutons
	 */
	public void actionPerformed(ActionEvent e) {
		String couleur;

		couleur = this.ctrl.getJoueurActif().getCouleur();

		if(e.getSource() == this.btnConqerir)
		{
			if(this.ctrl.getJeu().getActionLibere() == false)
			{
				if(this.ctrl.getGalaxie().getPlaneteSelectionne() != " ")
				{
					if(this.ctrl.getJoueurActif().getNbAnneaux() > 0)
					{
						if(this.ctrl.getGalaxie().getSystemesSolaires().get(this.ctrl.getNumSystemeSolaire(this.ctrl.getGalaxie().getPlaneteSelectionne())).getPlanetes().get(this.ctrl.getNumPlanete(this.ctrl.getGalaxie().getPlaneteSelectionne())).getProprietaire() == null)
						{
							this.ctrl.action(couleur, 'C', this.ctrl.getGalaxie().getPlaneteSelectionne());
							this.ctrl.getGalaxie().setPlanete(" ");
						}
						else
							this.ctrl.setErreur(4);
					}
					else
						this.ctrl.setErreur(6);

				}
				else
					this.ctrl.setErreur(1);
			}
			else
			{
				this.ctrl.action(couleur, 'R', this.ctrl.getGalaxie().getPlaneteSelectionne());
				this.ctrl.getGalaxie().setPlanete(" ");
			}
		}	
		
		if(e.getSource() == this.btnLiberer)
		{
			if(this.ctrl.getJeu().getActionLibere() == false)
			{
				if(this.ctrl.getGalaxie().getPlaneteSelectionne() != " ")
				{
					if(this.ctrl.getGalaxie().getSystemesSolaires().get(this.ctrl.getNumSystemeSolaire(this.ctrl.getGalaxie().getPlaneteSelectionne())).getPlanetes().get(this.ctrl.getNumPlanete(this.ctrl.getGalaxie().getPlaneteSelectionne())).getProprietaire() == null)
					{
						this.ctrl.setErreur(5);
					}
					else if(this.ctrl.getGalaxie().getSystemesSolaires().get(this.ctrl.getNumSystemeSolaire(this.ctrl.getGalaxie().getPlaneteSelectionne())).getPlanetes().get(this.ctrl.getNumPlanete(this.ctrl.getGalaxie().getPlaneteSelectionne())).getProprietaire().getCouleur() == couleur)
					{
						this.ctrl.action(couleur, 'L', this.ctrl.getGalaxie().getPlaneteSelectionne());
						this.ctrl.getGalaxie().setPlanete(" ");
					}
					else
						this.ctrl.setErreur(5);
				}
				else
					this.ctrl.setErreur(1);
			}
			else
				this.ctrl.setErreur(2);
		}	

		if(e.getSource() == this.btnConAdversaire)
		{
			if(this.ctrl.getJeu().getActionLibere() == false)
			{
				if(this.ctrl.getGalaxie().getPlaneteSelectionne() != " ")
				{
					if(this.ctrl.getJoueurRival().getNbAnneaux() > 0)
					{
						if(this.ctrl.getGalaxie().getSystemesSolaires().get(this.ctrl.getNumSystemeSolaire(this.ctrl.getGalaxie().getPlaneteSelectionne())).getPlanetes().get(this.ctrl.getNumPlanete(this.ctrl.getGalaxie().getPlaneteSelectionne())).getProprietaire() == null)
						{
							this.ctrl.action(couleur, 'D', this.ctrl.getGalaxie().getPlaneteSelectionne());
							this.ctrl.getGalaxie().setPlanete(" ");
						}
						else
							this.ctrl.setErreur(4);
					}
					else
						this.ctrl.setErreur(7);
				}
				else
					this.ctrl.setErreur(1);
			}
			else
				this.ctrl.setErreur(2);
		}
		this.ctrl.majIHM();	
	}
}