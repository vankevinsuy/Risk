package jeu;

import java.awt.Color;
import java.util.ArrayList;

public class Territoire {

	private Color couleur_territoire;
	private String Name;
	
	
	private Zone[] liste_zone_possible;

	public Territoire(Color couleur_territoire,String name,Zone[]listeZone) {
		super();
		this.couleur_territoire = couleur_territoire;
		this.Name = name;
		this.liste_zone_possible = listeZone;
		ConfigureZone(this.liste_zone_possible);
	}


	public Color getCouleur_territoire() {
		return couleur_territoire;
	}
	
	public Zone[] getListe_zone_possible() {
		return liste_zone_possible;
	}

	public void setCouleur_territoire(Color couleur_territoire) {
		this.couleur_territoire = couleur_territoire;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public void ConfigureZone(Zone[]liste) {
		if (this.Name == "Asie") {
			for (int i = 0; i < liste.length; i++) {
				liste[i] = new Zone(this.couleur_territoire, this.Name, i+1);
				liste[i].setCouleur_territoire(new Color(this.getCouleur_territoire().getRed(), 180 - (liste_zone_possible[i].getNum_zone() - 1)*10, this.getCouleur_territoire().getBlue()));
			}
		}	
		
		if (this.Name == "Afrique") {
			for (int i = 0; i < liste.length; i++) {
				liste[i] = new Zone(this.couleur_territoire, this.Name, i+1);
				liste[i].setCouleur_territoire(new Color(170 - (liste_zone_possible[i].getNum_zone() - 1)*10 ,this.getCouleur_territoire().getGreen(), this.getCouleur_territoire().getBlue()));
			}
		}	
		
		if (this.Name == "Amerique_du_sud") {
			for (int i = 0; i < liste.length; i++) {
				liste[i] = new Zone(this.couleur_territoire, this.Name, i+1);
				liste[i].setCouleur_territoire(new Color(this.getCouleur_territoire().getRed(), 180 - (liste_zone_possible[i].getNum_zone() - 1)*10, this.getCouleur_territoire().getBlue()));
			}
		}	
		
		if (this.Name == "Amerique_du_nord") {
			for (int i = 0; i < liste.length; i++) {
				liste[i] = new Zone(this.couleur_territoire, this.Name, i+1);
				liste[i].setCouleur_territoire(new Color(150 - (liste_zone_possible[i].getNum_zone() - 1)*10 ,this.getCouleur_territoire().getGreen(), this.getCouleur_territoire().getBlue()));
			}
		}	
		
		if (this.Name == "Europe") {
			for (int i = 0; i < liste.length; i++) {
				liste[i] = new Zone(this.couleur_territoire, this.Name, i+1);
				liste[i].setCouleur_territoire(new Color(this.getCouleur_territoire().getRed() ,this.getCouleur_territoire().getGreen() , 250 - (liste_zone_possible[i].getNum_zone() - 1)*10));
			}
		}	
		
		if (this.Name == "Oceanie") {
			for (int i = 0; i < liste.length; i++) {
				liste[i] = new Zone(this.couleur_territoire, this.Name, i+1);
				liste[i].setCouleur_territoire(new Color(240 - (liste_zone_possible[i].getNum_zone() - 1)*10 ,this.getCouleur_territoire().getGreen(), this.getCouleur_territoire().getBlue()));
			}
		}	
		

	}


	

}
