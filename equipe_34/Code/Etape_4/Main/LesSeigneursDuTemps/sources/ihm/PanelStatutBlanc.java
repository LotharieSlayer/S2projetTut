package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.RoundRectangle2D;
import javax.imageio.ImageIO;
import java.io.*;


/*--------------------------------------------*/
/* Classe PanelImage                          */
/*--------------------------------------------*/
public class PanelStatutBlanc extends JPanel
{
	private Controleur  ctrl       ;

	//private JLabel lblTimer;
	private JLabel      lblStatut  ;
	private JLabel      lblSubtitle;
	private JPanel      pnlMain    ;
	private JPanel      pnlMessage ;
	private JPanel      pnlSubtitle;

	private Image       imgFond    ;


	public PanelStatutBlanc(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);

		//FONT
		this.lblStatut   = new JLabel("C’est au tour du seigneur Blanc ! (=^.^=)",     JLabel.CENTER);
		this.lblSubtitle = new JLabel("Choisissez la planète à conquérir ou libérer.", JLabel.CENTER);
		String fName  = "./fonts/Montserrat/Montserrat-Bold.ttf";
		String f2Name = "./fonts/FreePixel.ttf";
		InputStream fFont  = PanelStatutBlanc.class.getResourceAsStream(fName );
		InputStream f2Font = PanelStatutBlanc.class.getResourceAsStream(f2Name);
		
		try 
		{
			Font font      = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font bigFont   = font.deriveFont(Font.PLAIN, 45);
			Font font2     = Font.createFont(Font.TRUETYPE_FONT, f2Font);
			Font smallFont = font2.deriveFont(Font.PLAIN, 16);
			
			this.lblStatut.setFont(bigFont);
			this.lblStatut.setForeground(Color.BLACK);
			this.lblSubtitle.setFont(smallFont);
			this.lblSubtitle.setForeground(Color.BLACK);
		}
		catch (IOException e)        { e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }

		//Rectangle
		this.imgFond = Toolkit.getDefaultToolkit().getImage( "./images/msgStatut/RectangleB.png" );

		
		this.pnlMessage = new JPanel( new BorderLayout(0,40) );
		this.pnlMessage.add( this.lblStatut, BorderLayout.CENTER );
		this.pnlMessage.add( this.lblSubtitle, BorderLayout.SOUTH );
		this.pnlMessage.setOpaque(false);
		this.pnlMain    = new JPanel( new FlowLayout(0,0,65) );
		this.pnlMain.add(this.pnlMessage);
		this.pnlMain.setOpaque(false);

		this.add(pnlMain);
	}

	public void paintComponent(Graphics g) 
	{
        super.paintComponent( g );
		g.drawImage( this.imgFond, 290, 50, this );
    }
}