package smallworld.metier;



public class Joueur implements java.io.Serializable
{
	private String nom;
	private int    pv;

	public Joueur ( String nom )
	{
		this.nom = nom;
		this.pv  = 0;
	}

	public String getNom() { return this.nom; }
	public int    getPv () { return this.pv;  }

	public void   incrementerPv( int pv )
	{
		this.pv += pv;
	}

	public String toString()
	{
		return String.format ( "%-10s", this.nom ) + " " + String.format ( "%3d", this.pv );
	}
}