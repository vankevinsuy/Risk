package jeu;

import java.awt.Color;

public class Pion {
	
	private Color couleur_du_joueur;
	private String iconePion;
	private int nombre_de_pion;
	
	
	
	
	public Pion(Color couleur_du_joueur, String iconePion, int nombre_de_pion) {
		super();
		this.couleur_du_joueur = couleur_du_joueur;
		this.iconePion = iconePion;
		this.nombre_de_pion = nombre_de_pion;
	}
	
	
	public Color getCouleur_du_joueur() {
		return couleur_du_joueur;
	}
	public void setCouleur_du_joueur(Color couleur_du_joueur) {
		this.couleur_du_joueur = couleur_du_joueur;
	}
	public String getIconePion() {
		return iconePion;
	}
	public void setIconePion(String iconePion) {
		this.iconePion = iconePion;
	}

	public int getNombre_de_pion() {
		return nombre_de_pion;
	}
	public void setNombre_de_pion(int nombre_de_pion) {
		this.nombre_de_pion = nombre_de_pion;
	}

}
