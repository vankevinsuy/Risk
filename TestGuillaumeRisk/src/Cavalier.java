import java.security.PublicKey;

public class Cavalier {
	private int puissancemax = 7;
	private int puissancemin = 6;
	
	
	public Cavalier() {
		super();

	}

	public int getPuissancemax() {
		return puissancemax;
	}

	public int getPuissancemin() {
		return puissancemin;
	}
	
	public void CavalierFightSoldat(Soldat soldat) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		System.out.println("Puissance cavalier attaque = "+alea);
		int aleadef = (int)(Math.random()*(soldat.getPuissancemax()-soldat.getPuissancemin()))+soldat.getPuissancemin();			
		System.out.println("Puissance soldat defense = "+aleadef);
		  if (alea>aleadef) {
				System.out.println("Attaquant cavalier a gagné");
			}
			  if (alea<=aleadef) {
				System.out.println("Defenseur soldat a gagné");
			}
		
	}
	public void CavalierFightTank(Tank tank) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		System.out.println("Puissance cavalier attaque = "+alea);
		int aleadef = (int)(Math.random()*(tank.getPuissancemax()-tank.getPuissancemin()))+tank.getPuissancemin();			
		System.out.println("Puissance soldat defense = "+aleadef);
		  if (alea>aleadef) {
				System.out.println("Attaquant cavalier a gagné");
			}
			  if (alea<=aleadef) {
				System.out.println("Defenseur tank a gagné");
			}
		
	}
	
	public void CavalierFightCavalier() {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		  System.out.println("aleatoire attaque = "+alea);
		  int aleadef = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		  System.out.println("aleatoire defense = "+aleadef);
		  if (alea>aleadef) {
				System.out.println("Attaquant cavalier a gagné");
			}
			  if (alea<=aleadef) {
				System.out.println("Defenseur cavalier a gagné");
			}
	}

}
