package jeu;

import java.awt.Color;

public class Pion {
	
	private String iconePion;
	private int valeur;
	private int xposition;
	private int yposition;
	public Pion(String iconePion, int valeur, int xposition, int yposition) {
		this.iconePion = iconePion;
		this.valeur = valeur;
		this.xposition = xposition;
		this.yposition = yposition;
	}
	
	
	public String getIconePion() {
		return iconePion;
	}
	public int getValeur() {
		return valeur;
	}
	public int getXposition() {
		return xposition;
	}
	public int getYposition() {
		return yposition;
	}

}
