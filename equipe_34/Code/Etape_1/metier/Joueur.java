package lesseigneurdutemps.metier;

import java.util.ArrayList;

public class Joueur {

    private String nom;
    private String couleurSeigneur;

    private ArrayList<Planete> planetesControlees;

	public Joueur ( String nom, String couleurSeigneur )
	{
        this.nom = nom;
        this.couleurSeigneur = couleurSeigneur;
    }
    
    public static Joueur creerJoueur ( String nom, String couleurSeigneur )
	{
		if ( nom == null || couleurSeigneur != "Noir" && couleurSeigneur != "Blanc")  return null;

		return new Joueur (nom, couleurSeigneur);
	}

    public String getNom() { return this.nom; }

    public void ajouterPlanete(Planete planete)
    {
        planetesControlees.add(planete);
    };

	public String toString()
	{
		return String.format ( "%-10s", this.nom, " : le Seigneur des Anneaux " + this.couleurSeigneur );
	}
    
    public String getCouleur() { return this.couleurSeigneur; }

}
