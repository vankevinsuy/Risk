package jeu;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Maitre_du_jeu {
	
	private  int nombre_de_joueur = 0;
	private  int numjoueur_actuel = 1;
	
	private  Joueur joueur1 = new Joueur("/image/pion.png","jojo");
	private  Joueur joueur2 = new Joueur("/image/soldat.png","ijij");
	private  Joueur joueur3 = new Joueur("/image/soldat.png","jii");
	private  Joueur joueur4 = new Joueur("/image/soldat.png","hhh");
	private  Joueur joueur5 = new Joueur("/image/soldat.png","hhh");
	private  Joueur joueur6 = new Joueur("/image/soldat.png","ccc");
	
	private Joueur current_player = joueur1;
	private  Joueur[] listeJoueurPossible = {joueur1, joueur2,joueur3,joueur4,joueur5,joueur6};
	private   ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
	
	public Maitre_du_jeu() {
		this.current_player = current_player;
				
	}

	


	public static void main(String[] args) {
		Maitre_du_jeu maitre_du_jeu=new Maitre_du_jeu();
		Introduction introduction = new Introduction(maitre_du_jeu);
	}
	
	

	
	
	public int getNumjoueur_actuel() {
		return numjoueur_actuel;
	}




	public void setNumjoueur_actuel(int numjoueur_actuel) {
		this.numjoueur_actuel = numjoueur_actuel;
	}




	public  int getNombre_de_joueur() {
		return nombre_de_joueur;
	}

	public  void setNombre_de_joueur(int nombre) {
		nombre_de_joueur = nombre;
	}
	
	public void LaunchGame() {
		System.out.println("Game lancée ! ");
		System.out.println("Tour de " + current_player.getName());
		for (int i = 0; i < nombre_de_joueur; i++) {
			listeJoueur.add(listeJoueurPossible[i]);
		}
		new Plateau_de_jeu(this, current_player.getName());
	}




	public Joueur getCurrent_player() {
		return current_player;
	}




	public void setCurrent_player(Joueur current_player) {
		this.current_player = current_player;
	}




	public Joueur getListeJoueur(int index) {
		return listeJoueur.get(index);
	}





}
