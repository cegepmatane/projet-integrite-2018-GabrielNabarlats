package controleur;

import java.util.List;

import accesseur.StudioDevDAO;
import modele.StudioDev;
import modele.StudioDev;
import vue.NavigateurDesVues;
import vue.VueAjouterStudioDev;
import vue.VueListeStudioDev;
import vue.VueStudioDev;

public class ControleurStudioDev {
	
	private VueAjouterStudioDev vueAjouterStudioDev = null;
	private VueListeStudioDev vueListeStudioDev = null;
	private VueStudioDev vueStudioDev = null;
	StudioDevDAO StudioDevDAO = null;
	private NavigateurDesVues navigateur = null;
	
	private ControleurStudioDev() {
		System.out.println("Initialisation du controleur");	
		this.StudioDevDAO = new StudioDevDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur) {
		this.navigateur = navigateur;
		this.vueAjouterStudioDev = this.navigateur.getVueAjouterStudioDev();
		this.vueListeStudioDev = this.navigateur.getVueListeStudioDev();
		this.vueStudioDev = this.navigateur.getVueStudioDev();
		
		/// TEST ///
		/*StudioDev StudioDev = new StudioDev("Naughty Dog", "Santa Monica", "1984", "200+");
		this.vueStudioDev.afficherStudioDev(StudioDev); // Appel de ma fonction avant de la programmer (pour tester à mesure)*/
		
		this.navigateur.naviguerVersVueStudioDev();
		
		/// TEST ///
		List<StudioDev> listeStudioDevTest = StudioDevDAO.listeStudioDev();
		this.vueListeStudioDev.afficherListeStudioDev(listeStudioDevTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		this.navigateur.naviguerVersVueListeStudioDev();
		//this.navigateur.naviguerVersVueAjouterStudioDev();
	}
	
		// SINGLETON DEBUT
		private static ControleurStudioDev instance = null;
		public static ControleurStudioDev getInstance() {
			if(null == instance) instance = new ControleurStudioDev();
			return instance;
		}
		// SINGLETON FINI

		public void notifierEnregistrerStudioDev()
		{
			System.out.println("ControleurStudioDev.notifierEnregistrerStudioDev()");
			StudioDev StudioDev = this.navigateur.getVueAjouterStudioDev().demanderStudioDev();
			//this.StudioDevDAO.ajouterStudioDev(StudioDev);
			this.navigateur.naviguerVersVueListeStudioDev();
		}

}
