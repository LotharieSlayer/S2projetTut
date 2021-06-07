package equipe_34.lesSeigneursDuTemps.metier;

import equipe_34.lesSeigneursDuTemps.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.math.*;

public class Galaxie
{
    private ArrayList<SystemeSolaire> systemesSolaires;

    private final int Trialum    = 3;
    private final int Uninium    = 1;
    private final int Mervelleum = 7;
    private final int Quintum    = 5;

    public void conquerirPlanete(Planete planete, Joueur seigneurProprietaire){
        planete.changerProprietaire(seigneurProprietaire);
        seigneurProprietaire.ajouterPlanete(planete);
    }

    private void debutDePartie()
    {
        systemesSolaires.add( creerSystemeSolaire("Triälum", Trialum));
        systemesSolaires.add( creerSystemeSolaire("Uninium", Uninium));
        systemesSolaires.add( creerSystemeSolaire("Mervelléum", Mervelleum));
        systemesSolaires.add( creerSystemeSolaire("Quintum", Quintum));

        //En attendant de trouver un moyen plus opti
        systemesSolaires.get(0).ajouterPlanete(new Planete("Namek", systemesSolaires.get(0)));
        systemesSolaires.get(0).ajouterPlanete(new Planete("Vegeta", systemesSolaires.get(0)));
        systemesSolaires.get(0).ajouterPlanete(new Planete("Bidal", systemesSolaires.get(0)));

        systemesSolaires.get(1).ajouterPlanete(new Planete("Allia", systemesSolaires.get(1)));

        systemesSolaires.get(2).ajouterPlanete(new Planete("Imegga", systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Kaiokaï", systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Plant", systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Yardrat", systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Zun", systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Kaioshinkaï", systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Alpha HZ", systemesSolaires.get(2)));

        systemesSolaires.get(3).ajouterPlanete(new Planete("Konatz", systemesSolaires.get(3)));
        systemesSolaires.get(3).ajouterPlanete(new Planete("Makyo", systemesSolaires.get(3)));
        systemesSolaires.get(3).ajouterPlanete(new Planete("Freezer n°79", systemesSolaires.get(3)));
        systemesSolaires.get(3).ajouterPlanete(new Planete("Meat", systemesSolaires.get(3)));
        systemesSolaires.get(3).ajouterPlanete(new Planete("Zun", systemesSolaires.get(3)));

        for (int cpt = 0; cpt < 10; cpt++)
        {
            int rdm1, rdm2;

            rdm1 = (int) Math.random() * 4;
            rdm2 = (int) Math.random() * 4;

            SystemeSolaire tmp = systemesSolaires.get(rdm1);
            systemesSolaires.set(rdm1, systemesSolaires.get(rdm2));
            systemesSolaires.set(rdm2, tmp);
        }
    }

    private void avancerSystemeSolaire(SystemeSolaire systemeSolaire)
    {
        int position = 0;

        int cpt = 0 ;
        while(cpt < 4){
            if(systemeSolaire.getNom() == systemesSolaires.get(cpt).getNom())
            {
                position = cpt;
            }
            cpt++;
        }

        if(position < 4)
        {
            SystemeSolaire tmp = systemesSolaires.get(position);
            systemesSolaires.set(position, systemesSolaires.get(position++));
            systemesSolaires.set(position++, tmp);
        }
    }  
}