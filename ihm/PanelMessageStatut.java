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
public class PanelMessageStatut extends JPanel
{
	private Controleur  ctrl;

	//private JLabel lblTimer;
	private JLabel lblStatut;
	private JPanel pnlMessage;

	private Image imgFond;


	public PanelMessageStatut(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);

		//FONT
		this.lblStatut = new JLabel("C’est au tour du seigneur Noir ! ^^");
		String fName = "./assets/fonts/Montserrat/Montserrat-Bold.ttf";
		InputStream fFont = PanelMessageStatut.class.getResourceAsStream(fName);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font bigFont = font.deriveFont(Font.PLAIN, 50);
			
			this.lblStatut.setFont(bigFont);
			this.lblStatut.setForeground(Color.WHITE);
		}
		catch (IOException e){ e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }

		//Rectangle
		this.imgFond = Toolkit.getDefaultToolkit().getImage( "assets/msgStatut/Rectangle.png" );
		this.pnlMessage = new JPanel( new FlowLayout(0, 0, 30) );
		this.pnlMessage.add( this.lblStatut );
		this.pnlMessage.setOpaque(false);
		this.add(this.pnlMessage);
	}

	//Rectangle arrondi pas beau ici en mode graphique car pas d'Anti-Aliasing sur Java
	public void paintComponent(Graphics g) {
        super.paintComponent( g );
		g.drawImage( this.imgFond, 290, 20, this );
    }

}