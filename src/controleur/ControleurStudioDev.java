package controleur;

import modele.StudioDev;
import vue.NavigateurDesVues;
import vue.VueAjouterStudioDev;
import vue.VueListeStudioDev;
import vue.VueStudioDev;

public class ControleurStudioDev {
	
	private VueAjouterStudioDev vueAjouterStudioDev = null;
	private VueListeStudioDev vueListeStudioDev = null;
	private VueStudioDev vueStudioDev = null;

	private NavigateurDesVues navigateur = null;
	
	private ControleurStudioDev() {
		
	}
	
	private static ControleurStudioDev instance = null;
	public static ControleurStudioDev getInstance() {
		if(null == instance) {
			instance = new ControleurStudioDev();
		}
		return instance;
	}
	
	public void activerVues(NavigateurDesVues navigateur) {
		this.navigateur = navigateur;
		this.vueAjouterStudioDev = this.navigateur.getVueAjouterStudioDev();
		this.vueListeStudioDev = this.navigateur.getVueListeStudioDev();
		this.vueStudioDev = this.navigateur.getVueStudioDev();
		
		/// TEST ///
		/*StudioDev StudioDev = new StudioDev("Naughty Dog", "Santa Monica", "1984", "200+");
		this.vueStudioDev.afficherStudioDev(StudioDev); // Appel de ma fonction avant de la programmer (pour tester à mesure)*/
		
		//this.navigateur.naviguerVersVueStudioDev();
		this.navigateur.naviguerVersVueListeStudioDev();
		//this.navigateur.naviguerVersVueAjouterStudioDev();
	}

}
