package smallworld.metier;

public class Peuple implements java.io.Serializable
{
	private String nom;
	private String pouvoir;
	private Joueur joueur;
	private int    nbPionEnMain;


	public Peuple ( String nom, String pouvoir, int nbPionEnMain )
	{
		this.nom          = nom;
		this.pouvoir      = pouvoir;
		this.joueur       = null;
		this.nbPionEnMain = nbPionEnMain;
	}

	public String getNom          () { return this.nom;            }
	public String getPouvoir      () { return this.pouvoir;        }
	public Joueur getJoueur       () { return this.joueur;         }
	public int    getNbPionEnMain () { return this.nbPionEnMain;   }

	public void deltaPionEnMain (int delta)
	{
		if ( this.nbPionEnMain + delta >= 0 )
			this.nbPionEnMain += delta;
	}


	public void setJoueur ( Joueur j ){ this.joueur = j; }

	public String toString()
	{
		return String.format ( "%10s", this.nom ) + " " + (this.joueur!=null? "(" +this.joueur.getNom() + ")" : "" );
	}

}