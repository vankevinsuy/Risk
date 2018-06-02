
public class Tank extends Combattant{
	private int puissancemax = 4;
	private int puissancemin = 9;
	private int random = (int)(Math.random()*(4-9))+9;
	private int prioritedef=2;
	private int prioriteatt=3;
	
	public Tank() {
		super();
	}
	
	public void TankFightSoldat(Soldat soldat) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		System.out.println("Puissance tank attaque = "+alea);
		int aleadef = (int)(Math.random()*(soldat.getPuissancemax()-soldat.getPuissancemin()))+soldat.getPuissancemin();
		System.out.println("Puissance soldat defense = "+aleadef);
		if (alea>aleadef) {
			System.out.println("Attaquant Tank a gagné");
		}
		  if (alea<=aleadef) {
			System.out.println("Defenseur soldat a gagné");
		}
		 
	}
	
	public void TankFightCavalier(Cavalier cavalier) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		System.out.println("Puissance tank attaque = "+alea);
		int aleadef = (int)(Math.random()*(cavalier.getPuissancemax()-cavalier.getPuissancemin()))+cavalier.getPuissancemin();
		System.out.println("Puissance cavalier defense = "+aleadef);
		if (alea>aleadef) {
			System.out.println("Attaquant soldat a gagné");
		}
		  if (alea<=aleadef) {
			System.out.println("Defenseur cavalier a gagné");
		}
		 
	}
	
	public void TankfightTank(Tank tank) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		  System.out.println("tank attaque = "+alea);
		  int aleadef = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		  System.out.println("tank defense = "+aleadef);
		  if (alea>aleadef) {
				System.out.println("Attaquant tank a gagné");
			}
			  if (alea<=aleadef) {
				System.out.println("Defenseur tank a gagné");
			}
		
		
	}

	public int getPuissancemax() {
		return puissancemax;
	}

	public int getPuissancemin() {
		return puissancemin;
	}

	public int getrandom() {
		return random;
	}

	public int getPrioritedef() {
		return prioritedef;
	}

	public void setPrioritedef(int prioritedef) {
		this.prioritedef = prioritedef;
	}

	public int getPrioriteatt() {
		return prioriteatt;
	}

	public void setPrioriteatt(int prioriteatt) {
		this.prioriteatt = prioriteatt;
	}
	
	
	
	
}
