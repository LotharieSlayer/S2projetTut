package equipe_34.lesSeigneursDuTemps.ihm;

import equipe_34.lesSeigneursDuTemps.Controleur;

import javax.swing.*;
import java.awt.*;


/*--------------------------------------------*/
/* Classe PanelImage                          */
/*--------------------------------------------*/
public class PanelJoueur extends JPanel
{
	private Controleur       ctrl        ;
	private JPanel		     pnlMain     ;

	private PanelSysteme     panelSelect1;
	private PanelSysteme     panelSelect2;
	private PanelSysteme     panelSelect3;
	private PanelSysteme     panelSelect4;
	private PanelCentre      pnlCentre   ;


	public PanelJoueur(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		this.setLayout( new GridLayout( 1, 5 ) );

		this.panelSelect1 = new PanelSysteme(this.ctrl, 0);
		this.panelSelect2 = new PanelSysteme(this.ctrl, 1);
		this.panelSelect3 = new PanelSysteme(this.ctrl, 2);
		this.panelSelect4 = new PanelSysteme(this.ctrl, 3);

		this.pnlCentre    = new PanelCentre(this.ctrl);
		this.pnlCentre.setLayout( new GridLayout(2,0));

		this.add(this.panelSelect1);
		this.add(this.panelSelect2);
		this.add(this.panelSelect3);
		this.add(this.panelSelect4);

		this.add(this.pnlCentre   );
	}

	public void maj(Controleur ctrl)
	{
		this.panelSelect1.maj(ctrl, 0);
		this.panelSelect2.maj(ctrl, 1);
		this.panelSelect3.maj(ctrl, 2);
		this.panelSelect4.maj(ctrl, 3);
	}
}