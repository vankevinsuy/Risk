package jeu;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Maitre_du_jeu {
	
	private  int nombre_de_joueur = 0;
	
	private Pion_soldat pion_soldat;
	private Pion_Cavalier pion_Cavalier;
	private Pion_Tank pion_Tank;
		
	
	// Initialistion des joueurs 
	private  Joueur joueur1 = new Joueur("/image/ico_bouton_joueur1/soldat.png","/image/ico_bouton_joueur1/cavalier.png","/image/ico_bouton_joueur1/tank.png","Annie",new Color(208, 77, 202));
	private  Joueur joueur2 = new Joueur("/image/ico_bouton_joueur2/soldat.png","/image/ico_bouton_joueur2/cavalier.png","/image/ico_bouton_joueur2/tank.png","Ahri",new Color(3, 248, 254));
	private  Joueur joueur3 = new Joueur("/image/ico_bouton_joueur3/soldat.png","/image/ico_bouton_joueur3/cavalier.png","/image/ico_bouton_joueur3/tank.png","Mundo",new Color(128, 64, 0));
	private  Joueur joueur4 = new Joueur("/image/ico_bouton_joueur4/soldat.png","/image/ico_bouton_joueur4/cavalier.png","/image/ico_bouton_joueur4/tank.png","WW",new Color(56, 255, 40));
	private  Joueur joueur5 = new Joueur("/image/ico_bouton_joueur5/soldat.png","/image/ico_bouton_joueur5/cavalier.png","/image/ico_bouton_joueur5/tank.png","Braum",new Color(255, 6, 13));
	private  Joueur joueur6 = new Joueur("/image/ico_bouton_joueur6/soldat.png","/image/ico_bouton_joueur6/cavalier.png","/image/ico_bouton_joueur6/tank.png","tristana",new Color(253, 126, 0));
	
	
	
	private  Joueur[] listeJoueurPossible = {joueur1, joueur2,joueur3,joueur4,joueur5,joueur6};
	private  ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();

	private Joueur current_player = joueur1;
	
	//Initialisation des territoires 
	private Territoire Asie = new Territoire(227,78 ,"Asie");
	private Territoire Afrique = new Territoire(25,90,"Afrique");
	private Territoire Amerique_du_sud = new Territoire(85,89,"Amerique_du_sud");
	private Territoire Amerique_du_nord = new Territoire(206,78,"Amerique_du_nord");
	private Territoire Europe = new Territoire(139,149,"Europe");
	private Territoire Oceanie = new Territoire(118,118,"Oceanie");
	
	
	private Territoire[] liste_territoire_possible = {Asie, Afrique, Amerique_du_nord, Amerique_du_sud,Europe,Oceanie};
	private ArrayList<Territoire> listeTerritoire = new ArrayList<Territoire>();
	

	
	//constructeur
	public Maitre_du_jeu() {
		this.nombre_de_joueur = nombre_de_joueur;

	}
	
	public static void main(String[] args) {	
		Maitre_du_jeu maitre_du_jeu = new Maitre_du_jeu();
		Introduction introduction = new Introduction(maitre_du_jeu);
	}

	public int getNombre_de_joueur() {
		return nombre_de_joueur;
	}

	public void setNombre_de_joueur(int nombre_de_joueur) {
		this.nombre_de_joueur = nombre_de_joueur;
	}
	
	public void LaunchGame() {
		System.out.println("Game lanc�e !  //maitre du jeu ");
		System.out.println("Tour de " + current_player .getName() + " //maitre du jeu");
		
		//initialisation des joueurs
		for (int i = 0; i < nombre_de_joueur; i++) {
			listeJoueur.add(listeJoueurPossible[i]);
		}
		//initilisation des territoires
		for (int i = 0; i < liste_territoire_possible.length; i++) {
			listeTerritoire.add(liste_territoire_possible[i]);
		}
		
		//initialisation des zones
		for (int i = 0; i < listeTerritoire.size(); i++) {
			for (int j = 0; j < 7 ; j++) {
				if (listeTerritoire.get(i).getName() == "Asie") {
					listeTerritoire.get(i).AddZone(new Zone(listeTerritoire.get(i).getName(), j+1, new Color(listeTerritoire.get(i).getCouleur_primaire_territoire1(), 180 - (10*j) , listeTerritoire.get(i).getCouleur_primaire_territoire2())));
				}
				
				if (listeTerritoire.get(i).getName() == "Afrique") {
					listeTerritoire.get(i).AddZone(new Zone(listeTerritoire.get(i).getName(), j+1, new Color( 170 - (10*j),listeTerritoire.get(i).getCouleur_primaire_territoire1(),listeTerritoire.get(i).getCouleur_primaire_territoire2())));
				}
				
				if (listeTerritoire.get(i).getName() == "Amerique_du_sud") {
					listeTerritoire.get(i).AddZone(new Zone(listeTerritoire.get(i).getName(), j+1, new Color(listeTerritoire.get(i).getCouleur_primaire_territoire1(), 180 - (10*j) ,listeTerritoire.get(i).getCouleur_primaire_territoire2())));
				}
				
				if (listeTerritoire.get(i).getName() == "Amerique_du_nord") {
					listeTerritoire.get(i).AddZone(new Zone(listeTerritoire.get(i).getName(), j+1, new Color(150 - (10*j),listeTerritoire.get(i).getCouleur_primaire_territoire1(), listeTerritoire.get(i).getCouleur_primaire_territoire2())));
				}
				
				if (listeTerritoire.get(i).getName() == "Europe") {
					listeTerritoire.get(i).AddZone(new Zone(listeTerritoire.get(i).getName(), j+1, new Color(listeTerritoire.get(i).getCouleur_primaire_territoire1(), listeTerritoire.get(i).getCouleur_primaire_territoire2(), 250 - (10*j))));
				}
				
				if (listeTerritoire.get(i).getName() == "Oceanie") {
					listeTerritoire.get(i).AddZone(new Zone(listeTerritoire.get(i).getName(), j+1, new Color(240 - (10*j),118, 118)));
				}
				
			}
		}
		
//		joueur1.Add_Soldat(2, new Pion_soldat(joueur1.getCheminicopionSoldat(), new Zone("Asie", 2 ,new Color(227, 180, 77))));
		
		Plateau_de_jeu plateau_de_jeu = new Plateau_de_jeu(this, this.listeJoueur, this.listeTerritoire);
		
	}

	
}
