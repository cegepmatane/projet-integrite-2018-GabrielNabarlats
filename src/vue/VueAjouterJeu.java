package vue;

import action.ControleurStudioDev;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Jeu;

public class VueAjouterJeu extends Scene{

	protected TextField valeurAnnee;
	protected TextField valeurTitre;
	
	private ControleurStudioDev controleur = null;
	protected Button actionEnregistrerJeu = null;
	
	public VueAjouterJeu()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleJeu = new GridPane();
		this.actionEnregistrerJeu = new Button("Enregistrer");
		
		this.actionEnregistrerJeu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerNouveauJeu();
				
			}});

		valeurTitre = new TextField();
		grilleJeu.add(new Label("Nom : "), 0, 0);
		grilleJeu.add(valeurTitre, 1, 0);
		
		valeurAnnee = new TextField("");
		grilleJeu.add(new Label("Siege social : "), 0, 1);
		grilleJeu.add(valeurAnnee, 1, 1);			
			
		panneau.getChildren().add(new Label("Ajouter un jeu"));
		panneau.getChildren().add(grilleJeu);
		panneau.getChildren().add(this.actionEnregistrerJeu);
	}
	
	public Jeu demanderJeu()
	{
		Jeu jeu = new Jeu(Integer.parseInt(this.valeurAnnee.getText()), 
								this.valeurTitre.getText());
		return jeu;
	}
	
	public void setControleur(ControleurStudioDev controleur) {
		this.controleur = controleur;
	}
}
