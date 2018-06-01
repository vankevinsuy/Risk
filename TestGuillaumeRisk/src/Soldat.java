
public class Soldat {
	private int puissancemax = 1;
	private int puissancemin = 6;
	
	
	
	public Soldat() {
		super();
	}
	
	public int getPuissancemax() {
		return puissancemax;
	}
	
	public int getPuissancemin() {
		return puissancemin;
	}
	
	public void SoldatFightCavalier(Cavalier cavalier) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		System.out.println("Puissance soldat attaque = "+alea);
		int aleadef = (int)(Math.random()*(cavalier.getPuissancemax()-cavalier.getPuissancemin()))+cavalier.getPuissancemin();			
		System.out.println("Puissance cavalier defense = "+aleadef);
		  if (alea>aleadef) {
			System.out.println("Attaquant soldat a gagn�");
		}
		  if (alea<=aleadef) {
			System.out.println("Defenseur cavalier a gagn�");
		}
	}
	public void SoldatFightTank(Tank tank) {
		int alea = (int)(Math.random()*(puissancemax-puissancemin))+puissancemin;
		System.out.println("Puissance soldat attaque = "+alea);
		int aleadef = (int)(Math.random()*(tank.getPuissancemax()-tank.getPuissancemin()))+tank.getPuissancemin();			
		System.out.println("Puissance tank defense = "+aleadef);
		  if (alea>aleadef) {
				System.out.println("Attaquant soldat a gagn�");
			}
			  if (alea<=aleadef) {
				System.out.println("Defenseur tank a gagn�");
			}
	}
	
	
	
	
}
