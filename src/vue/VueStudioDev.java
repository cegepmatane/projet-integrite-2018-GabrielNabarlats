package vue;

import modele.StudioDev;

public class VueStudioDev extends Scene{

	protected Label valeurNom;
	protected Label valeurSiegeSocial;
	protected Label valeurDateCreation;
	protected Label valeurEffectif;
	
	public VueStudioDev() {
		super(new Pane(),400,400);
		Pane panneau = (Pane) this.getRoot();	
		GridPane grilleStudioDev = new GridPane();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new Label("");
		grilleStudioDev.add(new Label("Nom : "), 0, 0);
		grilleStudioDev.add(valeurNom, 1, 0);
		
		valeurSiegeSocial = new Label("");
		grilleStudioDev.add(new Label("SiegeSocial : "), 0, 1);
		grilleStudioDev.add(valeurSiegeSocial, 1, 1);

		valeurDateCreation = new Label("");
		grilleStudioDev.add(new Label("DateCreation : "), 0, 2);
		grilleStudioDev.add(valeurDateCreation, 1, 2);		

		valeurEffectif = new Label("");
		grilleStudioDev.add(new Label("Effectif : "), 0, 3);
		grilleStudioDev.add(valeurEffectif, 1, 3);				
			
		panneau.getChildren().add(grilleStudioDev);		
	}
	
	public void afficherStudioDev(StudioDev StudioDev)
	{
		this.valeurNom.setText(StudioDev.getNom());
		this.valeurSiegeSocial.setText(StudioDev.getSiege_social());
		this.valeurDateCreation.setText(StudioDev.get);
		this.valeurEffectif.setText(StudioDev.getEffectif());	
	}

}