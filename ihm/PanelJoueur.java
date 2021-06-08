import javax.swing.*;
import java.awt.*;


/*--------------------------------------------*/
/* Classe PanelImage                          */
/*--------------------------------------------*/
public class PanelJoueur extends JPanel
{
	private Controleur  ctrl;
	private JPanel		pnlMain;
	private JLabel		test = new JLabel();

	private PanelSelectSysteme     panelSelectTrialum;
	private PanelSelectSysteme     panelSelectUninium;
	private PanelSelectSysteme     panelSelectMervelleum;
	private PanelSelectSysteme     panelSelectQuintum;


	public PanelJoueur(Controleur ctrl)
	{
		this.ctrl = ctrl;
		pnlMain = new JPanel();
		this.pnlMain.setLayout( new GridLayout(0,5) );
		this.setBackground(Color.WHITE);
		this.panelSelectTrialum = new PanelSelectSysteme();//, this.ctrl);
		this.add(this.panelSelectTrialum);
	}

}