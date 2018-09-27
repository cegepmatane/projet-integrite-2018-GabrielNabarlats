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
import modele.StudioDev;

public class VueEditerStudioDev extends Scene {

	protected TextField valeurNom;
	protected TextField valeurSiegeSocial;
	protected TextField valeurAnneeCreation;
	protected TextField valeurEffectif;
	
	private ControleurStudioDev controleur = null;
	protected Button actionEnregistrerStudioDev = null;
	
	private int idStudioDev = 0;
	
	public VueEditerStudioDev() {
		super(new VBox(), 600, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleStudioDev = new GridPane();
		this.actionEnregistrerStudioDev = new Button("Enregistrer");
		
		this.actionEnregistrerStudioDev.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierEnregistrerStudioDev();	
			
			}});
		
		valeurNom = new TextField();
		grilleStudioDev.add(new Label("Nom : "), 0, 0);
		grilleStudioDev.add(valeurNom, 1, 0);
		
		valeurSiegeSocial = new TextField("");
		grilleStudioDev.add(new Label("Siege Social : "), 0, 1);
		grilleStudioDev.add(valeurSiegeSocial, 1, 1);
		
		valeurAnneeCreation = new TextField("");
		grilleStudioDev.add(new Label("Annee de cr�ation : "), 0, 2);
		grilleStudioDev.add(valeurAnneeCreation, 1, 2);
		
		valeurEffectif = new TextField("");
		grilleStudioDev.add(new Label("Effectif : "), 0, 3);
		grilleStudioDev.add(valeurEffectif, 1, 3);
		
		panneau.getChildren().add(new Label("Editer un studio de d�veloppement"));
		panneau.getChildren().add(grilleStudioDev);
		panneau.getChildren().add(this.actionEnregistrerStudioDev);
	}
	
	public StudioDev demanderStudioDev() {
		StudioDev studio = new StudioDev(this.valeurNom.getText(),
				this.valeurSiegeSocial.getText(),
				this.valeurAnneeCreation.getText(),
				this.valeurEffectif.getText());
		//studio.setID(idStudioDev);
		return studio;
	}
	
	public void setControleur(ControleurStudioDev controleur) {
		this.controleur = controleur;
	}
	
	public void afficherStudioDev(StudioDev studio) {
		this.idStudioDev = studio.getID();
		this.valeurNom.setText(studio.getNom());
		this.valeurSiegeSocial.setText(studio.getSiege_social());
		this.valeurAnneeCreation.setText(studio.getAnnee_creation());
		this.valeurEffectif.setText(studio.getEffectif());
	}
}