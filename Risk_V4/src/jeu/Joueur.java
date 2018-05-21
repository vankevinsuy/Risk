package jeu;

import java.awt.Color;

public class Joueur {
	
	private String icopionSoldat;
	private String icopionCavalier;
	private String icopionTank;
	
	private Color couleur_joueur;
	
	private Pion[] pions;// = new Pion_soldat(this.getCouleur_joueur(), this.getIcopionSoldat(), 4);
	
	private String name;

	public Joueur(String icopionSoldat,String icopionCavalier,String icopionTank, String name , Color couleur_joueur, Pion[] pion) {
		super();
		this.icopionSoldat = icopionSoldat;
		this.icopionCavalier = icopionCavalier;
		this.icopionTank = icopionTank;
		this.name = name;
		this.couleur_joueur = couleur_joueur;
		this.pions = pion;
		InitPion(pion);
	}

	public Pion getPions(int i) {
		return pions[i];
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
	
	public void InitPion( Pion[] pion) {
		pion[0] = new Pion_soldat(this.couleur_joueur, this.icopionSoldat, 4);
		pion[1] = new Pion_soldat(this.couleur_joueur, this.icopionCavalier, 2);
		pion[2] = new Pion_soldat(this.couleur_joueur, this.icopionTank, 1);
	}

	public boolean GestionPion() {
		for (int i = 0; i < pions.length; i++) {
			if (this.getPions(i).getNombre_de_pion() == 0) {
				System.out.println("plus de soldat");
				return false;
			}
		}
		return true;
	}
	
	public void ResetRound() {
		pions[0].setNombre_de_pion(4);
		pions[1].setNombre_de_pion(2);
		pions[2].setNombre_de_pion(1);
	}

}
