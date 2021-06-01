package smallworld.metier;

import smallworld.Message;

import java.util.List;
import java.util.ArrayList;
import java.awt.Point;


/** Cette Classe permet de gérer l'ensemble des Territoires
  * et plus particulièrement de gérer les règles de conquêtes et de retraite.
  *
  * @author Philippe Le Pivert
  */
public class Territoire implements java.io.Serializable
{
	private int                   numTerritoire;
	private Nature                nature;
	private List<Territoire>      voisins;
	private boolean               auBord;

	private Peuple                peuple;
	private int                   nbPion;

	private Point                 point;


	public Territoire ( int numTerritoire, Nature nature, boolean auBord, Point pointCentral )
	{
		this.nature        = nature;
		this.numTerritoire = numTerritoire;
		this.voisins       = new ArrayList<Territoire>();
		this.auBord        = auBord;
		this.peuple        = null;
		this.nbPion        = 0;
		this.point         = pointCentral;
	}


	public String enleverPeuple (Peuple p)
	{
		if ( this.peuple == null ) return Message.ERR_TERR_VIDE.getLib();
		if ( this.peuple != p    ) return Message.ERR_TERR_AUTRE.getLib();
		if ( this.nbPion == 0    ) return Message.ERR_NB_JETON_0.getLib();

		this.nbPion--;
		p.deltaPionEnMain ( +1 );

		// si on enlève le dernier pion, il n'y a alors plus de Peuple
		if ( this.nbPion == 0 )	this.peuple = null;

		return Message.OK.getLib();
	}


	public String ajouterPeuple (Peuple p , int nbTerrOccupe)
	{
		// verif qu'il reste suffisament de jeton en main
		if  (  p.getNbPionEnMain() == 0 ) return Message.ERR_NB_JETON_0.getLib();


		// On conquiert un nouveau Territoire
		if ( this.peuple == null )
		{
			// doit se faire par le bord si nous n'avons encore aucune Possession de Territoire pour ce Peuple
			//               par un Territoire Adjacent déjà occupé par notre peuple, si nous avons déjà des possession pour ce Peuple
			if  ( nbTerrOccupe == 0 && ! this.auBord                    ) return Message.ERR_POS_INVALID_B.getLib();
			if  ( nbTerrOccupe  > 0 && ! this.aUnVoisinCompatible ( p ) ) return Message.ERR_POS_INVALID_A.getLib();

			this.peuple = p;
			this.nbPion = 1;
			p.deltaPionEnMain ( -1 );

			return Message.OK.getLib();
		}


		// Le Terroire est déjà occupée par un AUTRE PEUPLE : dans le jeu original il y aurait attaque (que l'on ne gère pas ici)
		if ( this.peuple != p  ) return Message.ERR_TERR_AUTRE.getLib();


		// On Place des Peuple supplémentaires sur un Territoire que l'on possède déjà
		if ( this.peuple == p )
		{
			this.nbPion++;
			p.deltaPionEnMain ( -1 );

			return Message.OK.getLib();
		}


		return Message.ERR_ACTION_INVALID.getLib();
	}


	public Nature getNature() { return this.nature;	}
	public Peuple getPeuple() { return this.peuple; }
	public int    getNbPion() { return this.nbPion; }
	public Point  getPoint () { return this.point;	}


	private boolean aUnVoisinCompatible( Peuple p )
	{
		for ( Territoire pVoisin : voisins )
			if ( pVoisin.peuple == p ) return true;

		return false;
	}


	public void ajouterVoisins ( Territoire t )
	{
		this.voisins.add ( t );
		t.voisins.add ( this );
	}



	public static List<Territoire> initMap()
	{
		List<Territoire> alRet = new ArrayList<Territoire>();

		/*--------------------------------*/
		/* Constructions des Territoires  */
		/*--------------------------------*/
		Nature[]   tabTempTerr = { Nature.MER,      Nature.CHAMP,   Nature.FORET,    Nature.MARAIS, Nature.PRAIRIE,
		                           Nature.MONTAGNE, Nature.PRAIRIE, Nature.MONTAGNE, Nature.CHAMP,  Nature.FORET,
		                           Nature.CHAMP,    Nature.FORET,   Nature.MER,      Nature.CHAMP,  Nature.PRAIRIE,
		                           Nature.MONTAGNE, Nature.MARAIS,  Nature.PRAIRIE,  Nature.MARAIS, Nature.MONTAGNE,
		                           Nature.MARAIS,   Nature.FORET,   Nature.MER  };

		Point[]  tabTempPoint = { new Point( 175, 50), new Point( 395, 76), new Point( 555, 82), new Point(755, 54), new Point(1049, 66),
		                          new Point( 216,216), new Point( 450,230), new Point( 730,195), new Point(875,155), new Point(1141,180),
		                          new Point( 200,360), new Point( 492,414), new Point( 620,305), new Point(725,426), new Point( 915,330),
		                          new Point(1141,361), new Point( 175,517), new Point( 387,503), new Point(575,572), new Point( 745,570),
		                          new Point( 885,510), new Point(1025,450), new Point(1110,570) };

		boolean[]  tabTempBord = { true,  true,  true,  true,  true,
		                           true,  false, false, false, true,
		                           true,  false, false, false, false,
		                           true,  true,  true,  true,  true,
		                           true,  false, true                 };


		for (int cpt=0; cpt< tabTempTerr.length; cpt++ )
			alRet.add ( new Territoire ( cpt+1, tabTempTerr[cpt], tabTempBord[cpt], tabTempPoint[cpt]  ) );

		// Initialisations des liens entre Territoires
		int[][] tabTemp = { {   2,  6            },   // voisins du Territoire  1 dont le numéro est >
		                    {   3,  6,  7        },   // voisins du Territoire  2 dont le numéro est >
		                    {   4,  7,  8, 13    },   // voisins du Territoire  3 dont le numéro est >
		                    {   5,  8,  9        },   // voisins du Territoire  4 dont le numéro est >
		                    {   9, 10            },   // voisins du Territoire  5 dont le numéro est >
		                    {   7, 11            },   // voisins du Territoire  6 dont le numéro est >
		                    {  11, 12, 13        },   // voisins du Territoire  7 dont le numéro est >
		                    {   9, 13, 14, 15    },   // voisins du Territoire  8 dont le numéro est >
		                    {  10, 15            },   // voisins du Territoire  9 dont le numéro est >
		                    {  15, 16            },   // voisins du Territoire 10 dont le numéro est >
		                    {  12, 17            },   // voisins du Territoire 11 dont le numéro est >
		                    {  13, 14, 18, 19    },   // voisins du Territoire 12 dont le numéro est >
		                    {  14                },   // voisins du Territoire 13 dont le numéro est >
		                    {  15, 19, 20, 21    },   // voisins du Territoire 14 dont le numéro est >
		                    {  16, 21, 22        },   // voisins du Territoire 15 dont le numéro est >
		                    {  22, 23            },   // voisins du Territoire 16 dont le numéro est >
		                    {  18                },   // voisins du Territoire 17 dont le numéro est >
		                    {  19                },   // voisins du Territoire 18 dont le numéro est >
		                    {  20                },   // voisins du Territoire 19 dont le numéro est >
		                    {  21                },   // voisins du Territoire 20 dont le numéro est >
		                    {  22                },   // voisins du Territoire 21 dont le numéro est >
		                    {  23                } }; // voisins du Territoire 22 dont le numéro est >


			for (int lig=0; lig< tabTemp.length; lig++)
				for ( int col=0; col < tabTemp[lig].length ; col++ )
					alRet.get(lig).ajouterVoisins ( alRet.get( tabTemp[lig][col]-1 ) );

			return alRet;


	}

}