package jeu;

import java.awt.font.TextHitInfo;

public class Maitre_du_jeu {
	
	private static int nombre_de_joueur = 0;
	
	private static int joueur_actuel = 1;


	public static void main(String[] args) {
		Introduction introduction = new Introduction();
	}
	
	
	public static int getJoueur_actuel() {
		return joueur_actuel;
	}



	public static void setJoueur_actuel(int joueur_actuel) {
		Maitre_du_jeu.joueur_actuel = joueur_actuel;
	}
	
	
	public static int getNombre_de_joueur() {
		return nombre_de_joueur;
	}

	public static void setNombre_de_joueur(int nombre) {
		nombre_de_joueur = nombre;
	}
	
	public static void LaunchGame() {
		System.out.println("Game lancée ! ");
		System.out.println("Tour du joueur " + getJoueur_actuel());
		new Plateau_de_jeu();
	}


}
