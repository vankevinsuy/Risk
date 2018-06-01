package jeu;

import java.awt.Color;

public class Pion_Tank extends Pion{
	
	private double puissance =  Math.random() * ( 100 - 3 );



	public Pion_Tank(String iconePion, Zone zone) {
		super(iconePion, zone);
	}


	public double getPuissance() {
		return puissance;
	}

}
