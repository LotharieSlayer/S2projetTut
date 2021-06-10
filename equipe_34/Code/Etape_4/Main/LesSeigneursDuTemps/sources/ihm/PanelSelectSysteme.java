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

	private static int PlaceSystemeID = 0;
	private int NumPlaceSysteme;

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;

	private JPanel pnlPlanetes;

	private String nomFichier;

	/*--------------*/
	/* Constructeur */
	/*--------------*/

	public PanelSelectSysteme(Controleur ctrl, int NumPlaceSysteme)
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

		switch(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom())
		{
			case "Triälum":
				this.nomFichier = "Trialum";
				break;
			case "Mervelléum":
				this.nomFichier = "Mervelleum";
				break;
			case "Uninium":
				this.nomFichier = "Uninium";
				break;
			case "Quintum":
				this.nomFichier = "Quintum";
				break;
		}

		//Systeme
		this.imgSysteme = Toolkit.getDefaultToolkit().getImage( "./images/systemes/" + this.nomFichier + ".png" );

		//Planetes
		switch(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom())
		{
			case "Triälum":
					
				//Planete 1
				this.btn1 = PlaneteButton.planete(70, 75, "./images/planetes/bleu.png" );
				this.add(this.btn1);
				
				//Planete 2
				this.btn2 = PlaneteButton.planete(200, 75, "./images/planetes/jaune.png" );
				this.add(this.btn2);

				//Planete 3
				this.btn3 = PlaneteButton.planete(150, 175, "./images/planetes/vert.png" );
				this.add(this.btn3);
			
				break;
				
			case "Mervelléum":

				//Planete 1
				this.btn1 = PlaneteButton.planete(60, 75, "./images/planetes/rouge.png" );
				this.add(this.btn1);
				
				//Planete 2
				this.btn2 = PlaneteButton.planete(140, 40, "./images/planetes/jaune.png" );
				this.add(this.btn2);

				//Planete 3
				this.btn3 = PlaneteButton.planete(190, 100, "./images/planetes/rose.png" );
				this.add(this.btn3);

				//Planete 4
				this.btn4 = PlaneteButton.planete(180, 170, "./images/planetes/bleu.png" );
				this.add(this.btn4);

				//Planete 5
				this.btn5 = PlaneteButton.planete(125, 190, "./images/planetes/fuchsia.png" );
				this.add(this.btn5);

				//Planete 6
				this.btn6 = PlaneteButton.planete(60, 165, "./images/planetes/vert.png" );
				this.add(this.btn6);

				//Planete 7
				this.btn7 = PlaneteButton.planete(130, 120, "./images/planetes/orange.png" );
				this.add(this.btn7);
				
				break;

			case "Uninium":

				//Planete 1
				this.btn1 = PlaneteButton.planete(130, 115, "./images/planetes/rose.png" );
				this.add(this.btn1);
			
				break;
			case "Quintum":
				//Planete 1
				this.btn1 = PlaneteButton.planete(60, 75, "./images/planetes/rouge.png" );
				this.add(this.btn1);
				
				//Planete 2
				this.btn2 = PlaneteButton.planete(140, 40, "./images/planetes/jaune.png" );
				this.add(this.btn2);

				//Planete 3
				this.btn3 = PlaneteButton.planete(190, 100, "./images/planetes/rose.png" );
				this.add(this.btn3);

				//Planete 4
				this.btn4 = PlaneteButton.planete(175, 170, "./images/planetes/bleu.png" );
				this.add(this.btn4);

				//Planete 5
				this.btn5 = PlaneteButton.planete(70, 150, "./images/planetes/vert.png" );
				this.add(this.btn5);
				break;
		}

	}
	public void maj(Controleur ctrl, int NumPlaceSysteme){
		switch(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom())
		{
			case "Triälum":
				this.nomFichier = "Trialum";
				break;
			case "Mervelléum":
				this.nomFichier = "Mervelleum";
				break;
			case "Uninium":
				this.nomFichier = "Uninium";
				break;
			case "Quintum":
				this.nomFichier = "Quintum";
				break;
		}

		//Systeme
		this.imgSysteme = Toolkit.getDefaultToolkit().getImage( "./images/systemes/" + this.nomFichier + ".png" );

		//Planetes
		switch(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom())
		{
			case "Triälum":
					
				//Planete 1
				this.btn1 = PlaneteButton.planete(70, 75, "./images/planetes/bleu.png" );
				this.add(this.btn1);
				
				//Planete 2
				this.btn2 = PlaneteButton.planete(200, 75, "./images/planetes/jaune.png" );
				this.add(this.btn2);

				//Planete 3
				this.btn3 = PlaneteButton.planete(150, 175, "./images/planetes/vert.png" );
				this.add(this.btn3);
			
				break;
				
			case "Mervelléum":

				//Planete 1
				this.btn1 = PlaneteButton.planete(60, 75, "./images/planetes/rouge.png" );
				this.add(this.btn1);
				
				//Planete 2
				this.btn2 = PlaneteButton.planete(140, 40, "./images/planetes/jaune.png" );
				this.add(this.btn2);

				//Planete 3
				this.btn3 = PlaneteButton.planete(190, 100, "./images/planetes/rose.png" );
				this.add(this.btn3);

				//Planete 4
				this.btn4 = PlaneteButton.planete(180, 170, "./images/planetes/bleu.png" );
				this.add(this.btn4);

				//Planete 5
				this.btn5 = PlaneteButton.planete(125, 190, "./images/planetes/fuchsia.png" );
				this.add(this.btn5);

				//Planete 6
				this.btn6 = PlaneteButton.planete(60, 165, "./images/planetes/vert.png" );
				this.add(this.btn6);

				//Planete 7
				this.btn7 = PlaneteButton.planete(130, 120, "./images/planetes/orange.png" );
				this.add(this.btn7);
				
				break;

			case "Uninium":

				//Planete 1
				this.btn1 = PlaneteButton.planete(130, 115, "./images/planetes/rose.png" );
				this.add(this.btn1);
			
				break;
			case "Quintum":
				//Planete 1
				this.btn1 = PlaneteButton.planete(60, 75, "./images/planetes/rouge.png" );
				this.add(this.btn1);
				
				//Planete 2
				this.btn2 = PlaneteButton.planete(140, 40, "./images/planetes/jaune.png" );
				this.add(this.btn2);

				//Planete 3
				this.btn3 = PlaneteButton.planete(190, 100, "./images/planetes/rose.png" );
				this.add(this.btn3);

				//Planete 4
				this.btn4 = PlaneteButton.planete(175, 170, "./images/planetes/bleu.png" );
				this.add(this.btn4);

				//Planete 5
				this.btn5 = PlaneteButton.planete(70, 150, "./images/planetes/vert.png" );
				this.add(this.btn5);
				break;
		}
	}

	
	public void paintComponent(Graphics g) {
        super.paintComponent( g );
		g.drawImage( this.imgSysteme, 20, 5, this );
    }
}