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

    public void debutDePartie(boolean data, String[][] sData, Joueur seigneurA, Joueur seigneurB)
    {
        if(data == true)
        {
            this.systemesSolaires = new ArrayList<SystemeSolaire>();

            for (int i=0; i<4;i++) {
                switch(sData[i][0])
                {
                    case "Triälum" :
                        systemesSolaires.add( new SystemeSolaire(sData[i][0].replaceAll(" ",""), Trialum, this));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Namek", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Vegeta", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Bidal", systemesSolaires.get(i)));
                        break;

                    case "Uninium" :
                        systemesSolaires.add( new SystemeSolaire(sData[i][0].replaceAll(" ",""), Uninium, this));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Allia", systemesSolaires.get(i)));
                        break;

                    case "Mervelléum" :
                        systemesSolaires.add( new SystemeSolaire(sData[i][0].replaceAll(" ",""), Mervelleum, this));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Imegga", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Kaiokaï", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Plant", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Yardrat", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Zun", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Kaioshinkaï", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Alpha HZ", systemesSolaires.get(i)));
                        break;
                    
                    case "Quintum" :
                        systemesSolaires.add( new SystemeSolaire(sData[i][0].replaceAll(" ",""), Quintum, this));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Konatz", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Makyo", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Freezer n°79", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Meat", systemesSolaires.get(i)));
                        systemesSolaires.get(i).ajouterPlanete(new Planete("Zun", systemesSolaires.get(i)));
                        break;
                }
                int j = 0, k = 0;
                while(j < Integer.parseInt(sData[i][1]))
                {
                    systemesSolaires.get(i).ajouterPlaneteJoueurA();
                    systemesSolaires.get(i).getPlanetes().get(j).changerProprietaire(seigneurA);
                    j++;
                }
                while(k < Integer.parseInt(sData[i][2]))
                {
                    systemesSolaires.get(i).ajouterPlaneteJoueurB();
                    systemesSolaires.get(i).getPlanetes().get(j+k).changerProprietaire(seigneurB);
                    k++;
                }
            }
        }
        else
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
        if(position < 3)
        {
            SystemeSolaire tmp = systemesSolaires.get(position);
            systemesSolaires.set(position, systemesSolaires.get(position + 1));
            systemesSolaires.set(position + 1, tmp);
        }
    }  
}