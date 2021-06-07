import java.util.ArrayList;

public class SystemeSolaire {

    private String nom     ;
    private int    position;
    private int    nbPlanet;

	public SystemeSolaire (String nom, int position, int nbPlanet)
	{
        this.nom      = nom     ;
        this.position = position;
        this.nbPlanet = nbPlanet;
    }
    
    public SystemeSolaire (String nom, int position, int nbPlanet)
    {
    		if (nom != "Triälum" || nom != "Uninium" || nom != "Mervelléum" || nom != "Quintum") return null;
    		else return new SystemeSolaire
    
	/*public String toString ()
	{
    }*/
}
