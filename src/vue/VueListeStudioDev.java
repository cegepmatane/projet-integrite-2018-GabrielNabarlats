package vue;
import java.util.ArrayList;
import java.util.List;

import controleur.ControleurStudioDev;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.StudioDev;

public class VueListeStudioDev extends Scene {

	protected GridPane grilleStudioDevs;
	public ControleurStudioDev controleur = null;
	private Button actionNaviguerAjouterStudioDev;
	
	public VueListeStudioDev() {
		super(new GridPane(), 800,400);
		grilleStudioDevs = (GridPane) this.getRoot();
		this.actionNaviguerAjouterStudioDev = new Button("Ajouter un studio de développement");
			
	}
	
	public void afficherListeStudioDev(List<StudioDev> listeStudioDevs)
	{
		this.grilleStudioDevs.getChildren().clear();
		
		int numero = 0;
		this.grilleStudioDevs.add(new Label("Nom"), 0, numero);
		this.grilleStudioDevs.add(new Label("Siege Social"), 1, numero);
		this.grilleStudioDevs.add(new Label("Annee Creation"), 2,  numero);
		this.grilleStudioDevs.add(new Label("Effectif"), 3,  numero);
		for(StudioDev studioDev : listeStudioDevs)
		{
			Button actionEditerStudioDev = new Button("Editer");
			actionEditerStudioDev.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					controleur.notifierNaviguerEditerStudioDev(studioDev.getID());		
				}
			});
			
			numero++;
			this.grilleStudioDevs.add(new Label(studioDev.getNom()), 0, numero);
			this.grilleStudioDevs.add(new Label(studioDev.getSiege_social()), 1, numero);
			this.grilleStudioDevs.add(new Label(studioDev.getAnnee_creation()), 2, numero);
			this.grilleStudioDevs.add(new Label(studioDev.getEffectif()), 3, numero);
			this.grilleStudioDevs.add(actionEditerStudioDev, 4, numero);
		}
		
		this.actionNaviguerAjouterStudioDev.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierNaviguerAjouterStudioDev();
			}
		});
		
		this.grilleStudioDevs.add(this.actionNaviguerAjouterStudioDev, 1, ++numero);
	}
	
	public void setControleur(ControleurStudioDev controleur) {
		this.controleur = controleur;
	}

}
