package introduction;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import jeu.Plateau_de_jeu;

public class Mouse_control extends MouseAdapter{
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);

		if (e.getComponent().getName().toString() == "bouton_jouer") {
			if (Windows_intro.nombre_de_joueur == 0) {
				System.out.println("choisissez le nombre de joueurs");
				
			}
			else {
				System.out.println("lancer une partie à " +Windows_intro.nombre_de_joueur + " joueurs");
				
				Plateau_de_jeu plateau_de_jeu = new Plateau_de_jeu();
				plateau_de_jeu.Launch();
				Windows_intro.window.setVisible(false);
			}
			
		}
		
		if (e.getComponent().getName().toString() == "bouton_2joueurs") {
			Windows_intro.nombre_de_joueur = 2 ; 
			
			Windows_intro.bouton_2joueurs.setBorderPainted(true);
			Windows_intro.bouton_2joueurs.setOpaque(true);
			Windows_intro.bouton_2joueurs.setContentAreaFilled(true);
			Windows_intro.bouton_2joueurs.setBackground(Color.red);
			
			Windows_intro.bouton_3joueurs.setBorderPainted(false);
			Windows_intro.bouton_3joueurs.setOpaque(false);
			Windows_intro.bouton_3joueurs.setContentAreaFilled(false);
			
			Windows_intro.bouton_4joueurs.setBorderPainted(false);
			Windows_intro.bouton_4joueurs.setOpaque(false);
			Windows_intro.bouton_4joueurs.setContentAreaFilled(false);
		
			Windows_intro.bouton_5joueurs.setBorderPainted(false);
			Windows_intro.bouton_5joueurs.setOpaque(false);
			Windows_intro.bouton_5joueurs.setContentAreaFilled(false);
			
			Windows_intro.bouton_6joueurs.setBorderPainted(false);
			Windows_intro.bouton_6joueurs.setOpaque(false);
			Windows_intro.bouton_6joueurs.setContentAreaFilled(false);
			
			for (int i = 0; i < 6; i++) {
				
			}
		}
		
		if (e.getComponent().getName().toString() == "bouton_3joueurs") {
			Windows_intro.nombre_de_joueur = 3 ;
			
			Windows_intro.bouton_3joueurs.setBorderPainted(true);
			Windows_intro.bouton_3joueurs.setOpaque(true);
			Windows_intro.bouton_3joueurs.setContentAreaFilled(true);
			Windows_intro.bouton_3joueurs.setBackground(Color.red);
			
			Windows_intro.bouton_2joueurs.setBorderPainted(false);
			Windows_intro.bouton_2joueurs.setOpaque(false);
			Windows_intro.bouton_2joueurs.setContentAreaFilled(false);
			
			Windows_intro.bouton_4joueurs.setBorderPainted(false);
			Windows_intro.bouton_4joueurs.setOpaque(false);
			Windows_intro.bouton_4joueurs.setContentAreaFilled(false);
		
			Windows_intro.bouton_5joueurs.setBorderPainted(false);
			Windows_intro.bouton_5joueurs.setOpaque(false);
			Windows_intro.bouton_5joueurs.setContentAreaFilled(false);
			
			Windows_intro.bouton_6joueurs.setBorderPainted(false);
			Windows_intro.bouton_6joueurs.setOpaque(false);
			Windows_intro.bouton_6joueurs.setContentAreaFilled(false);
		}
		
		if (e.getComponent().getName().toString() == "bouton_4joueurs") {
			Windows_intro.nombre_de_joueur = 4 ; 
			
			Windows_intro.bouton_4joueurs.setBorderPainted(true);
			Windows_intro.bouton_4joueurs.setOpaque(true);
			Windows_intro.bouton_4joueurs.setContentAreaFilled(true);
			Windows_intro.bouton_4joueurs.setBackground(Color.red);
			
			Windows_intro.bouton_3joueurs.setBorderPainted(false);
			Windows_intro.bouton_3joueurs.setOpaque(false);
			Windows_intro.bouton_3joueurs.setContentAreaFilled(false);
			
			Windows_intro.bouton_2joueurs.setBorderPainted(false);
			Windows_intro.bouton_2joueurs.setOpaque(false);
			Windows_intro.bouton_2joueurs.setContentAreaFilled(false);
		
			Windows_intro.bouton_5joueurs.setBorderPainted(false);
			Windows_intro.bouton_5joueurs.setOpaque(false);
			Windows_intro.bouton_5joueurs.setContentAreaFilled(false);
			
			Windows_intro.bouton_6joueurs.setBorderPainted(false);
			Windows_intro.bouton_6joueurs.setOpaque(false);
			Windows_intro.bouton_6joueurs.setContentAreaFilled(false);
		}
		
		if (e.getComponent().getName().toString() == "bouton_5joueurs") {
			Windows_intro.nombre_de_joueur = 5 ; 
			
			Windows_intro.bouton_5joueurs.setBorderPainted(true);
			Windows_intro.bouton_5joueurs.setOpaque(true);
			Windows_intro.bouton_5joueurs.setContentAreaFilled(true);
			Windows_intro.bouton_5joueurs.setBackground(Color.red);
			
			Windows_intro.bouton_3joueurs.setBorderPainted(false);
			Windows_intro.bouton_3joueurs.setOpaque(false);
			Windows_intro.bouton_3joueurs.setContentAreaFilled(false);
			
			Windows_intro.bouton_4joueurs.setBorderPainted(false);
			Windows_intro.bouton_4joueurs.setOpaque(false);
			Windows_intro.bouton_4joueurs.setContentAreaFilled(false);
		
			Windows_intro.bouton_2joueurs.setBorderPainted(false);
			Windows_intro.bouton_2joueurs.setOpaque(false);
			Windows_intro.bouton_2joueurs.setContentAreaFilled(false);
			
			Windows_intro.bouton_6joueurs.setBorderPainted(false);
			Windows_intro.bouton_6joueurs.setOpaque(false);
			Windows_intro.bouton_6joueurs.setContentAreaFilled(false);
		}
		
		if (e.getComponent().getName().toString() == "bouton_6joueurs") {
			Windows_intro.nombre_de_joueur = 6 ; 
			
			Windows_intro.bouton_6joueurs.setBorderPainted(true);
			Windows_intro.bouton_6joueurs.setOpaque(true);
			Windows_intro.bouton_6joueurs.setContentAreaFilled(true);
			Windows_intro.bouton_6joueurs.setBackground(Color.red);
			
			Windows_intro.bouton_3joueurs.setBorderPainted(false);
			Windows_intro.bouton_3joueurs.setOpaque(false);
			Windows_intro.bouton_3joueurs.setContentAreaFilled(false);
			
			Windows_intro.bouton_4joueurs.setBorderPainted(false);
			Windows_intro.bouton_4joueurs.setOpaque(false);
			Windows_intro.bouton_4joueurs.setContentAreaFilled(false);
		
			Windows_intro.bouton_5joueurs.setBorderPainted(false);
			Windows_intro.bouton_5joueurs.setOpaque(false);
			Windows_intro.bouton_5joueurs.setContentAreaFilled(false);
			
			Windows_intro.bouton_2joueurs.setBorderPainted(false);
			Windows_intro.bouton_2joueurs.setOpaque(false);
			Windows_intro.bouton_2joueurs.setContentAreaFilled(false);
		}
		
	}
}
