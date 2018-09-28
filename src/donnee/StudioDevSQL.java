package donnee;

public interface StudioDevSQL {
	
	public static final String SQL_LISTER_STUDIODEVS = "SELECT * FROM studiodev";
	public static final String SQL_AJOUTER_STUDIODEV = "INSERT into studiodev(nom, siegesocial, anneecreation, effectif) VALUES(?,?,?,?)";
	public static final String SQL_MODIFIER_STUDIODEV = "UPDATE studiodev SET nom = ?, siegesocial = ?, anneecreation = ?, effectif = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_STUDIODEV = "SELECT * FROM studiodev WHERE id = ?";
	public static final String SQL_SUPPRIMER_STUDIODEV = "DELETE FROM studiodev WHERE id = ?";

}
