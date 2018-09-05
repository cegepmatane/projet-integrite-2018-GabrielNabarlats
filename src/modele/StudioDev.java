package modele;

public class StudioDev {

	public String nom;
	public String siege_social;
	public String annee_creation;
	public int effectif;
	
	public StudioDev(String nom) {
		super();
		this.nom = nom;
	}
	
	public StudioDev(String nom, String siege_social) {
		super();
		this.nom = nom;
		this.siege_social = siege_social;
	}
	
	public StudioDev(String nom, String siege_social, String annee_creation) {
		super();
		this.nom = nom;
		this.siege_social = siege_social;
		this.annee_creation = annee_creation;
	}
	
	public StudioDev(String nom, String siege_social, String annee_creation, int effectif) {
		super();
		this.nom = nom;
		this.siege_social = siege_social;
		this.annee_creation = annee_creation;
		this.effectif = effectif;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSiege_social() {
		return siege_social;
	}
	public void setSiege_social(String siege_social) {
		this.siege_social = siege_social;
	}
	public String getAnnee_creation() {
		return annee_creation;
	}
	public void setAnnee_creation(String annee_creation) {
		this.annee_creation = annee_creation;
	}
	public int getEffectif() {
		return effectif;
	}
	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}
	
	
	
	
}
