package smallworld.metier;

import static smallworld.Controleur.LANGUE;

public enum Nature implements java.io.Serializable
{
	MER        ("Mer",      "Sea"     ),
	CHAMP      ("Champ",    "Field"   ),
	FORET      ("Forêt",    "Forest"  ),
	MARAIS     ("Marais",   "Swamp"   ),
	MONTAGNE   ("Montagne", "Montain" ),
	PRAIRIE    ("Prairie",  "Meadow"  );

	private String libFrancais;
	private String libAnglais;

	private Nature ( String libFrancais, String libAnglais )
	{
		this.libFrancais = libFrancais;
		this.libAnglais  = libAnglais;
	}

	public String getLib()
	{
		switch ( LANGUE )
		{
			case "FR"  : return this.libFrancais;
			case "ENG" : return this.libAnglais;
			default    : return this.libFrancais;
		}
	}


}
