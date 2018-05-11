package jeu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import introduction.Windows_intro;

public class Mouse_function extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		Maitre_du_jeu.setJoueur_actuel(Maitre_du_jeu.getJoueur_actuel() + 1);
		System.out.println("Tour joueur " + Maitre_du_jeu.getJoueur_actuel());
		
		if (Maitre_du_jeu.getJoueur_actuel() == Windows_intro.nombre_de_joueur) {
			Maitre_du_jeu.setJoueur_actuel(0);
		}
	}
}
