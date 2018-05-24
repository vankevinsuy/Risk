package jeu;

import java.awt.Color;

public class Pion {
	
	private String iconePion;
	private int valeur;
	private Zone zone;
	public Pion(String iconePion, Zone zone) {
		this.iconePion = iconePion;
		this.zone=zone;
	}
	
	
	public Zone getZone() {
		return zone;
	}


	public String getIconePion() {
		return iconePion;
	}
	public int getValeur() {
		return valeur;
	}


}
