package jeu;

import introduction.Windows_intro;

public class Maitre_du_jeu {
	
	private static int joueur_actuel = 1;

	public Maitre_du_jeu() {
		super();
		Plateau_de_jeu plateau_de_jeu = new Plateau_de_jeu();
		Plateau_de_jeu.Launch();
		Windows_intro.window.setVisible(false);
		System.out.println("game lancée");
	}

	public static int getJoueur_actuel() {
		return joueur_actuel;
	}

	public static void setJoueur_actuel(int joueur_actuel) {
		Maitre_du_jeu.joueur_actuel = joueur_actuel;
	}



}
