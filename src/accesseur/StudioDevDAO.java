package accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.StudioDev;

public class StudioDevDAO {
	
	public List<StudioDev> simulerListeStudioDev(){
		List listeStudioDevTest = new ArrayList<StudioDev>();
		listeStudioDevTest.add(new StudioDev("Naughty Dog", "Santa Monica", "1984", "200"));
		listeStudioDevTest.add(new StudioDev("CD Projekt Red", "Varsovie", "1994", "600"));
		listeStudioDevTest.add(new StudioDev("Vicarious Visions", "Menands", "1990", "200"));
		return listeStudioDevTest;
	}
	
	private static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/studiodev";
	private static String BASEDEDONNEES_USAGER = "postgres";
	private static String BASEDEDONNEES_MOTDEPASSE = "1134";
	
	private Connection connection = null;
	
	public StudioDevDAO() {
		
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
		
	public List<StudioDev> listerStudioDev(){
		
		List<StudioDev> listeStudioDev =  new ArrayList<StudioDev>();
		Statement requeteListeStudioDev;
		try {
			requeteListeStudioDev = connection.createStatement();
			ResultSet curseurListeStudioDev = requeteListeStudioDev.executeQuery("SELECT * FROM studiodev");
			
			while(curseurListeStudioDev.next()) {
				int id = curseurListeStudioDev.getInt("id");
				String nom = curseurListeStudioDev.getString("nom");
				String siegeSocial = curseurListeStudioDev.getString("siegesocial");
				String anneeCreation = curseurListeStudioDev.getString("anneecreation");
				String effectif = curseurListeStudioDev.getString("effectif");
				
				System.out.println("Studio " + nom + " basé à " + siegeSocial + ", fondé en " + anneeCreation + " et ayant " + effectif + " employés.");
				StudioDev studio = new StudioDev(nom, siegeSocial, anneeCreation, effectif);
				listeStudioDev.add(studio);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		//return this.simulerListeStudioDev();
		return listeStudioDev;
	}
	
	public void ajouterStudioDev(StudioDev studioDev) {
		
		try {
			Statement requeteAjouterStudioDev = connection.createStatement();
			
			/*
			 * ALTER TABLE my_table DROP COLUMN id; ALTER TABLE my_table ADD COLUMN id SERIAL PRIMARY KEY;
			 */
			
			String sqlAjouterStudioDev = "INSERT INTO studiodev(nom, siegesocial, anneecreation, effectif) VALUES('"+studioDev.getNom()+"','"+studioDev.getSiege_social()+"','"+studioDev.getAnnee_creation()+"','"+studioDev.getEffectif()+"')";
			System.out.println("SQL : " + sqlAjouterStudioDev);
			requeteAjouterStudioDev.execute(sqlAjouterStudioDev);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierStudioDev(StudioDev studioDev) {
		System.out.println("StudioDevDAO.modifierStudioDev()");
		try {
			Statement requeteModifierStudioDev = connection.createStatement();
			
			String SQL_MODIFIER_STUDIODEV = "UPDATE studiodev SET nom = '"+studioDev.getNom()+"', siegesocial = '"+studioDev.getSiege_social()+"', anneecreation = '"+studioDev.getAnnee_creation()+"', effectif = '"+studioDev.getEffectif()+"' WHERE id = " + studioDev.getID();
			System.out.println("SQL : " + SQL_MODIFIER_STUDIODEV);
			requeteModifierStudioDev.execute(SQL_MODIFIER_STUDIODEV);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public StudioDev rapporterStudioDev(int idStudioDev) {
		Statement requeteStudioDev;
		try {
			requeteStudioDev = connection.createStatement();
			
			String SQL_RAPPORTER_STUDIODEV = "SELECT * FROM studiodev WHERE id = " + idStudioDev;
			System.out.println(SQL_RAPPORTER_STUDIODEV);
			ResultSet curseurStudioDev = requeteStudioDev.executeQuery(SQL_RAPPORTER_STUDIODEV);
			curseurStudioDev.next();
			int id = curseurStudioDev.getInt("id");
			String nom = curseurStudioDev.getString("nom");
			String siegeSocial = curseurStudioDev.getString("siegesocial");
			String anneeCreation = curseurStudioDev.getString("anneecreation");
			String effectif = curseurStudioDev.getString("effectif");
			System.out.println("Le studio de développement " + nom + " est basé à " + siegeSocial + " depuis " + anneeCreation + " et compte " + effectif + " employés.");
			StudioDev studioDev = new StudioDev(nom, siegeSocial, anneeCreation, effectif);
			studioDev.setID(id);
			return studioDev;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
