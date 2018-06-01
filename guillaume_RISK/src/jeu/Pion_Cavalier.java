package jeu;

import java.awt.Color;

public class Pion_Cavalier extends Pion{
	private double puissance =  Math.random() * ( 100 - 3 );

	public Pion_Cavalier(String iconePion, Zone zone) {
		super(iconePion, zone);
	}
	
	public void Affiche() {
		System.out.println(puissance);
	}

	public double getPuissance() {
		return puissance;
	}


}

	

