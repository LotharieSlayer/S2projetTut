import java.util.Scanner;
import java.util.ArrayList;
import java.math.*;

public class Galaxie
{
    private String action;
    private String planete;

    private ArrayList<SystemeSolaire> systemesSolaires;

    private final int Triälum    = 3;
    private final int Uninium    = 1;
    private final int Mervelléum = 7;
    private final int Quintum    = 5;

    public void conquerirPlanete(Planete planete, Joueur seigneurProprietaire){
        planete.changerProprietaire(seigneurProprietaire);
        seigneurProprietaire.ajouterPlanete(planete);
    }

    private void debutDePartie()
    {
        systemesSolaires.add( new SystemeSolaire("Triälum", Triälum));
        systemesSolaires.add( new SystemeSolaire("Uninium", Uninium));
        systemesSolaires.add( new SystemeSolaire("Mervelléum", Mervelléum));
        systemesSolaires.add( new SystemeSolaire("Quintum", Quintum));

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

    private void avancerSystemeSolaire(Planete planete)
    {
        int position;
        String nomSysteme;
        nomSysteme = planete.getSystemeSolaire().getNom();

        int cpt = 0 ;
        while(cpt < 4){
            if(nomSysteme == systemesSolaires.get(cpt).getNom())
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