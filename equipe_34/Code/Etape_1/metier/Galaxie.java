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

    public void debutDePartie()
    {

        this.systemesSolaires = new ArrayList<SystemeSolaire>();

        systemesSolaires.add( new SystemeSolaire("Triälum", Trialum, this));
        systemesSolaires.add( new SystemeSolaire("Uninium", Uninium, this));
        systemesSolaires.add( new SystemeSolaire("Mervelléum", Mervelleum, this));
        systemesSolaires.add( new SystemeSolaire("Quintum", Quintum, this));

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
            int rdm1 = 0, rdm2 = 0;

            while(rdm1 == rdm2){
                rdm1 = (int)(Math.random() * 4);
                rdm2 = (int)(Math.random() * 4);
            }

            SystemeSolaire tmp = systemesSolaires.get(rdm1);
            systemesSolaires.set(rdm1, systemesSolaires.get(rdm2));
            systemesSolaires.set(rdm2, tmp);
        }
    }

    public ArrayList<SystemeSolaire> getSystemesSolaires(){return systemesSolaires;}

    public void avancerSystemeSolaire(SystemeSolaire systemeSolaireSelectionne)
    {
        int position = 0;

        int cpt = 0 ;

        while(systemeSolaireSelectionne.getNom().equals(systemesSolaires.get(cpt).getNom()) == false)
        {
            cpt++;  
        }
        position = cpt;
        System.out.println(position);
        if(position < 3)
        {
            SystemeSolaire tmp = systemesSolaires.get(position);
            systemesSolaires.set(position, systemesSolaires.get(position + 1));
            systemesSolaires.set(position + 1, tmp);
        }
    }  
}