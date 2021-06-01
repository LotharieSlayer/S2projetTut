package smallworld;


/** Cette classe(enum) permet de gérer l'ensemble des messages et des textes de l'application en Fançais et en anglais.
  * Elle est accessible à la fois par
  *
  * @author Philippe Le Pivert
  */

import static smallworld.Controleur.LANGUE;

public enum Message
{
	OK                 ( "", "" ),

	ERR_POS_INVALID_B  ( "Vous ne pouvez poser qu'à partir du bord pour votre première conquête",
	                     "the first time, you must conquest by the edge"                         ),

	ERR_POS_INVALID_A  ( "Vous ne pouvez poser qu'à partir d'un de vos territoires",
	                     "You must conquest from one of your Regions"                            ),

	ERR_NB_JETON_0     ( "Il ne vous reste plus assez de jeton",
	                     "You've no such enough tokens"                                          ),

	ERR_ACTION_INVALID ( "Action indéfinie",
	                     "Invalid action"                                                        ),

	ERR_TERR_VIDE      ( "Ce Territoire est vide",
	                     "There's no Fantasy Race in this Region"          ),

	ERR_TERR_AUTRE     ( "Ce Territoire est occupé par votre adversaire",
	                     "This Region is occupied by your opponent"        ),

	LIB_AJOUTER        ( "Conquête",                  "Conquest"           ),
	LIB_ENLEVER        ( "Retraite",                  "Retreat"            ),
	LIB_TERRITOIRE     ( "Territoire",                "Region"             ),
	LIB_JETON_MAIN     ( "Jeton#/s# en main",         "Token#/s# in Hand"  ),   // #singulier/pluriel# pour subsitution
	LIB_JETON_PLATEAU  ( "Jeton#/s# sur le plateau",  "Token#/s# on Board" ),
	LIB_VALIDER        ( "@Valider",                  "@Confirm"           );   // @ devant la lettre racourci clavier (Alt+@)

	private String libFrancais, linAnglais;

	private Message ( String libFrancais , String linAnglais )
	{
		this.libFrancais = libFrancais;
		this.linAnglais  = linAnglais;
	}

	public String getLib()
	{
		String sRet;

		switch ( LANGUE )
		{
			case "FR"  : sRet = this.libFrancais;  break;
			case "ENG" : sRet = this.linAnglais;   break;
			default    : sRet = this.libFrancais;  break;
		}

		// on enlève l'éventuel caractère @ du racourci
		sRet = sRet.replaceAll ( "@", "" );

		return sRet;
	}


	public String getLib(boolean bPluriel)
	{
		String sRet;

		String sing, plur;
		int posDeb, posFin, posSlash;


		switch ( LANGUE )
		{
			case "FR"  : sRet = this.libFrancais;   break;
			case "ENG" : sRet = this.linAnglais;    break;
			default    : sRet = this.libFrancais;   break;
		}

		// on enlève l'éventuel caractère @ du racourci
		sRet = sRet.replaceAll ( "@", "" );


		// gestion du pluriel
		posDeb = sRet.indexOf ( '#');

		while ( posDeb!=-1 )
		{
			posSlash = sRet.indexOf ( '/', posDeb+1 );
			posFin   = sRet.indexOf ( '#', posDeb+1 );

			sing = sRet.substring ( posDeb+1, posSlash );
			plur = sRet.substring ( posSlash+1, posFin );

			if ( bPluriel ) sRet = sRet.substring ( 0, posDeb ) + plur + sRet.substring ( posFin+1 );
			else            sRet = sRet.substring ( 0, posDeb ) + sing + sRet.substring ( posFin+1 );

			posDeb = sRet.indexOf ( '#' );
		}

		return sRet;
	}


	public char getMnemonic	()
	{
		String sRet;
		int    pos;

		switch ( LANGUE )
		{
			case "FR"  : sRet = this.libFrancais;  break;
			case "ENG" : sRet = this.linAnglais;   break;
			default    : sRet = this.libFrancais;  break;
		}

		pos = sRet.indexOf ( '@' );

		if ( pos == - 1 ) return ' ';

		return sRet.charAt ( pos+1 );
	}
}
