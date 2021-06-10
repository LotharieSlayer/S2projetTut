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
public class PanelAction extends JPanel implements ActionListener
{
	private Controleur  ctrl;

	//private JLabel lblTimer;
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
		this.lblSubtitle = new JLabel("Jouer le tour :", JLabel.RIGHT);
		String fName = "./fonts/FreePixel.ttf";
		InputStream fFont = PanelAction.class.getResourceAsStream(fName);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, fFont);
			Font smallFont = font.deriveFont(Font.PLAIN, 16);
			this.lblSubtitle.setFont(smallFont);
			this.lblSubtitle.setForeground(Color.BLACK);
			this.add(this.lblSubtitle);
		}
		catch (IOException e){ e.printStackTrace(); }
		catch (FontFormatException e){ e.printStackTrace(); }


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

		this.btnConqerir.addActionListener( this );
		this.btnLiberer.addActionListener( this );
	}

	public void actionPerformed(ActionEvent e) {
		this.ctrl.action("Noir", 'C', 'T');
	}


}