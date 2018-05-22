package jeu;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Zone {
 
	private String Nom_du_territoire;
	private int num_zone;
	private Color couleur_zone;
	private ArrayList<Integer> xList; //liste qui va permettre de calculer les centres des zones
	private ArrayList<Integer> yList;
	private ImageIcon icon;
		
	private int xpositionCentre;
	private int ypositionCentre;

	
	
	public Zone(String nom_du_territoire, int num_zone, Color couleur_zone) throws IOException {
		super();
		Nom_du_territoire = nom_du_territoire;
		this.num_zone = num_zone;
		this.couleur_zone = couleur_zone;
		this.icon = new ImageIcon(getClass().getResource("/image/Map.png"));
		CalculateXcentre();
		CalculateYcentre();
	}
	
	
	private void CalculateXcentre() throws IOException {
		 File file= new File("C:\\Users\\vanke\\Desktop\\codeJava\\Frame\\src\\image\\Map.png");
		 BufferedImage image = ImageIO.read(file);

		for (int x = 0; x< this.icon.getIconWidth(); x++) {
			for (int y = 0; y < this.icon.getIconHeight(); y++) {
				 int clr=  image.getRGB(x,y);		  
				 int  red   = (clr & 0x00ff0000) >> 16;
				 int  green = (clr & 0x0000ff00) >> 8;
				 int  blue  =  clr & 0x000000ff;
				if (red ==(int)this.couleur_zone.getRed() && green == (int)this.couleur_zone.getGreen() && blue == (int)this.couleur_zone.getBlue()) {
					this.xList.add(x);
				}
			}
		}
		for (int i = 0; i < this.xList.size(); i++) {
			this.xpositionCentre = this.xpositionCentre + this.xList.get(i);
		}
		this.xpositionCentre = this.xpositionCentre/this.xList.size();	
	}
	

	private void CalculateYcentre() throws IOException {
		 File file= new File("C:\\Users\\vanke\\Desktop\\codeJava\\Frame\\src\\image\\Map.png");
		 BufferedImage image = ImageIO.read(file);

		for (int x = 0; x< this.icon.getIconWidth(); x++) {
			for (int y = 0; y < this.icon.getIconHeight(); y++) {
				 int clr=  image.getRGB(x,y);		  
				 int  red   = (clr & 0x00ff0000) >> 16;
				 int  green = (clr & 0x0000ff00) >> 8;
				 int  blue  =  clr & 0x000000ff;
				if (red ==(int)this.couleur_zone.getRed() && green == (int)this.couleur_zone.getGreen() && blue == (int)this.couleur_zone.getBlue()) {
					this.yList.add(y);
				}
			}
		}
		for (int i = 0; i < this.yList.size(); i++) {
			this.ypositionCentre = this.ypositionCentre + this.yList.get(i);
		}
		this.ypositionCentre = this.ypositionCentre/this.yList.size();	
	}
	
	public String getNom_du_territoire() {
		return Nom_du_territoire;
	}


	public void setNom_du_territoire(String nom_du_territoire) {
		Nom_du_territoire = nom_du_territoire;
	}


	public int getNum_zone() {
		return num_zone;
	}


	public void setNum_zone(int num_zone) {
		this.num_zone = num_zone;
	}


	public Color getCouleur_zone() {
		return couleur_zone;
	}


	public int getXpositionCentre() {
		return xpositionCentre;
	}


	public int getYpositionCentre() {
		return ypositionCentre;
	}
}