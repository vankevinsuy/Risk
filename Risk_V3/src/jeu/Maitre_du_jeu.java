package jeu;

import java.awt.Frame;

public class Maitre_du_jeu {
	
	private static int nombre_de_joueur = 0;
	


	public static void main(String[] args) {
		Introduction introduction = new Introduction();

	}
	
	
	
	public static int getNombre_de_joueur() {
		return nombre_de_joueur;
	}

	public static void setNombre_de_joueur(int nombre) {
		nombre_de_joueur = nombre;
	}
	
	public static void LaunchGame() {
		System.out.println("Game lancée ! ");
		new Plateau_de_jeu();
	}
}
