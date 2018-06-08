package jeu;

import java.awt.Color;

public class Pion_soldat extends Pion{
	private int puissancemax = 1;
	private int puissancemin = 6;
	private int prioritedef =1;
	private int prioriteatt=2;

	private static final long serialVersionUID = 1L;

	public Pion_soldat(String iconePion, Zone zone) {
		super(iconePion, zone);
	}



	public int getPrioriteatt() {
		return prioriteatt;
	}



	public void setPrioriteatt(int prioriteatt) {
		this.prioriteatt = prioriteatt;
	}



	public int getPrioritedef() {
		return prioritedef;
	}



	public void setPrioritedef(int prioritedef) {
		this.prioritedef = prioritedef;
	}



	public int getPuissancemax() {
		return puissancemax;
	}
	
	public int getPuissancemin() {
		return puissancemin;
	}
	
	public void SoldatFightCavalier(Pion_Cavalier cavalier) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		System.out.println("Puissance soldat attaque = "+alea);
		int aleadef = (int)(Math.random()*(cavalier.getPuissancemax()-cavalier.getPuissancemin()))+cavalier.getPuissancemin();			
		System.out.println("Puissance cavalier defense = "+aleadef);
		  if (alea>aleadef) {
			System.out.println("Attaquant soldat a gagné");
		}
		  if (alea<=aleadef) {
			System.out.println("Defenseur cavalier a gagné");
		}
	}
	public void SoldatFightTank(Pion_Tank tank) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		System.out.println("Puissance soldat attaque = "+alea);
		int aleadef = (int)(Math.random()*(tank.getPuissancemax()-tank.getPuissancemin()))+tank.getPuissancemin();			
		System.out.println("Puissance tank defense = "+aleadef);
		  if (alea>aleadef) {
				System.out.println("Attaquant soldat a gagné");
			}
			  if (alea<=aleadef) {
				System.out.println("Defenseur tank a gagné");
			}
	}
}
