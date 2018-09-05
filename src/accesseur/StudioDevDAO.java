package accesseur;

import java.util.ArrayList;
import java.util.List;

import modele.StudioDev;

public class StudioDevDAO {
	
	public List<StudioDev> simulerListeStudioDev(){
		List listeStudioDevTest = new ArrayList<StudioDev>();
		listeStudioDevTest.add(new StudioDev("Naughty Dog", "Santa Monica", "1984", "200+"));
		listeStudioDevTest.add(new StudioDev("CD Projekt Red", "Varsovie", "1994", "600"));
		listeStudioDevTest.add(new StudioDev("Vicarious Visions", "Menands", "1990", "200"));
		return listeStudioDevTest;
	}
	public List<StudioDev>listerStudioDev(){
		return this.simulerListeStudioDev();
	}
	
}
