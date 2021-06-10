package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import java.awt.*;
import java.awt.image.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;

import java.io.*;
import javax.imageio.ImageIO;


import javax.swing.*;

/*--------------------------------------------------------------*/
/* PanelSelctCouleur                                            */
/*--------------------------------------------------------------*/
public class PanelSelectSysteme extends JPanel
{
	// Attributs d'instance
	private Controleur ctrl;
	private String fichier;
	private Image imgSysteme;

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;

	private JPanel pnlPlanetes;

	/*--------------*/
	/* Constructeur */
	/*--------------*/

	public PanelSelectSysteme(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		this.setLayout ( null );


		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/

		/*----------------------------------------------*/
		/* Positionnement des Composants                */
		/*----------------------------------------------*/


		//Systeme
		this.imgSysteme = Toolkit.getDefaultToolkit().getImage( "./images/systemes/Triatum.png" );

		//Planetes
		this.btn1 = PlaneteButton.planete(50, 50, "./images/planetes/bleu.png" );
		this.add(this.btn1);

	}

	
	public void paintComponent(Graphics g) {
        super.paintComponent( g );
		g.drawImage( this.imgSysteme, 20, 5, this );
    }
}