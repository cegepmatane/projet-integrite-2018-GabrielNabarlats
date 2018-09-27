package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.StudioDev;

public class StudioDevDAO implements StudioDevSQL {
	
	private Connection connexion = null;
	
	public StudioDevDAO() {
		this.connexion = BaseDeDonnees.getInstance().getConnection();
	}
	
	public List<StudioDev> simulerListeStudioDev(){
		List listeStudioDevTest = new ArrayList<StudioDev>();
		listeStudioDevTest.add(new StudioDev("Naughty Dog", "Santa Monica", "1984", "200"));
		listeStudioDevTest.add(new StudioDev("CD Projekt Red", "Varsovie", "1994", "600"));
		listeStudioDevTest.add(new StudioDev("Vicarious Visions", "Menands", "1990", "200"));
		return listeStudioDevTest;
	}
		
	public List<StudioDev> listerStudioDev(){
		
		List<StudioDev> listeStudioDev =  new ArrayList<StudioDev>();
		Statement requeteListeStudioDev;
		try {
			requeteListeStudioDev = connexion.createStatement();
			ResultSet curseurListeStudioDev = requeteListeStudioDev.executeQuery(SQL_LISTER_STUDIODEVS);
			
			while(curseurListeStudioDev.next()) {
				
				int id = curseurListeStudioDev.getInt("id");
				String nom = curseurListeStudioDev.getString("nom");
				String siegeSocial = curseurListeStudioDev.getString("siegesocial");
				String anneeCreation = curseurListeStudioDev.getString("anneecreation");
				String effectif = curseurListeStudioDev.getString("effectif");
				System.out.println("Studio " + nom + " basé à " + siegeSocial + ", fondé en " + anneeCreation + " et ayant " + effectif + " employés.");
				StudioDev studio = new StudioDev(nom, siegeSocial, anneeCreation, effectif);
				studio.setID(id);
				listeStudioDev.add(studio);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		//return this.simulerListeStudioDev();
		return listeStudioDev;
	}
	
	public void ajouterStudioDev(StudioDev studioDev) {
		
		System.out.println("StudioDevDAO.ajouterStudioDev()");
		try {
			PreparedStatement requeteAjouterStudioDev = connexion.prepareStatement(SQL_AJOUTER_STUDIODEV);
			requeteAjouterStudioDev.setString(1, studioDev.getNom());
			requeteAjouterStudioDev.setString(2, studioDev.getSiege_social());
			requeteAjouterStudioDev.setString(3, studioDev.getAnnee_creation());
			requeteAjouterStudioDev.setString(4, studioDev.getEffectif());
			
			System.out.println("SQL : " + SQL_AJOUTER_STUDIODEV);
			requeteAjouterStudioDev.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierStudioDev(StudioDev studioDev) {
		System.out.println("StudioDevDAO.modifierStudioDev()");
		try {
			PreparedStatement requeteModifierStudioDev = connexion.prepareStatement(SQL_MODIFIER_STUDIODEV);
			requeteModifierStudioDev.setString(1, studioDev.getNom());
			requeteModifierStudioDev.setString(2, studioDev.getSiege_social());
			requeteModifierStudioDev.setString(3, studioDev.getAnnee_creation());
			requeteModifierStudioDev.setString(4, studioDev.getEffectif());
			requeteModifierStudioDev.setInt(5, studioDev.getID());
			
			System.out.println("SQL : " + SQL_MODIFIER_STUDIODEV);
			requeteModifierStudioDev.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public StudioDev rapporterStudioDev(int idStudioDev) {
		PreparedStatement requeteStudioDev;
		try {
			requeteStudioDev = connexion.prepareStatement(SQL_RAPPORTER_STUDIODEV);
			requeteStudioDev.setInt(1, idStudioDev);
			System.out.println(SQL_RAPPORTER_STUDIODEV);
			ResultSet curseurStudioDev = requeteStudioDev.executeQuery();
			curseurStudioDev.next();
			int id = curseurStudioDev.getInt("id");
			String nom = curseurStudioDev.getString("nom");
			String siegesocial = curseurStudioDev.getString("siegesocial");
			String anneecreation = curseurStudioDev.getString("anneecreation");
			String effectif = curseurStudioDev.getString("effectif");
			System.out.println("Studio de développement " + nom + " basé à " + siegesocial + ", créé en " + anneecreation + " et comptant " + effectif + " employés.");
			StudioDev StudioDev = new StudioDev(nom, siegesocial, anneecreation, effectif);
			StudioDev.setID(id);
			return StudioDev;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
