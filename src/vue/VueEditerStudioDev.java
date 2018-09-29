package vue;
import java.util.List;

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
import modele.StudioDev;

public class VueEditerStudioDev extends Scene {

	protected TextField valeurNom;
	protected TextField valeurSiegeSocial;
	protected TextField valeurAnneeCreation;
	protected TextField valeurEffectif;
	
	private ControleurStudioDev controleur = null;
	protected Button actionEnregistrerStudioDev = null;
	protected GridPane grilleListeJeux = new GridPane();
	protected Button actionAjouterJeu = null;
	protected Button actionSupprimerJeu = null;
	
	private int idStudioDev = 0;
	
	public VueEditerStudioDev() {
		super(new VBox(), 600, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleStudioDev = new GridPane();
		this.actionAjouterJeu = new Button("Ajouter un jeu");
		
		this.actionAjouterJeu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierEnregistrerNouveauJeu();
			
			}});
		
		this.actionEnregistrerStudioDev = new Button("Enregistrer");
				
		this.actionEnregistrerStudioDev.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerStudioDev();
				
			}});
				
		this.actionSupprimerJeu = new Button("Supprimer");
		this.actionSupprimerJeu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierSupprimerStudioDev();
			}
		});
		
		valeurNom = new TextField();
		grilleStudioDev.add(new Label("Nom : "), 0, 0);
		grilleStudioDev.add(valeurNom, 1, 0);
		
		valeurSiegeSocial = new TextField("");
		grilleStudioDev.add(new Label("Siege Social : "), 0, 1);
		grilleStudioDev.add(valeurSiegeSocial, 1, 1);
		
		valeurAnneeCreation = new TextField("");
		grilleStudioDev.add(new Label("Annee de création : "), 0, 2);
		grilleStudioDev.add(valeurAnneeCreation, 1, 2);
		
		valeurEffectif = new TextField("");
		grilleStudioDev.add(new Label("Effectif : "), 0, 3);
		grilleStudioDev.add(valeurEffectif, 1, 3);
		
		panneau.getChildren().add(new Label("Editer un studio de développement"));
		panneau.getChildren().add(grilleStudioDev);
		panneau.getChildren().add(this.actionEnregistrerStudioDev);
		panneau.getChildren().add(grilleListeJeux);
		panneau.getChildren().add(actionSupprimerJeu);
		panneau.getChildren().add(this.actionAjouterJeu);
	}
	
	public StudioDev demanderStudioDev() {
		StudioDev studio = new StudioDev(this.valeurNom.getText(),
				this.valeurSiegeSocial.getText(),
				this.valeurAnneeCreation.getText(),
				this.valeurEffectif.getText());
		studio.setID(idStudioDev);
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
	
	public void afficherListeJeux(List<Jeu> listeJeux)
	{
		int item = 0;
		for(Jeu jeu : listeJeux)
		{
			this.grilleListeJeux.add(new Label(jeu.getAnnee() + ""), 0, item);
			this.grilleListeJeux.add(new Label(jeu.getTitre()), 1, item);
			this.grilleListeJeux.add(new Button("Éditer"), 2, item);
			this.grilleListeJeux.add(new Button("Effacer"), 3, item);
			item++;
		}		
	}
}
