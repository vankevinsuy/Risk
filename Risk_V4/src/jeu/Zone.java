package jeu;

import java.awt.Color;

public class Zone {

	private Color couleur_territoire;
	private String Name;
	private int num_zone;
	
	
	public Zone(Color couleur_territoire, String name, int num_zone) {
		this.couleur_territoire = couleur_territoire;
		Name = name;
		this.num_zone = num_zone;
	}


	public Color getCouleur_territoire() {
		return couleur_territoire;
	}


	public void setCouleur_territoire(Color couleur_territoire) {
		this.couleur_territoire = couleur_territoire;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getNum_zone() {
		return num_zone;
	}


	public void setNum_zone(int num_zone) {
		this.num_zone = num_zone;
	}




}
