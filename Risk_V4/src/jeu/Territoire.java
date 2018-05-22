package jeu;

import java.awt.Color;
import java.util.ArrayList;

public class Territoire {

	private Color couleur_territoire;
	private String Name;
	private ArrayList<Zone> liste_zone_possible;
	
	
	public Territoire(Color couleur_territoire, String name) {
		super();
		this.couleur_territoire = couleur_territoire;
		Name = name;
		this.liste_zone_possible = new ArrayList<Zone>();
	}


	public Color getCouleur_territoire() {
		return couleur_territoire;
	}


	public String getName() {
		return Name;
	}


	public ArrayList<Zone> getListe_zone_possible() {
		return liste_zone_possible;
	}
	
	public void AddZone(Zone zone) {
		this.liste_zone_possible.add(zone);
	}
	
		

}