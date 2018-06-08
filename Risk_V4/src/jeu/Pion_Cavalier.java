package jeu;

import java.awt.Color;

public class Pion_Cavalier extends Pion{

	private int puissancemax = 2;
	private int puissancemin = 7;
	private int prioritedef=3;
	private int prioriteatta=1;
	
	public Pion_Cavalier(String iconePion, Zone zone) {
		super(iconePion, zone);
	}


	public int getPrioriteatta() {
		return prioriteatta;
	}

	public void setPrioriteatta(int prioriteatta) {
		this.prioriteatta = prioriteatta;
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
	
	public void CavalierFightSoldat(Pion_soldat soldat) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		System.out.println("Puissance cavalier attaque = "+alea);
		int aleadef = (int)(Math.random()*(soldat.getPuissancemax()-soldat.getPuissancemin()))+soldat.getPuissancemin();			
		System.out.println("Puissance soldat defense = "+aleadef);
		  if (alea>aleadef) {
				System.out.println("Attaquant cavalier a gagn�");
			}
			  if (alea<=aleadef) {
				System.out.println("Defenseur soldat a gagn�");
			}
		
	}
	public void CavalierFightTank(Pion_Tank tank) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		System.out.println("Puissance cavalier attaque = "+alea);
		int aleadef = (int)(Math.random()*(tank.getPuissancemax()-tank.getPuissancemin()))+tank.getPuissancemin();			
		System.out.println("Puissance soldat defense = "+aleadef);
		  if (alea>aleadef) {
				System.out.println("Attaquant cavalier a gagn�");
			}
			  if (alea<=aleadef) {
				System.out.println("Defenseur tank a gagn�");
			}
		
	}
	
	public void CavalierFightCavalier() {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		  System.out.println("aleatoire attaque = "+alea);
		  int aleadef = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		  System.out.println("aleatoire defense = "+aleadef);
		  if (alea>aleadef) {
				System.out.println("Attaquant cavalier a gagn�");
			}
			  if (alea<=aleadef) {
				System.out.println("Defenseur cavalier a gagn�");
			}
	}
}

	

