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

    private char systemeSolaireSelectionne;
    private String planeteSelectionne = " ";

    public void debutDePartie()
    {

        this.systemesSolaires = new ArrayList<SystemeSolaire>();

        systemesSolaires.add(   new SystemeSolaire("Triälum", Trialum, this)      );
        systemesSolaires.add(   new SystemeSolaire("Uninium", Uninium, this)      );
        systemesSolaires.add(   new SystemeSolaire("Mervelléum", Mervelleum, this));
        systemesSolaires.add(   new SystemeSolaire("Quintum", Quintum, this)      );

        //En attendant de trouver un moyen plus opti
        systemesSolaires.get(0).ajouterPlanete(new Planete("Namek"       , systemesSolaires.get(0)));
        systemesSolaires.get(0).ajouterPlanete(new Planete("Vegeta"      , systemesSolaires.get(0)));
        systemesSolaires.get(0).ajouterPlanete(new Planete("Bidal"       , systemesSolaires.get(0)));

        systemesSolaires.get(1).ajouterPlanete(new Planete("Allia"       , systemesSolaires.get(1)));

        systemesSolaires.get(2).ajouterPlanete(new Planete("Imegga"      , systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Kaiokaï"     , systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Plant"       , systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Yardrat"     , systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Zun"         , systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Kaioshinkaï" , systemesSolaires.get(2)));
        systemesSolaires.get(2).ajouterPlanete(new Planete("Alpha HZ"    , systemesSolaires.get(2)));

        systemesSolaires.get(3).ajouterPlanete(new Planete("Konatz"      , systemesSolaires.get(3)));
        systemesSolaires.get(3).ajouterPlanete(new Planete("Makyo"       , systemesSolaires.get(3)));
        systemesSolaires.get(3).ajouterPlanete(new Planete("Freezer n°79", systemesSolaires.get(3)));
        systemesSolaires.get(3).ajouterPlanete(new Planete("Meat"        , systemesSolaires.get(3)));
        systemesSolaires.get(3).ajouterPlanete(new Planete("Terre"         , systemesSolaires.get(3)));

        for (int cpt = 0; cpt < 10; cpt++)
        {
            int rdm1 = 0, rdm2 = 0;

            while(rdm1 == rdm2)
            {
                rdm1 = (int)(Math.random() * 4);
                rdm2 = (int)(Math.random() * 4);
            }

            SystemeSolaire tmp        = systemesSolaires.get(rdm1);
            systemesSolaires.set(rdm1, systemesSolaires.get(rdm2));
            systemesSolaires.set(rdm2, tmp);
        }
    }

    public ArrayList<SystemeSolaire> getSystemesSolaires(){return systemesSolaires;}

    public void avancerSystemeSolaire(SystemeSolaire systemeSolaireSelectionne)
    {
        int position = 0;
        int cpt      = 0;

        while(systemeSolaireSelectionne.getNom().equals(systemesSolaires.get(cpt).getNom()) == false)
        {
            cpt++;  
        }

        position = cpt;
        if(position < 3)
        {
            SystemeSolaire tmp           =      systemesSolaires.get(position);
            systemesSolaires.set(position, systemesSolaires.get(position + 1));
            systemesSolaires.set(position + 1, tmp);
        }
    }

    public void setPlanete(String planeteSelectionne)
    {
        this.planeteSelectionne = planeteSelectionne;
        switch(planeteSelectionne)
        {
            case "Namek":
                this.systemeSolaireSelectionne = 'T';
                break;
            case "Vegeta":
                this.systemeSolaireSelectionne = 'T';
                break;
            case "Bidal":
                this.systemeSolaireSelectionne = 'T';
                break;
            case "Allia":
                this.systemeSolaireSelectionne = 'U';
                break;
            case "Imegga":
                this.systemeSolaireSelectionne = 'M';
                break;
            case "Kaiokaï":
                this.systemeSolaireSelectionne = 'M';
                break;
            case "Plant":
                this.systemeSolaireSelectionne = 'M';
                break;
            case "Yardrat":
                this.systemeSolaireSelectionne = 'M';
                break;
            case "Zun":
                this.systemeSolaireSelectionne = 'M';
                break;
            case "Kaioshinkaï":
                this.systemeSolaireSelectionne = 'M';
                break;
            case "Alpha HZ":
                this.systemeSolaireSelectionne = 'M';
                break;
            case "Konatz":
                this.systemeSolaireSelectionne = 'Q';
                break;
            case "Makyo":
                this.systemeSolaireSelectionne = 'Q';
                break;
            case "Freezer n°79":
                this.systemeSolaireSelectionne = 'Q';
                break;
            case "Meat":
                this.systemeSolaireSelectionne = 'Q';
                break;
            case "Terre":
                this.systemeSolaireSelectionne = 'Q';
                break;
            case " ":
                this.systemeSolaireSelectionne = ' ';
        }
    }
    public String getPlaneteSelectionne(){ return this.planeteSelectionne; } 
    public char getSystemeSolaireSelectionne(){ return this.systemeSolaireSelectionne; } 
}