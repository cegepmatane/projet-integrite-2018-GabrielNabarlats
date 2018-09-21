package vue;

import controleur.ControleurStudioDev;
import javafx.application.Application;
import javafx.stage.Stage;


public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueAjouterStudioDev vueAjouterStudioDev = null;
	private VueListeStudioDev vueListeStudioDev = null;
	private VueStudioDev vueStudioDev = null;
	public VueEditerStudioDev vueEditerStudioDev = null;
	
	private ControleurStudioDev controleur = null;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterStudioDev = new VueAjouterStudioDev();
		this.vueListeStudioDev = new VueListeStudioDev();
		this.vueStudioDev = new VueStudioDev();
		this.vueEditerStudioDev = new VueEditerStudioDev();
			
	}
	
	
	@Override
	public void start(Stage stade) throws Exception {
		
		this.stade = stade;
		
		stade.setScene(null);
		stade.show();
		
		this.controleur = ControleurStudioDev.getInstance();
		this.controleur.activerVues(this);
		this.vueAjouterStudioDev.setControleur(controleur);
		this.vueListeStudioDev.setControleur(controleur);
		this.vueStudioDev.setControleur(controleur);
		this.vueEditerStudioDev.setControleur(controleur);
		
	}

	public VueAjouterStudioDev getVueAjouterStudioDev() {
		return vueAjouterStudioDev;
	}

	public void setVueAjouterStudioDev(VueAjouterStudioDev vueAjouterStudioDev) {
		this.vueAjouterStudioDev = vueAjouterStudioDev;
	}

	public VueListeStudioDev getVueListeStudioDev() {
		return vueListeStudioDev;
	}

	public void setVueListeStudioDev(VueListeStudioDev vueListeStudioDev) {
		this.vueListeStudioDev = vueListeStudioDev;
	}

	public VueStudioDev getVueStudioDev() {
		return vueStudioDev;
	}

	public void setVueStudioDev(VueStudioDev vueStudioDev) {
		this.vueStudioDev = vueStudioDev;
	}
	
	public void naviguerVersVueStudioDev() {
		stade.setScene(this.vueStudioDev);
		stade.show();
	}
	
	public void naviguerVersVueListeStudioDev() {
		stade.setScene(this.vueListeStudioDev);
		stade.show();
	}
	
	public void naviguerVersVueAjouterStudioDev() {
		stade.setScene(this.vueAjouterStudioDev);
		stade.show();
	}
	
	public void naviguerVersVueEditerStudioDev() {
		stade.setScene(this.vueEditerStudioDev);
		stade.show();
	}
	
	public VueEditerStudioDev getVueEditerStudioDev() {
		return vueEditerStudioDev;
	}

}


