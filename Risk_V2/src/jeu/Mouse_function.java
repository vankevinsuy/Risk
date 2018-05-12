package jeu;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse_function extends MouseAdapter{
	Graphics g;
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if (e.getComponent().getName().toString() == "Plateau_de_jeu") {
			g.drawOval(0, 0, 50, 50);
		    g.fillOval(0, 0, 50, 50);
		    
		}
	}
}
