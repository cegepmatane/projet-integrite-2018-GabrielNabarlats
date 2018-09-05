package vue;
import java.util.ArrayList;
import java.util.List;

import controleur.ControleurStudioDev;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.StudioDev;

public class NavigateurDesVues extends Application{
	
	private VueAjouterStudioDev vueAjouterStudioDev;
	private VueListeStudioDev vueListeStudioDev;
	private VueStudioDev vueStudioDev;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterStudioDev = new VueAjouterStudioDev();
		this.vueListeStudioDev = new VueListeStudioDev();
		this.vueStudioDev = new VueStudioDev();
			
	}
	
	private Stage stade = null;
	
	@Override
	public void start(Stage stade) throws Exception {
		
		this.stade = stade;
		stade.setScene(this.vueStudioDev);
		stade.show();
		
		//ControleurStudioDev controleur = new ControleurStudioDev(this);
		ControleurStudioDev controleur = ControleurStudioDev.getInstance();
		controleur.activerVues(this);
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

	@Override
	public void start(Stage arg0) throws Exception {
		stade.setScene(this.vueAjouterStudioDev);
		stade.show();
	}
}


