public class Galaxie {

    public void conquerirPlanete(Planete planete, Joueur seigneurProprietaire){
        planete.changerProprietaire(seigneurProprietaire);
        seigneurProprietaire.ajouterPlanete(planete);
    }
    
}
