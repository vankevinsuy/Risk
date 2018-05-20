package jeu;

import java.awt.Color;

public class Joueur {
	
	private String icopionSoldat;
	private String icopionCavalier;
	private String icopionTank;
	
	private Color couleur_joueur;
	
	private String name;

	public Joueur(String icopionSoldat,String icopionCavalier,String icopionTank, String name , Color couleur_joueur) {
		super();
		this.icopionSoldat = icopionSoldat;
		this.icopionCavalier = icopionCavalier;
		this.icopionTank = icopionTank;
		this.name = name;
		this.couleur_joueur = couleur_joueur;
	}

	public Color getCouleur_joueur() {
		return couleur_joueur;
	}

	public String getName() {
		return name;
	}

	public String getIcopionSoldat() {
		return icopionSoldat;
	}

	public String getIcopionCavalier() {
		return icopionCavalier;
	}

	public String getIcopionTank() {
		return icopionTank;
	}



}
