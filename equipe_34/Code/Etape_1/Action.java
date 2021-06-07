import java.util.Scanner;

public class Action
{
    private String action;
    private String planete;

    private final int Triälum    = 3;
    private final int Uninium    = 1;
    private final int Mervelléum = 7;
    private final int Quintum    = 5;

    public Action
    {
        private String action (int nbDispo, int nbNoir, int nbBlanche)
            {

                Scanner clavier = new Scanner(System.in);
                System.out.print("Saisir votre action : ");
                action = clavier.nextLine();

                if (action == "n" || action == "b")
                {
                    System.out.print("Saisir la planete de votre choix : ");
                    planete = clavier.nextLine();

                    if (planete == "1" || planete == "2" || planete == "3" || planete == "4")
                    {

                    }
                    else
                    {
                        System.out.println("Planete choisi est invalide")
                    }
                }
                else
                {
                    System.out.println("Action saisie est indisponible")
                }
        
                // fermer les ressources
                clavier.close();
            }

        private String génerationDesSystem()
        {
            List<String> list = new ArrayList<String>();
            list.add("Triälum");
            list.add("Uninium");
            list.add("Mervelléum");
            list.add("Quintum");
            String position1 = list.get(new Random().nextInt(list.size()));
            
            String position2 = list.get(new Random().nextInt(list.size()));
            while (position2 == position1)
            {
                String position2 = list.get(new Random().nextInt(list.size()));
            }
            
            String position3 = list.get(new Random().nextInt(list.size()));
            while (position3 == position1 || position3 == position2)
            {
                String position3 = list.get(new Random().nextInt(list.size()));
            }
            
            String position4 = list.get(new Random().nextInt(list.size()));
            while (position4 == position1 || position4 == position2 || position4 == position3)
            {
                String position4 = list.get(new Random().nextInt(list.size()));
            }
        }
    }
}