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


	private JLabel lblPlanete = new JLabel();

	/*--------------*/
	/* Constructeur */
	/*--------------*/

	public PanelSelectSysteme(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		this.setLayout ( new BorderLayout() );


		/*-------------------------------*/
		/* Création des composants       */
		/*-------------------------------*/
	
		//FONT
		String fName = "./fonts/Montserrat/Montserrat-Bold.ttf";
		InputStream fFont = PanelSelectSysteme.class.getResourceAsStream(fName);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font bigFont = font.deriveFont(Font.PLAIN, 42);
			
			this.lblPlanete.setText(" Trialum ");
			this.lblPlanete.setHorizontalAlignment( JLabel.CENTER );
			this.lblPlanete.setFont(bigFont);
			this.lblPlanete.setForeground(Color.BLACK);
		}
		catch (IOException e){ e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }


		/*----------------------------------------------*/
		/* Positionnement des Composants                */
		/*----------------------------------------------*/

		
 		//Panel Haut (Image selon objet Planète)
		// try {
		// 	BufferedImage image = ImageIO.read(new File("assets/systemes/Trialum.png"));
		// 	JLabel lblImage = new JLabel(new ImageIcon(image));
		// 	panelHaut.add(lblImage);
		// } catch (IOException e) { e.printStackTrace(); }

		
		//Systeme
		this.imgSysteme = Toolkit.getDefaultToolkit().getImage( "./images/systemes/Trialum.png" );

		// Panel Bas (Titre de la planète)
		this.add( this.lblPlanete, BorderLayout.SOUTH );

	}

	
	public void paintComponent(Graphics g) {
        super.paintComponent( g );
		g.drawImage( this.imgSysteme, 15, 5, this );
    }
}