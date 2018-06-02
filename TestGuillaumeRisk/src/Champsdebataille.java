import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Champsdebataille {

	private ArrayList<Integer> arrayalea;
	private ArrayList<Integer> arrayaledef;

	public Champsdebataille() {
		super();
	}
	
	public ArrayList<Integer> getArrayalea() {
		return arrayalea;
	}
	public void setArrayalea(ArrayList<Integer> arrayalea) {
		this.arrayalea = arrayalea;
	}
	public ArrayList<Integer> getArrayaledef() {
		return arrayaledef;
	}
	public void setArrayaledef(ArrayList<Integer> arrayaledef) {
		this.arrayaledef = arrayaledef;
	}

	public ArrayList<Combattant> ListeArmeeAttaque(ArrayList<Combattant> listecombattantattaquant) {
		
		if (listecombattantattaquant.size()==1) { //Dans le cas ou il y'a un attaquant
			int alea = (int)(Math.random()*(listecombattantattaquant.get(0).getPuissancemax()-listecombattantattaquant.get(0).getPuissancemin()))+listecombattantattaquant.get(0).getPuissancemin();	
			ArrayList<Integer> arrayaleattaque = new ArrayList<Integer>();
			arrayaleattaque.add(alea);
			this.setArrayalea(arrayaleattaque);
			
		}
		
		if (listecombattantattaquant.size()==2) { //Dans le cas ou il y'a deux attaquants
			
			int alea = (int)(Math.random()*(listecombattantattaquant.get(0).getPuissancemax()-listecombattantattaquant.get(0).getPuissancemin()))+listecombattantattaquant.get(0).getPuissancemin();
			int alea2 = (int)(Math.random()*(listecombattantattaquant.get(1).getPuissancemax()-listecombattantattaquant.get(1).getPuissancemin()))+listecombattantattaquant.get(1).getPuissancemin();
			ArrayList<Integer> arrayaleattaque = new ArrayList<Integer>();
			arrayaleattaque.add(alea);
			arrayaleattaque.add(alea2);
			if (alea<alea2) {
				Collections.sort(arrayaleattaque); // a corriger
				Combattant tmp = listecombattantattaquant.get(0);
				listecombattantattaquant.remove(listecombattantattaquant.get(0));
				listecombattantattaquant.add(tmp);	
			}
			if (alea==alea2) {
				int prio1 = listecombattantattaquant.get(0).getPrioriteatta();
				int prio2 = listecombattantattaquant.get(1).getPrioriteatta();
				if (prio1>prio2) {	
					Collections.sort(arrayaleattaque);
					Combattant tmp = listecombattantattaquant.get(0);
					listecombattantattaquant.remove(listecombattantattaquant.get(0));
					listecombattantattaquant.add(tmp);	
				}
			
			}
			this.setArrayalea(arrayaleattaque);
		}
		
		if (listecombattantattaquant.size()==3) {  //Dans le cas ou il y'a trois attaquant
			
			
			int alea = (int)(Math.random()*(listecombattantattaquant.get(0).getPuissancemax()-listecombattantattaquant.get(0).getPuissancemin()))+listecombattantattaquant.get(0).getPuissancemin();
			int alea2 = (int)(Math.random()*(listecombattantattaquant.get(1).getPuissancemax()-listecombattantattaquant.get(1).getPuissancemin()))+listecombattantattaquant.get(1).getPuissancemin();
			int alea3 = (int)(Math.random()*(listecombattantattaquant.get(2).getPuissancemax()-listecombattantattaquant.get(2).getPuissancemin()))+listecombattantattaquant.get(2).getPuissancemin();
			ArrayList<Integer> arrayaleattaque = new ArrayList<Integer>();
			arrayaleattaque.add(alea);
			arrayaleattaque.add(alea2);
			arrayaleattaque.add(alea3);
			if (arrayaleattaque.get(0)<arrayaleattaque.get(1)) {	// inversion si necessaire de l'objet numero 1 de la liste au numero 2
				
					int tmp = arrayaleattaque.get(0);
					arrayaleattaque.remove(arrayaleattaque.get(0));
					arrayaleattaque.add(1,tmp);
					
					Combattant tmp2 = listecombattantattaquant.get(0);
					listecombattantattaquant.remove(listecombattantattaquant.get(0));
					listecombattantattaquant.add(1, tmp2);
				
			}
			if (arrayaleattaque.get(0)==arrayaleattaque.get(1)) {  // inversion si necessaire de l'objet numero 1 de la liste au numero 2 en cas d'égalité
				int prio1 = listecombattantattaquant.get(0).getPrioriteatta();
				int prio2 = listecombattantattaquant.get(1).getPrioriteatta();
				if (prio1>prio2) {	
					int tmp = arrayaleattaque.get(0);
					arrayaleattaque.remove(arrayaleattaque.get(0));
					arrayaleattaque.add(1,tmp);
					
					Combattant tmp2 = listecombattantattaquant.get(0);
					listecombattantattaquant.remove(listecombattantattaquant.get(0));
					listecombattantattaquant.add(1,tmp2);			
				}
			}	
				
			if (arrayaleattaque.get(1)<arrayaleattaque.get(2)) { // Inversion si necessaire de l'objet numéro 2 de la liste au numéro 3
				
				int tmp = arrayaleattaque.get(1);
				arrayaleattaque.remove(arrayaleattaque.get(1));
				arrayaleattaque.add(tmp);
				
				Combattant tmp2 = listecombattantattaquant.get(1);
				listecombattantattaquant.remove(listecombattantattaquant.get(1));
				listecombattantattaquant.add(tmp2);	
		}
			if (arrayaleattaque.get(1)==arrayaleattaque.get(2)) { // Inversion si necessaire de l'objet numéro 2 de la liste au numéro 3 en cas d'égalité 
				int prio2 = listecombattantattaquant.get(1).getPrioriteatta();
				int prio3 = listecombattantattaquant.get(2).getPrioriteatta();
				if (prio2>prio3) {	
					int tmp = arrayaleattaque.get(1);
					arrayaleattaque.remove(arrayaleattaque.get(1));
					arrayaleattaque.add(2,tmp);
					
					Combattant tmp2 = listecombattantattaquant.get(1);
					listecombattantattaquant.remove(listecombattantattaquant.get(1));
					listecombattantattaquant.add(2,tmp2);			
			}
			
		}
		
			if (arrayaleattaque.get(0)<arrayaleattaque.get(1)) { // Inversion si necessaire de l'objet numéro 1 de la liste au numéro 3
				
				int tmp = arrayaleattaque.get(0);
				arrayaleattaque.remove(arrayaleattaque.get(0));
				arrayaleattaque.add(1,tmp);
				
				Combattant tmp2 = listecombattantattaquant.get(0);
				listecombattantattaquant.remove(listecombattantattaquant.get(0));
				listecombattantattaquant.add(1,tmp2);	
		}
			
			if (arrayaleattaque.get(0)==arrayaleattaque.get(1)) { // Inversion si necessaire de l'objet numéro 2 de la liste au numéro 3 en cas d'égalité 
				int prio1 = listecombattantattaquant.get(0).getPrioriteatta();
				int prio2 = listecombattantattaquant.get(1).getPrioriteatta();
				if (prio1>prio2) {	
					int tmp = arrayaleattaque.get(0);
					arrayaleattaque.remove(arrayaleattaque.get(0));
					arrayaleattaque.add(1,tmp);
					
					Combattant tmp2 = listecombattantattaquant.get(0);
					listecombattantattaquant.remove(listecombattantattaquant.get(0));
					listecombattantattaquant.add(1,tmp2);			
			}
			
		}
			listecombattantattaquant.remove(listecombattantattaquant.get(2));
			this.setArrayalea(arrayaleattaque);
	}
		
	for (int i = 0; i < listecombattantattaquant.size(); i++) {
		System.out.println("L'ordre de combat est : "+listecombattantattaquant.get(i)+"pour l'attaque");
		
	}
	 return listecombattantattaquant;
}
	
	public ArrayList<Combattant> ListeArmeeDefense(ArrayList<Combattant> listecombattantdefenseur) {
		if (listecombattantdefenseur.size()==1) { //Dans le cas ou il y'a un attaquant
			int alea = (int)(Math.random()*(listecombattantdefenseur.get(0).getPuissancemax()-listecombattantdefenseur.get(0).getPuissancemin()))+listecombattantdefenseur.get(0).getPuissancemin();	
			ArrayList<Integer> arrayaledef = new ArrayList<Integer>();
			arrayaledef.add(alea);
			this.setArrayalea(arrayaledef);
		}
		
		if (listecombattantdefenseur.size()==2) { //Dans le cas ou il y'a deux attaquants
			int alea = (int)(Math.random()*(listecombattantdefenseur.get(0).getPuissancemax()-listecombattantdefenseur.get(0).getPuissancemin()))+listecombattantdefenseur.get(0).getPuissancemin();
			int alea2 = (int)(Math.random()*(listecombattantdefenseur.get(1).getPuissancemax()-listecombattantdefenseur.get(1).getPuissancemin()))+listecombattantdefenseur.get(1).getPuissancemin();
			ArrayList<Integer> arrayaledef = new ArrayList<Integer>();
			arrayaledef.add(alea);
			arrayaledef.add(alea2);
			if (alea<alea2) {				
					Collections.sort(arrayaledef);
					Combattant tmp = listecombattantdefenseur.get(0);
					listecombattantdefenseur.remove(listecombattantdefenseur.get(0));
					listecombattantdefenseur.add(tmp);			
			}
			
			if (alea == alea2) { //Dans le cas ou il y'a deux attaquants avec la même puissance
				int prio = listecombattantdefenseur.get(0).getPrioritedef();
				int prio2 = listecombattantdefenseur.get(1).getPrioritedef();
				
				if (prio>prio2) {
					Collections.sort(arrayaledef);
					Combattant tmp2 = listecombattantdefenseur.get(0);
					listecombattantdefenseur.remove(listecombattantdefenseur.get(0));
					listecombattantdefenseur.add(tmp2);			
				}
				
			}
		}
		this.setArrayalea(arrayaledef);
		for (int i = 0; i < listecombattantdefenseur.size(); i++) {
			System.out.println("L'ordre de combat est : "+listecombattantdefenseur.get(i)+"pour la défense");
			
		}
		return listecombattantdefenseur;
	}
	
}
