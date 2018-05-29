package jeu;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Joueur {
	
	private String cheminicopionSoldat;
	private String cheminicopionCavalier;
	private String cheminicopionTank;
	private Color couleur_joueur;
	private ArrayList<Pion_soldat> liste_de_pion_soldat;
	private ArrayList<Pion_Cavalier> liste_de_pion_cavalier;
	private ArrayList<Pion_Tank> liste_de_pion_tank;
	private String name;
	private int armee;

	public Joueur(String icopionSoldat,String icopionCavalier,String icopionTank, String name , Color couleur_joueur) {
		this.cheminicopionSoldat = icopionSoldat;
		this.cheminicopionCavalier = icopionCavalier;
		this.cheminicopionTank = icopionTank;
		this.name = name;
		this.couleur_joueur = couleur_joueur;
		this.liste_de_pion_soldat = new ArrayList<Pion_soldat>();
		this.liste_de_pion_cavalier = new ArrayList<Pion_Cavalier>();
		this.liste_de_pion_tank = new ArrayList<Pion_Tank>();
	}


	public String getCheminicopionSoldat() {
		return cheminicopionSoldat;
	}


	public String getCheminicopionCavalier() {
		return cheminicopionCavalier;
	}


	public String getCheminicopionTank() {
		return cheminicopionTank;
	}


	public Color getCouleur_joueur() {
		return couleur_joueur;
	}


	public ArrayList<Pion_soldat> getListe_de_pion_soldat() {
		return liste_de_pion_soldat;
	}

	public void Add_Soldat(int nb_soldat, Pion_soldat soldat) {
		for (int i = 0; i < nb_soldat; i++) {
			liste_de_pion_soldat.add(soldat);
		}
	}

	public ArrayList<Pion_Cavalier> getListe_de_pion_cavalier() {
		return liste_de_pion_cavalier;
	}
	
	public void AddCavalier(int nb_cavalier, Pion_Cavalier cavalier) {
		for (int i = 0; i < nb_cavalier; i++) {
			liste_de_pion_cavalier.add(cavalier);
		}
	}


	public ArrayList<Pion_Tank> getListe_de_pion_tank() {
		return liste_de_pion_tank;
	}
	
	public void AddTank(int nb_Tank, Pion_Tank tank) {
		for (int i = 0; i < nb_Tank; i++) {
			liste_de_pion_tank.add(tank);
		}
	}


	public String getName() {
		return name;
	}

	public ArrayList<Pion_soldat> getListe_de_pion_soldatinZone_and_terriroire(int numZone , String territoire) {
		ArrayList<Pion_soldat> liste = new ArrayList<Pion_soldat>();
		for (int i = 0; i < liste_de_pion_soldat.size(); i++) {
			if (liste_de_pion_soldat.get(i).getZone().getNum_zone() == numZone && liste_de_pion_soldat.get(i).getZone().getNom_du_territoire()==territoire) {
				liste.add(this.getListe_de_pion_soldat().get(i));
			}
		}
		return liste;
	}
	
	public ArrayList<Pion_Cavalier> getListe_de_pion_cavalierinZone_and_terriroire(int numZone, String territoire) {
		ArrayList<Pion_Cavalier> liste = new ArrayList<Pion_Cavalier>();
		for (int i = 0; i < this.liste_de_pion_cavalier.size(); i++) {
			if (liste_de_pion_cavalier.get(i).getZone().getNum_zone() == numZone && liste_de_pion_cavalier.get(i).getZone().getNom_du_territoire()==territoire) {
				liste.add(getListe_de_pion_cavalier().get(i));
			}
		}
		return liste;
	}
	
	public ArrayList<Pion_Tank> getListe_de_pion_tankinZone_and_terriroire(int numZone, String territoire) {
		ArrayList<Pion_Tank> liste = new ArrayList<Pion_Tank>();
		for (int i = 0; i < this.liste_de_pion_tank.size(); i++) {
			if (liste_de_pion_tank.get(i).getZone().getNum_zone() == numZone && liste_de_pion_tank.get(i).getZone().getNom_du_territoire()==territoire) {
				liste.add(getListe_de_pion_tank().get(i));
			}
		}
		return liste;
	}


	public int getArmee() {
		return armee;
	}


	public void setArmee(int armee) {
		this.armee = armee;
	}
	
	public void RemovePionSoldat(int nombre_de_pion, String Territoire , int Zonenum) {
		for (int j = 0; j < nombre_de_pion; j++) {
			for (int i = 0; i < liste_de_pion_soldat.size(); i++) {
				if (liste_de_pion_soldat.get(i).getZone().getNom_du_territoire() == Territoire && liste_de_pion_soldat.get(i).getZone().getNum_zone() == Zonenum) {
					liste_de_pion_soldat.remove(i);
					break;
				}
				
			}
		}
	}
	
	public void RemovePionCavalier(int nombre_de_pion, String Territoire , int Zonenum) {
		for (int j = 0; j < nombre_de_pion; j++) {
			for (int i = 0; i < liste_de_pion_cavalier.size(); i++) {
				if (liste_de_pion_cavalier.get(i).getZone().getNom_du_territoire() == Territoire && liste_de_pion_cavalier.get(i).getZone().getNum_zone() == Zonenum) {
					liste_de_pion_cavalier.remove(i);
					break;
				}
				
			}
		}
	}
	
	public void RemovePionTank(int nombre_de_pion, String Territoire , int Zonenum) {
		for (int j = 0; j < nombre_de_pion; j++) {
			for (int i = 0; i < liste_de_pion_tank.size(); i++) {
				if (liste_de_pion_tank.get(i).getZone().getNom_du_territoire() == Territoire && liste_de_pion_tank.get(i).getZone().getNum_zone() == Zonenum) {
					liste_de_pion_tank.remove(i);
					break;
				}
				
			}
		}

	}
	

}
