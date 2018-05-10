package jeu;

import introduction.Windows_intro;

public class Maitre_du_jeu {
	
	private int joueur_actuel = 1;

	public Maitre_du_jeu() {
		super();
		Plateau_de_jeu plateau_de_jeu = new Plateau_de_jeu();
		Plateau_de_jeu.Launch();
		Windows_intro.window.setVisible(false);
		System.out.println("game lancée");
	}

}
