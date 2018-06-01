package jeu;

import java.awt.Color;

public class Pion_soldat extends Pion{
	
	private double puissance =  Math.random() * ( 100 - 3 );

	private static final long serialVersionUID = 1L;

	public Pion_soldat(String iconePion, Zone zone) {
		super(iconePion, zone);
	}



}
