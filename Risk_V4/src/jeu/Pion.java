package jeu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pion  {

	private int puissancemin;
	private int puissancemax;
	private int prioritedef;
	private int prioriteatta;
	private String iconePion;
	private int valeur;
	private Zone zone;
	
	
	public Pion(String iconePion, Zone zone){
		this.iconePion = iconePion;
		this.zone=zone;
		this.puissancemin = puissancemin;
		this.puissancemax = puissancemax;

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

	
	public int getPrioriteatta() {
		return prioriteatta;
	}



	public void setPrioriteatta(int prioriteatta) {
		this.prioriteatta = prioriteatta;
	}



	public int getPuissancemin() {
		return puissancemin;
	}


	public void setPuissancemin(int puissancemin) {
		this.puissancemin = puissancemin;
	}


	public int getPuissancemax() {
		return puissancemax;
	}


	public void setPuissancemax(int puissancemax) {
		this.puissancemax = puissancemax;
	}


	public int getPrioritedef() {
		return prioritedef;
	}


	public void setPrioritedef(int prioritedef) {
		this.prioritedef = prioritedef;
	}

}
