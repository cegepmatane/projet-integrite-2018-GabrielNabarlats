package vue;
import controleur.ControleurStudioDev;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.StudioDev;

public class VueAjouterStudioDev extends Scene {

	protected TextField valeurNom;
	protected TextField valeurSiegeSocial;
	protected TextField valeurAnneeCreation;
	protected TextField valeurEffectif;
	
	private ControleurStudioDev controleur = null;
	protected Button actionEnregistrerStudioDev = null;
	
	public VueAjouterStudioDev()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleStudioDev = new GridPane();
		this.actionEnregistrerStudioDev = new Button("Enregistrer");
		
		this.actionEnregistrerStudioDev.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerNouveauStudioDev();
				
			}});

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new TextField();
		grilleStudioDev.add(new Label("Nom : "), 0, 0);
		grilleStudioDev.add(valeurNom, 1, 0);
		
		valeurSiegeSocial = new TextField("");
		grilleStudioDev.add(new Label("siegeSocial : "), 0, 1);
		grilleStudioDev.add(valeurSiegeSocial, 1, 1);

		valeurAnneeCreation = new TextField("");
		grilleStudioDev.add(new Label("anneeCreation : "), 0, 2);
		grilleStudioDev.add(valeurAnneeCreation, 1, 2);		

		valeurEffectif = new TextField("");
		grilleStudioDev.add(new Label("eEffectif : "), 0, 3);
		grilleStudioDev.add(valeurEffectif, 1, 3);				
			
		
		panneau.getChildren().add(new Label("Ajouter un studio de développement")); // Todo : créer un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleStudioDev);
		panneau.getChildren().add(actionEnregistrerStudioDev);
	}
	
	public StudioDev demanderStudioDev()
	{
		StudioDev StudioDev = new StudioDev(this.valeurNom.getText(), 
								this.valeurSiegeSocial.getText(), 
								this.valeurAnneeCreation.getText(), 
								this.valeurEffectif.getText());
		return StudioDev;
	}
	
	public void setControleur(ControleurStudioDev controleur) {
		this.controleur = controleur;
	}

}
