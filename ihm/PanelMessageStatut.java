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
	private JLabel lblStatut = new JLabel();

    private JPanel pnlRectangle = new JPanel();
    private JPanel pnlMessage = new JPanel();


	public PanelMessageStatut(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		String fName = "./assets/fonts/Montserrat/Montserrat-Bold.ttf";
		InputStream fFont = PanelMessageStatut.class.getResourceAsStream(fName);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font bigFont = font.deriveFont(Font.PLAIN, 50);
			
			this.lblStatut.setText("HAHAHAAHAHAHA");
			this.lblStatut.setFont(bigFont);
			this.lblStatut.setForeground(Color.BLACK);
			this.pnlMessage.add(this.lblStatut);
		}
		catch (IOException e){ e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }

		//Image po
		try {
 			BufferedImage image = ImageIO.read(new File("assets/msgStatut/Rectangle.png"));
			JLabel lblImage = new JLabel(new ImageIcon(image));
			this.pnlRectangle.add(lblImage);
		} catch(IOException e) { e.printStackTrace(); }

		//this.setComponentZOrder(this.pnlMessage, 1);
		//this.setComponentZOrder(this.pnlRectangle, 0);

		this.pnlRectangle.setBackground(Color.WHITE);
		this.pnlMessage.setBackground(Color.WHITE);

		//this.add(this.pnlRectangle);
		this.add(this.pnlMessage);
	}

	//Rectangle arrondi pas beau ici en mode graphique car pas d'Anti-Aliasing sur Java
/* 	public void paint(Graphics g) {
        Graphics2D graphics2 = (Graphics2D) g;
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(350, 100, 850, 100, 100, 100);
        graphics2.setColor(new Color(0, 0, 0));
        graphics2.fill(roundedRectangle);
		graphics2.draw(roundedRectangle);
    } */

}