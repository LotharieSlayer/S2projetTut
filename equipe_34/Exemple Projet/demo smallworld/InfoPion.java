package smallworld;

import java.awt.Point;


/** Cette classe permet de donner à l'IHM des informations générales sur les différents
  * Jetons positionnés sur le Plateau.
  *
  * @author Philippe Le Pivert
  */
public class InfoPion
{
	private String image;
	private Point  pos;
	private int    nbJetons;

	public InfoPion ( String image, Point p, int nbJetons )
	{
		this.image    = image;
		this.pos      = p;
		this.nbJetons = nbJetons;
	}

	public String getImage    () { return this.image;    }
	public Point  getPos      () { return this.pos;      }
	public int    getNbJetons () { return this.nbJetons; }
}