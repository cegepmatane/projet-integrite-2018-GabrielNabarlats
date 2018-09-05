package vue;
import javafx.application.Application;
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
	
	public VueAjouterStudioDev()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleStudioDev = new GridPane();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new TextField();
		grilleStudioDev.add(new Label("Nom : "), 0, 0);
		grilleStudioDev.add(valeurNom, 1, 0);
		
		valeurSiegeSocial = new TextField("");
		grilleStudioDev.add(new Label("SiegeSocial : "), 0, 1);
		grilleStudioDev.add(valeurSiegeSocial, 1, 1);

		valeurAnneeCreation = new TextField("");
		grilleStudioDev.add(new Label("AnneeCreation : "), 0, 2);
		grilleStudioDev.add(valeurAnneeCreation, 1, 2);		

		valeurEffectif = new TextField("");
		grilleStudioDev.add(new Label("Effectif : "), 0, 3);
		grilleStudioDev.add(valeurEffectif, 1, 3);				
			
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Ajouter un studio de développement")); // Todo : créer un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleStudioDev);
		panneau.getChildren().add(new Button("Enregistrer"));
	}
	
	public StudioDev demanderStudioDev()
	{
		StudioDev StudioDev = new StudioDev(this.valeurNom.getText(), 
								this.valeurSiegeSocial.getText(), 
								this.valeurAnneeCreation.getText(), 
								this.valeurEffectif.getText());
		return StudioDev;
	}

}
