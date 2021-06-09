import javax.swing.*;
import java.awt.*;


/*--------------------------------------------*/
/* Classe PanelImage                          */
/*--------------------------------------------*/
public class PanelJoueur extends JPanel
{
	private Controleur  ctrl;
	private JPanel		pnlMain;

	private PanelSelectSysteme     panelSelectTrialum;
	private PanelSelectSysteme     panelSelectUninium;
	private PanelSelectSysteme     panelSelectMervelleum;
	private PanelSelectSysteme     panelSelectQuintum;
	private PanelCentre            pnlCentre;


	public PanelJoueur(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		this.setLayout( new GridLayout( 1, 5 ) );

		this.panelSelectTrialum = new PanelSelectSysteme(this.ctrl);
		this.panelSelectUninium = new PanelSelectSysteme(this.ctrl);
		this.panelSelectMervelleum = new PanelSelectSysteme(this.ctrl);
		this.panelSelectQuintum = new PanelSelectSysteme(this.ctrl);

		this.pnlCentre = new PanelCentre(this.ctrl);
		this.pnlCentre.setLayout( new GridLayout(2,0));

		this.add(this.panelSelectTrialum);
		this.add(this.panelSelectUninium);
		this.add(this.panelSelectMervelleum);
		this.add(this.panelSelectQuintum);

		this.add(this.pnlCentre);
	}

}