package jeu;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse_info extends MouseAdapter{
	
	private int xposition;
	private int yposition;
	
	private final int[] couleur_Asie = {227,183,78};
	private final int[] couleur_Afrique = {170,25,90};
	private final int[] couleur_Amerique_du_nord = {151,206,78};
	private final int[] couleur_Amerique_du_sud = {85,182,89};
	private final int[] couleur_Europe = {139,149,246};
	private final int[] couleur_Oceanie = {242,118,118};
	
	private int[] num_zone = {1,2,3,4,5,6,7};

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		this.xposition = (int) MouseInfo.getPointerInfo().getLocation().getX();
		this.yposition = (int) MouseInfo.getPointerInfo().getLocation().getY();
		Check_zone();
	}
	
	
	public void Check_zone() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		Color current_color = robot.getPixelColor(this.xposition, this.yposition);
//		System.out.println(current_color);
		
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
