package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.*;
public class Planete 
{

    private String nom;
    private SystemeSolaire systemeSolaire;
    private Joueur seigneurProprietaire;

	public Planete(String nom, SystemeSolaire systemeSolaire)
	{
        this.nom = nom;
        this.systemeSolaire = systemeSolaire;
    }

    public Planete(SystemeSolaire systemeSolaire)
	{
        this.systemeSolaire = systemeSolaire;
    }

    //methode retournant un valeur simple propre à Planete
    public String         getNom()           { return this.nom; }
    public Joueur         getProprietaire()  { return this.seigneurProprietaire; }
    public SystemeSolaire getSystemeSolaire(){ return this.systemeSolaire; }

    //donne un nouveau proprietaire a la planete
    public void changerProprietaire(Joueur seigneurProprietaire){this.seigneurProprietaire = seigneurProprietaire;}

    //retire le seigneur proprietaire de la planete 
    public void libererProprietaire(){this.seigneurProprietaire = null;}
}
