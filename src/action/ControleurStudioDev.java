package action;

import java.util.List;

import donnee.StudioDevDAO;
import modele.StudioDev;
import vue.NavigateurDesVues;
import vue.VueStudioDev;
import vue.VueAjouterStudioDev;
import vue.VueEditerStudioDev;
import vue.VueListeStudioDev;


public class ControleurStudioDev {
	
	private VueStudioDev vueStudioDev = null;
	private VueListeStudioDev vueListeStudioDev = null;
	private VueAjouterStudioDev vueAjouterStudioDev = null;
	private VueEditerStudioDev vueEditerStudioDev = null;
	
	private NavigateurDesVues navigateur = null;
	StudioDevDAO StudioDevDAO = null;
	
	private ControleurStudioDev() {
		System.out.println("Initialisation du controleur");	
		this.StudioDevDAO = new StudioDevDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur) {
		
		this.navigateur = navigateur;
		this.vueStudioDev = this.navigateur.getVueStudioDev();
		this.vueListeStudioDev = this.navigateur.getVueListeStudioDev();
		this.vueAjouterStudioDev = this.navigateur.getVueAjouterStudioDev();
		this.vueEditerStudioDev = this.navigateur.getVueEditerStudioDev();

		/// TEST ///
		StudioDev studiodev = new StudioDev("Naughty Dog", "Santa Monica", "1984", "200+");
		this.vueStudioDev.afficherStudioDev(studiodev); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		
		/// TEST Navigation ///
		this.navigateur.naviguerVersVueStudioDev();
		
		/// TEST ///
		List<StudioDev> listeStudioDevTest = StudioDevDAO.listerStudioDev();
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
			System.out.println("ControleurAnime.notifierEnregistrerNouvelAnime()");
			StudioDev studio = this.navigateur.getVueAjouterStudioDev().demanderStudioDev();
			this.StudioDevDAO.ajouterStudioDev(studio);
			this.vueListeStudioDev.afficherListeStudioDev(this.StudioDevDAO.listerStudioDev()); // TODO optimiser
			this.navigateur.naviguerVersVueListeStudioDev();
		}
		
		public void notifierEnregistrerStudioDev()
		{
			System.out.println("ControleurStudioDev.notifierEnregistrerStudioDev()");
			StudioDev studioDev = this.navigateur.getVueEditerStudioDev().demanderStudioDev();
			this.StudioDevDAO.modifierStudioDev(studioDev);
			this.vueListeStudioDev.afficherListeStudioDev(this.StudioDevDAO.listerStudioDev());
			this.navigateur.naviguerVersVueListeStudioDev();
		}
		
		public void notifierNaviguerAjouterStudioDev() {
			System.out.println("ControleurStudioDev.notifierNaviguerAjouterStudioDev()");
			this.navigateur.naviguerVersVueAjouterStudioDev();
		}
		
		public void notifierNaviguerEditerStudioDev(int idStudioDev) {
			System.out.println("ControleurStudioDev.notifierEditerStudioDev("+idStudioDev+")");
			this.vueEditerStudioDev.afficherStudioDev(this.StudioDevDAO.rapporterStudioDev(idStudioDev));
			this.navigateur.naviguerVersVueEditerStudioDev();
		}

}
