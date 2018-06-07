import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Random;

public class Bataille {
	
	public static void main(String[] args) {
		Cavalier cavalier = new Cavalier();
		Tank tank = new Tank();
		Soldat soldat = new Soldat();
		ArrayList<Combattant> arraycombattantattaquant = new ArrayList<Combattant>();
		arraycombattantattaquant.add(tank);
		arraycombattantattaquant.add(tank);
		arraycombattantattaquant.add(soldat);
		ArrayList<Combattant> arraycombattantdefendant = new ArrayList<Combattant>();
		arraycombattantdefendant.add(cavalier);
		arraycombattantdefendant.add(soldat);	
		Champsdebataille champsdebataille = new Champsdebataille();
//		champsdebataille.ListeArmeeAttaque(arraycombattantattaquant);
//		System.out.println(champsdebataille.getArrayalea());
//		champsdebataille.ListeArmeeDefense(arraycombattantdefendant);
		tank.TankFightCavalier(cavalier);
		
	}

}
