package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.Controleur;

import javax.swing.*;
import java.awt.*;

import java.io.*;
import javax.imageio.ImageIO;


/*--------------------------------------------*/
/* Classe PanelImage                          */
/*--------------------------------------------*/
public class PanelSysteme extends JPanel
{
	private Controleur         ctrl   ;
	private JPanel		       pnlMain;

	private PanelSelectSysteme panelSelectSysteme       ;
	private JLabel			   lblPlanete = new JLabel();

	public PanelSysteme( Controleur ctrl, int NumPlaceSysteme)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		this.setLayout( new BorderLayout() );

		this.panelSelectSysteme = new PanelSelectSysteme(this.ctrl, NumPlaceSysteme);

			
		//FONT
		String      fName = "./fonts/Montserrat/Montserrat-Bold.ttf"           ;
		InputStream fFont = PanelSelectSysteme.class.getResourceAsStream(fName);
		try 
		{
			Font font    = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font bigFont = font.deriveFont(Font.PLAIN, 42);
			
			this.lblPlanete.setText(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom());
			this.lblPlanete.setHorizontalAlignment(JLabel.CENTER);
			this.lblPlanete.setFont(bigFont);
			this.lblPlanete.setForeground(Color.BLACK);

		}
		catch (IOException e)        { e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }

		this.add(this.panelSelectSysteme, BorderLayout.CENTER);
		this.add(this.lblPlanete, BorderLayout.SOUTH);
	}

	public void maj(Controleur ctrl, int NumPlaceSysteme)
	{
		this.panelSelectSysteme.maj(ctrl, NumPlaceSysteme);
		this.lblPlanete.setText(ctrl.getGalaxie().getSystemesSolaires().get(NumPlaceSysteme).getNom());
	}
}