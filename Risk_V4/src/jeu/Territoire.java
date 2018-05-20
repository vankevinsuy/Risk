package jeu;

import java.awt.Color;

public class Territoire {

	private Color couleur_territoire;
	private String Name;

	public Territoire(Color couleur_territoire,String name) {
		super();
		this.couleur_territoire = couleur_territoire;
		this.Name = name;
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



	

}
