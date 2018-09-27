package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Jeu;
import modele.StudioDev;

public class JeuDAO implements JeuSQL {

	private Connection connection = null;
	
	public JeuDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();
	}
	
	public List<Jeu> listerJeuxParStudioDev(int idStudioDev)
	{
		System.out.println("JeuDAO.listerJeux()");
		List<Jeu> listeJeux =  new ArrayList<Jeu>();			
		PreparedStatement requeteListeJeux;
		
		try {
			requeteListeJeux = connection.prepareStatement(SQL_LISTER_JEUX_PAR_STUDIODEV);
			requeteListeJeux.setInt(1, idStudioDev);
			ResultSet curseurListeJeux = requeteListeJeux.executeQuery(); 
			while(curseurListeJeux.next())
			{
				int id = curseurListeJeux.getInt("id");
				int annee = curseurListeJeux.getInt("annee");
				String titre = curseurListeJeux.getString("titre");
				String detail = curseurListeJeux.getString("detail");				
				System.out.println("Jeu " + titre + " sorti en " + annee);
				
				Jeu Jeu = new Jeu(annee, titre);
				Jeu.setDetail(detail);
				Jeu.setId(id);
				listeJeux.add(Jeu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerJeux();
		return listeJeux;
	}	
	
	public List<Jeu> simulerListerJeux()
	{
		List<Jeu> listeJeux = new ArrayList<Jeu>();
		Jeu prix;
		prix = new Jeu(2015, "StudioDev le plus récompensé");
		listeJeux.add(prix);
		prix = new Jeu(2016, "StudioDev le plus joué");
		listeJeux.add(prix);
		prix = new Jeu(2017, "StudioDev le plus effrayant");
		listeJeux.add(prix);
		prix = new Jeu(2018, "StudioDev le plus beau graphiquement");
		listeJeux.add(prix);	
		
		return listeJeux;
	}
	
}
