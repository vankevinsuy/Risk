package jeu;

import java.awt.Color;
import java.util.ArrayList;

public class Territoire {


	private int couleur_primaire_territoire1;
	private int couleur_primaire_territoire2;
	private String Name;
	private ArrayList<Zone> liste_zone_possible;
	
	
	public Territoire(int couleur_primaire_territoire1,int couleur_primaire_territoire2 , String name) {
		super();
		this.couleur_primaire_territoire1 = couleur_primaire_territoire1;
		this.couleur_primaire_territoire2 = couleur_primaire_territoire2;
		Name = name;
		this.liste_zone_possible = new ArrayList<Zone>();
	}



	public int getCouleur_primaire_territoire1() {
		return couleur_primaire_territoire1;
	}


	public int getCouleur_primaire_territoire2() {
		return couleur_primaire_territoire2;
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