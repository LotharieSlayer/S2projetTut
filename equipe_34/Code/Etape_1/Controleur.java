import java.util.Scanner;

public class Controleur
{
    public Controleur()
    {
        
        public void action ( int numJoueur, char action, int numTerritoire )
	{
		this.metier.action ( numJoueur, action, numTerritoire );

		if ( numJoueur == 1 ) this.frameJoueur1.maj();
		if ( numJoueur == 2 ) this.frameJoueur2.maj();

		this.framePlateau.maj();

	}

    public static void main(String[] a)
	{
		new Controleur();
	}
}