package accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.StudioDev;
import modele.StudioDev;

public class StudioDevDAO {
	
	public List<StudioDev> simulerListeStudioDev(){
		List listeStudioDevTest = new ArrayList<StudioDev>();
		listeStudioDevTest.add(new StudioDev("Naughty Dog", "Santa Monica", "1984", "200"));
		listeStudioDevTest.add(new StudioDev("CD Projekt Red", "Varsovie", "1994", "600"));
		listeStudioDevTest.add(new StudioDev("Vicarious Visions", "Menands", "1990", "200"));
		return listeStudioDevTest;
	}
	public List<StudioDev>listeStudioDev(){
		
		String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
		String BASEDEDONNEES_URL = "jdbc:postgresql://localhost.5432/studiodev";
		String BASEDEDONNEES_USAGER = "postgres";
		String BASEDEDONNEES_MOTDEPASSE = "1134";
		
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<StudioDev> listeStudioDev =  new ArrayList<StudioDev>();
		try {
			Connection connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
			
			Statement requeteListeStudioDev = connection.createStatement();
			ResultSet curseurListeStudioDev = requeteListeStudioDev.executeQuery("SELECT * FROM studio");
			
			curseurListeStudioDev.next();
			String nom = curseurListeStudioDev.getString("nom");
			String siegeSocial = curseurListeStudioDev.getString("siegeSocial");
			String anneeCreation = curseurListeStudioDev.getString("anneeCreation");
			String effectif = curseurListeStudioDev.getString("effectif");
			
			System.out.println("Studio " + nom + " basé à " + siegeSocial + ", fondé en " + anneeCreation + " et ayant " + effectif + " employés.");
			StudioDev studio = new StudioDev(nom, siegeSocial, anneeCreation, effectif);
			listeStudioDev.add(studio);
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return this.simulerListeStudioDev();
	}
	
}
