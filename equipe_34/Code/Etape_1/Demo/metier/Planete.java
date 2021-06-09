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

    public String getNom(){ return this.nom; }

    public Joueur getProprietaire(){ return this.seigneurProprietaire; }

    public SystemeSolaire getSystemeSolaire(){ return this.systemeSolaire; }

    public void changerProprietaire(Joueur seigneurProprietaire){
        this.seigneurProprietaire = seigneurProprietaire;
    }

    public void libererProprietaire()
    {
        this.seigneurProprietaire = null;
    }
}
