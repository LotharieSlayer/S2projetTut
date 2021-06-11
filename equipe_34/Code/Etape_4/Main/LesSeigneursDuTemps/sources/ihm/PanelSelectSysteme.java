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
	private Controleur ctrl      ;
	private String     fichier   ;
	private String     nomFichier;
	private Image      imgSysteme;

	private static int PlaceSystemeID = 0;

	private int NumPlaceSysteme;

	private JButton btn0 ;
	private JButton btn1 ;
	private JButton btn2 ;
	private JButton btn3 ;
	private JButton btn4 ;
	private JButton btn5 ;
	private JButton btn6 ;
	private JButton btn7 ;
	private JButton btn8 ;
	private JButton btn9 ;
	private JButton btn10;
	private JButton btn11;
	private JButton btn12;
	private JButton btn13;
	private JButton btn14;
	private JButton btn15;
	private JButton btn16;

	private JPanel pnlPlanetes;

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
				this.nomFichier = "Trialum"   ;
				break;
			case "Mervelléum":
				this.nomFichier = "Mervelleum";
				break;
			case "Uninium":
				this.nomFichier = "Uninium"   ;
				break;
			case "Quintum":
				this.nomFichier = "Quintum"   ;
				break;
		}

		//Systeme
		this.imgSysteme = Toolkit.getDefaultToolkit().getImage( "./images/systemes/" + this.nomFichier + ".png" );
		
		this.btn0  = PlaneteButton.planete(0, 0,     "./images/planetes/bleu.png"   );
		this.btn1  = PlaneteButton.planete(70, 75,   "./images/planetes/bleu.png"   );
		this.btn2  = PlaneteButton.planete(200, 75,  "./images/planetes/jaune.png"  );
		this.btn3  = PlaneteButton.planete(150, 175, "./images/planetes/vert.png"   );
		this.btn4  = PlaneteButton.planete(60, 75,   "./images/planetes/rouge.png"  );
		this.btn5  = PlaneteButton.planete(140, 40,  "./images/planetes/jaune.png"  );
		this.btn6  = PlaneteButton.planete(190, 100, "./images/planetes/rose.png"   );
		this.btn7  = PlaneteButton.planete(180, 170, "./images/planetes/bleu.png"   );
		this.btn8  = PlaneteButton.planete(125, 190, "./images/planetes/fuchsia.png");
		this.btn9  = PlaneteButton.planete(60, 165,  "./images/planetes/vert.png"   );
		this.btn10 = PlaneteButton.planete(130, 120, "./images/planetes/orange.png" );
		this.btn11 = PlaneteButton.planete(130, 115, "./images/planetes/rose.png"   );
		this.btn12 = PlaneteButton.planete(60, 75,   "./images/planetes/rouge.png"  );
		this.btn13 = PlaneteButton.planete(140, 40,  "./images/planetes/jaune.png"  );
		this.btn14 = PlaneteButton.planete(190, 100, "./images/planetes/rose.png"   );
		this.btn15 = PlaneteButton.planete(175, 170, "./images/planetes/bleu.png"   );
		this.btn16 = PlaneteButton.planete(70, 150,  "./images/planetes/vert.png"   );

		this.add(this.btn0);

		//Planetes
		switch(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom())
		{
			case "Triälum":

				//Planete 1
				this.add(this.btn1 );
				
				//Planete 2
				this.add(this.btn2 );

				//Planete 3
				this.add(this.btn3 );
			
				break;
				
			case "Mervelléum":

				//Planete 1
				this.add(this.btn4 );
				
				//Planete 2
				this.add(this.btn5 );

				//Planete 3
				this.add(this.btn6 );

				//Planete 4
				this.add(this.btn7 );

				//Planete 5
				this.add(this.btn8 );

				//Planete 6
				this.add(this.btn9 );

				//Planete 7
				this.add(this.btn10);
				
				break;

			case "Uninium":

				//Planete 1
				this.add(this.btn11);
			
				break;
			case "Quintum":
				//Planete 1
				this.add(this.btn12);
				
				//Planete 2
				this.add(this.btn13);

				//Planete 3
				this.add(this.btn14);

				//Planete 4
				this.add(this.btn15);

				//Planete 5
				this.add(this.btn16);
				break;
		}

	}

	public void maj(Controleur ctrl, int NumPlaceSysteme)
	{

		switch(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom())
		{
			case "Triälum":
				this.nomFichier = "Trialum"   ;
				break;
			case "Mervelléum":
				this.nomFichier = "Mervelleum";
				break;
			case "Uninium":
				this.nomFichier = "Uninium"   ;
				break;
			case "Quintum":
				this.nomFichier = "Quintum"   ;
				break;
		}

		//Systeme
		this.imgSysteme = Toolkit.getDefaultToolkit().getImage( "./images/systemes/" + this.nomFichier + ".png" );

		//Planetes
		switch(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom())
		{
			case "Triälum":

				//Planete 1
				this.add(this.btn1);
				
				//Planete 2
				this.add(this.btn2);

				//Planete 3
				this.add(this.btn3);

				this.btn4.setVisible(false );
				this.btn5.setVisible(false );
				this.btn6.setVisible(false );
				this.btn7.setVisible(false );
				this.btn8.setVisible(false );
				this.btn9.setVisible(false );
				this.btn10.setVisible(false);
				this.btn11.setVisible(false);
				this.btn12.setVisible(false);
				this.btn13.setVisible(false);
				this.btn14.setVisible(false);
				this.btn15.setVisible(false);
				this.btn16.setVisible(false);

				this.btn1.setVisible(true);
				this.btn2.setVisible(true);
				this.btn3.setVisible(true);
			
				break;
				
			case "Mervelléum":

				//Planete 1
				this.add(this.btn4 );
				
				//Planete 2
				this.add(this.btn5 );

				//Planete 3
				this.add(this.btn6 );

				//Planete 4
				this.add(this.btn7 );

				//Planete 5
				this.add(this.btn8 );

				//Planete 6
				this.add(this.btn9 );

				//Planete 7
				this.add(this.btn10);

				this.btn1.setVisible(false );
				this.btn2.setVisible(false );
				this.btn3.setVisible(false );
				this.btn11.setVisible(false);
				this.btn12.setVisible(false);
				this.btn13.setVisible(false);
				this.btn14.setVisible(false);
				this.btn15.setVisible(false);
				this.btn16.setVisible(false);

				this.btn4.setVisible(true  );
				this.btn5.setVisible(true  );
				this.btn6.setVisible(true  );
				this.btn7.setVisible(true  );
				this.btn8.setVisible(true  );
				this.btn9.setVisible(true  );
				this.btn10.setVisible(true );
				
				break;

			case "Uninium":

				this.btn1.setVisible(false );
				this.btn2.setVisible(false );
				this.btn3.setVisible(false );
				this.btn4.setVisible(false );
				this.btn5.setVisible(false );
				this.btn6.setVisible(false );
				this.btn7.setVisible(false );
				this.btn8.setVisible(false );
				this.btn9.setVisible(false );
				this.btn10.setVisible(false);
				this.btn12.setVisible(false);
				this.btn13.setVisible(false);
				this.btn14.setVisible(false);
				this.btn15.setVisible(false);
				this.btn16.setVisible(false);

				this.btn11.setVisible(true);

				//Planete 1
				this.add(this.btn11);
			
				break;
			case "Quintum":

				//Planete 1
				this.add(this.btn12);
				
				//Planete 2
				this.add(this.btn13);

				//Planete 3
				this.add(this.btn14);

				//Planete 4
				this.add(this.btn15);

				//Planete 5
				this.add(this.btn16);

				this.btn1.setVisible(false );
				this.btn2.setVisible(false );
				this.btn3.setVisible(false );
				this.btn4.setVisible(false );
				this.btn5.setVisible(false );
				this.btn6.setVisible(false );
				this.btn7.setVisible(false );
				this.btn8.setVisible(false );
				this.btn9.setVisible(false );
				this.btn10.setVisible(false);
				this.btn11.setVisible(false);

				this.btn12.setVisible(true );
				this.btn13.setVisible(true );
				this.btn14.setVisible(true );
				this.btn15.setVisible(true );
				this.btn16.setVisible(true );
				
				break;
		}
	}

	
	public void paintComponent(Graphics g) 
	{
        super.paintComponent( g );
		g.drawImage( this.imgSysteme, 20, 5, this );
    }
}