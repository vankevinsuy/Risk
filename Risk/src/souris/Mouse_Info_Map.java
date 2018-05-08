package souris;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse_Info_Map extends MouseAdapter{
	
	private int xposition;
	private int yposition;
	
	private final int[] couleur_Asie = {255,240,0};
	private final int[] couleur_Afrique = {255,0,6};
	private final int[] couleur_Amerique_du_nord = {31,131,52};
	private final int[] couleur_Amerique_du_sud = {49,225,45};
	private final int[] couleur_Europe = {7,120,225};
	private final int[] couleur_Oceanie = {0,186,255};

	public Mouse_Info_Map() {
		super();
		while(true) {
		this.xposition = (int) MouseInfo.getPointerInfo().getLocation().getX();
		this.yposition = (int) MouseInfo.getPointerInfo().getLocation().getY();
		
			try {
				Thread.sleep(100);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			Check_country();
		}
		
	}
	
	
	public void Check_country() {
		
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
        Color current_color = robot.getPixelColor(this.xposition, this.yposition);
        //System.out.println(current_color);
		
        if (current_color.getRed() == couleur_Asie[0]) {
			if (current_color.getGreen() == couleur_Asie[1]) {
				if (current_color.getBlue() == couleur_Asie[2]) {
					System.out.println("Asie");
				}
			}
		}
        
        if (current_color.getRed() == couleur_Afrique[0]) {
			if (current_color.getGreen() == couleur_Afrique[1]) {
				if (current_color.getBlue() == couleur_Afrique[2]) {
					System.out.println("Afrique");
				}
			}
		}
        
        
        if (current_color.getRed() == couleur_Amerique_du_nord[0]) {
			if (current_color.getGreen() == couleur_Amerique_du_nord[1]) {
				if (current_color.getBlue() == couleur_Amerique_du_nord[2]) {
					System.out.println("Amerique du nord");
				}
			}
		}
        
        
        if (current_color.getRed() == couleur_Amerique_du_sud[0]) {
			if (current_color.getGreen() == couleur_Amerique_du_sud[1]) {
				if (current_color.getBlue() == couleur_Amerique_du_sud[2]) {
					System.out.println("Amerique du sud");
				}
			}
		}
        
        
        if (current_color.getRed() == couleur_Europe[0]) {
			if (current_color.getGreen() == couleur_Europe[1]) {
				if (current_color.getBlue() == couleur_Europe[2]) {
					System.out.println("Europe");
				}
			}
		}
        
        
        if (current_color.getRed() == couleur_Oceanie[0]) {
			if (current_color.getGreen() == couleur_Oceanie[1]) {
				if (current_color.getBlue() == couleur_Oceanie[2]) {
					System.out.println("Oceanie");
				}
			}
		}

	}
	
	





}