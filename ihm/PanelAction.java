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
public class PanelAction extends JPanel implements ActionListener
{
	private Controleur  ctrl;

	//private JLabel lblTimer;
	private JLabel lblStatut;
	private JLabel lblSubtitle;
	private JPanel pnlMain;
	private JPanel pnlMessage;
	private JPanel pnlSubtitle;


	private JButton btnConqerir;
	private JButton btnLiberer;

	private Image imgFond;


	public PanelAction(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);

		//FONT
		this.lblStatut = new JLabel("Conquérir", JLabel.RIGHT);
		this.lblSubtitle = new JLabel("Jouer le tour", JLabel.CENTER); //⎯⎯⎯⎯⎯⎯
		String fName = "./assets/fonts/Montserrat/Montserrat-Bold.ttf";
		String f2Name = "./assets/fonts/FreePixel.ttf";
		InputStream fFont = PanelAction.class.getResourceAsStream(fName);
		InputStream f2Font = PanelAction.class.getResourceAsStream(f2Name);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font bigFont = font.deriveFont(Font.PLAIN, 45);
			Font font2 = Font.createFont(Font.TRUETYPE_FONT, f2Font);
			Font smallFont = font2.deriveFont(Font.PLAIN, 16);
			
			this.lblStatut.setFont(bigFont);
			this.lblStatut.setForeground(Color.BLACK);
			this.lblSubtitle.setFont(smallFont);
			this.lblSubtitle.setForeground(Color.BLACK);
		}
		catch (IOException e){ e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }

		//Rectangle
		ImageIcon icon = new ImageIcon("assets/msgStatut/Bouton.png");

		this.btnConqerir = new JButton("Conquérir", icon);
		this.btnConqerir.setPreferredSize(new Dimension(280,70));
		this.btnConqerir.addActionListener(this);
		this.btnLiberer = new JButton("Libérer");
		this.btnLiberer.setPreferredSize(new Dimension(280,70));
		this.btnLiberer.addActionListener(this);
		
		this.pnlMessage = new JPanel( new BorderLayout(0,0) );
		this.pnlMessage.add( this.btnConqerir, BorderLayout.CENTER );
		this.pnlMessage.add( this.btnLiberer, BorderLayout.EAST );
		this.pnlMessage.add( this.lblSubtitle, BorderLayout.SOUTH );
		this.pnlMessage.setOpaque(false);
		this.pnlMain = new JPanel( new FlowLayout(0,0,0) );
		this.pnlMain.add(this.pnlMessage);
		this.pnlMain.setOpaque(false);

		this.add(pnlMain);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}