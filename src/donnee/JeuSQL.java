package donnee;

public interface JeuSQL {

	public static final String SQL_LISTER_JEUX_PAR_STUDIODEV = "SELECT * FROM jeu WHERE idstudio = ?";
	public static final String SQL_AJOUTER_JEU = "INSERT into jeu(annee, titre) VALUES(?,?)";
	public static final String SQL_MODIFIER_JEU = "UPDATE jeu SET annee = ?, titre = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_JEU = "SELECT * FROM jeu WHERE id = ?";
	
}
