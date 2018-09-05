package vue;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.StudioDev;

public class VueListeStudioDev extends Scene {

	protected GridPane grilleStudioDevs;
	
	public VueListeStudioDev() {
		super(new GridPane(), 400,400);
		Pane panneau = (Pane) this.getRoot();
		grilleStudioDevs = new GridPane();
		
		panneau.getChildren().add(grilleStudioDevs);		
	}
	
	public void afficherListeStudioDev(List<StudioDev> listeStudioDevs)
	{
		int numero = 0;
		this.grilleStudioDevs.add(new Label("Nom"), 0, numero);
		this.grilleStudioDevs.add(new Label("SiegeSocial"), 1, numero);			
		for(StudioDev StudioDev : listeStudioDevs)
		{
			numero++;
			this.grilleStudioDevs.add(new Label(StudioDev.getNom()), 0, numero);
			this.grilleStudioDevs.add(new Label(StudioDev.getSiege_social()), 1, numero);			
		}
	}

}
