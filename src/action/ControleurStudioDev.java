package action;

import java.util.List;

import donnee.JeuDAO;
import donnee.StudioDevDAO;
import modele.Jeu;
import modele.StudioDev;
import vue.NavigateurDesVues;
import vue.VueStudioDev;
import vue.VueAjouterStudioDev;
import vue.VueEditerStudioDev;
import vue.VueListeStudioDev;
import vue.VueListeJeu;


public class ControleurStudioDev {
	
	private NavigateurDesVues navigateur;
	
	private VueListeStudioDev vueListeStudioDev = null;
	private VueStudioDev vueStudioDev = null;
	private VueAjouterStudioDev vueAjouterStudioDev = null;
	private VueEditerStudioDev vueEditerStudioDev = null;
	
	private VueListeJeu vueListeJeu = null;
	
	private StudioDevDAO studioDevDAO = null;
	private JeuDAO jeuDAO = null;
	
	private ControleurStudioDev() {
		System.out.println("Initialisation du controleur");	
		this.studioDevDAO = new StudioDevDAO();
		jeuDAO = new JeuDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur) {
		
		this.navigateur = navigateur;
		this.vueStudioDev = this.navigateur.getVueStudioDev();
		this.vueListeStudioDev = this.navigateur.getVueListeStudioDev();
		this.vueAjouterStudioDev = this.navigateur.getVueAjouterStudioDev();
		this.vueEditerStudioDev = this.navigateur.getVueEditerStudioDev();
		
		this.vueListeJeu = this.navigateur.getVueListeJeu();

		/// TEST ///
		StudioDev studiodev = new StudioDev("Naughty Dog", "Santa Monica", "1984", "200+");
		this.vueStudioDev.afficherStudioDev(studiodev); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		
		/// TEST Navigation ///
		this.navigateur.naviguerVersVueStudioDev();
		
		/// TEST ///
		List<StudioDev> listeStudioDevTest = studioDevDAO.listerStudioDev();
		this.vueListeStudioDev.afficherListeStudioDev(listeStudioDevTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		this.navigateur.naviguerVersVueListeStudioDev();

	}
	
		// SINGLETON DEBUT
		private static ControleurStudioDev instance = null;
		public static ControleurStudioDev getInstance() {
			if(null == instance) instance = new ControleurStudioDev();
			return instance;
		}
		
		// SINGLETON FINI
		public void notifierEnregistrerNouveauStudioDev()
		{
			System.out.println("ControleurStudioDev.notifierEnregistrerNouveauStudioDev()");
			StudioDev studio = this.navigateur.getVueAjouterStudioDev().demanderStudioDev();
			this.studioDevDAO.ajouterStudioDev(studio);
			this.vueListeStudioDev.afficherListeStudioDev(this.studioDevDAO.listerStudioDev()); // TODO optimiser
			this.navigateur.naviguerVersVueListeStudioDev();
		}
		
		public void notifierEnregistrerStudioDev()
		{
			System.out.println("ControleurStudioDev.notifierEnregistrerStudioDev()");
			StudioDev studio = this.navigateur.getVueEditerStudioDev().demanderStudioDev();
			this.studioDevDAO.modifierStudioDev(studio);
			this.vueListeStudioDev.afficherListeStudioDev(this.studioDevDAO.listerStudioDev());
			this.navigateur.naviguerVersVueListeStudioDev();
		}
		
		public void notifierSupprimerStudioDev() {
			System.out.println("ControleurStudioDev.notifierSupprimerStudioDev()");
			StudioDev studio = this.navigateur.getVueEditerStudioDev().demanderStudioDev();
			this.studioDevDAO.supprimerStudioDev(studio);
			this.vueListeStudioDev.afficherListeStudioDev(this.studioDevDAO.listerStudioDev());
			this.navigateur.naviguerVersVueListeStudioDev();
		}
		
		public void notifierNaviguerAjouterStudioDev() {
			System.out.println("ControleurStudioDev.notifierNaviguerAjouterStudioDev()");
			this.navigateur.naviguerVersVueAjouterStudioDev();
		}
		
		public void notifierNaviguerEditerStudioDev(int idStudioDev) {
			System.out.println("ControleurStudioDev.notifierEditerStudioDev("+idStudioDev+")");
			this.vueEditerStudioDev.afficherStudioDev(this.studioDevDAO.rapporterStudioDev(idStudioDev));
			this.vueEditerStudioDev.afficherListeJeux(this.jeuDAO.listerJeuxParStudioDev(idStudioDev));
			this.navigateur.naviguerVersVueEditerStudioDev();
		}
		
		public void notifierEnregistrerNouveauJeu(int idstudio) {
			System.out.println("ControleurStudioDev.notifierEnregistrerNouveauJeu()");
			Jeu jeu = this.navigateur.getVueAjouterJeu().demanderJeu();
			this.jeuDAO.ajouterJeu(jeu);
			this.vueListeJeu.afficherListeJeux(this.jeuDAO.listerJeuxParStudioDev(idstudio));
			this.navigateur.naviguerVersVueListeJeux();
		}

}
