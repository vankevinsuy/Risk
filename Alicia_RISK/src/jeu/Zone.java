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

		
	private int xpositionCentreSoldat;
	private int ypositionCentreSoldat;
	
	private int xpositionCentreCavalier;
	private int ypositionCentrecavalier;
	
	private int xpositionCentreTank;
	private int ypositionCentreTank;

	private ArrayList<Integer> xList = new ArrayList<Integer>(); //liste qui va permettre de calculer les centres des zones
	private ArrayList<Integer> yList = new ArrayList<Integer>();
	
	public Zone(String nom_du_territoire, int num_zone, Color couleur_zone) {
		super();
		Nom_du_territoire = nom_du_territoire;
		this.num_zone = num_zone;
		this.couleur_zone = couleur_zone;
		CalculateXcentre_Soldat();
		CalculateYcentreSoldat();
		CalculateXcentre_Cavalier();
		CalculateYcentreCavalier();
		CalculateXcentre_Tank();
		CalculateYcentreTank();
		System.out.println(this.Nom_du_territoire +" " + " zone " + this.num_zone + "= " +this.xpositionCentreSoldat + " " + this.ypositionCentreSoldat);
	}
	
	// Calculer le centre de chaque zone pour placer un pions de chaque armée ( soldat, tank, cavalier )
	public void CalculateXcentre_Soldat(){
		BufferedImage image = null;
		File source = new File("src\\image\\map_piece\\Map.png");
		try {
			
			image = ImageIO.read(source);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		for (int x = 0; x< image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
		 		 Color color = new Color(image.getRGB(x, y));
				 int red = color.getRed();
				 int green = color.getGreen();
				 int blue = color.getBlue();
				if (red ==(int)this.couleur_zone.getRed() && green == (int)this.couleur_zone.getGreen() && blue == (int)this.couleur_zone.getBlue()) {
					xList.add(x);
				}
			}
		}
		for (int i = 0; i < xList.size(); i++) {
			this.xpositionCentreSoldat = this.xpositionCentreSoldat + xList.get(i);			
		}
		this.xpositionCentreSoldat = this.xpositionCentreSoldat/xList.size();	
	}
	
	

	public void CalculateYcentreSoldat(){
		BufferedImage image = null;
		File source = new File("src\\image\\map_piece\\Map.png");
		try {
			
			image = ImageIO.read(source);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		for (int x = 0; x< image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
		 		 Color color = new Color(image.getRGB(x, y));
				 int red = color.getRed();
				 int green = color.getGreen();
				 int blue = color.getBlue();
				if (red ==(int)this.couleur_zone.getRed() && green == (int)this.couleur_zone.getGreen() && blue == (int)this.couleur_zone.getBlue()) {
					yList.add(y);
				}
			}
		}
		for (int i = 0; i < yList.size(); i++) {
			if (yList.size() == 0) {
				System.out.println("p");
			}
			else {
				this.ypositionCentreSoldat = this.ypositionCentreSoldat + yList.get(i);
			}
			
		}
		this.ypositionCentreSoldat = this.ypositionCentreSoldat/yList.size();	
	}
	
	
	public void CalculateXcentre_Cavalier(){
		this.xpositionCentreCavalier = this.xpositionCentreSoldat - 20;
	}
	
	
	public void CalculateYcentreCavalier(){
		this.ypositionCentrecavalier = this.ypositionCentreSoldat +20;
	}
	
	
	
	public void CalculateXcentre_Tank(){
		this.xpositionCentreTank = this.xpositionCentreSoldat +20;
	}
	
	
	
	public void CalculateYcentreTank(){
		this.ypositionCentreTank = this.ypositionCentreSoldat+20;
	}
	
	
	
	public String getNom_du_territoire() {
		return Nom_du_territoire;
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


	public int getXpositionCentreSoldat() {
		return xpositionCentreSoldat;
	}


	public int getYpositionCentreSoldat() {
		return ypositionCentreSoldat;
	}

	public void setXpositionCentreSoldat(int xpositionCentreSoldat) {
		this.xpositionCentreSoldat = xpositionCentreSoldat;
	}

	public void setYpositionCentreSoldat(int ypositionCentreSoldat) {
		this.ypositionCentreSoldat = ypositionCentreSoldat;
	}

	public void setXpositionCentreCavalier(int xpositionCentreCavalier) {
		this.xpositionCentreCavalier = xpositionCentreCavalier;
	}

	public void setYpositionCentrecavalier(int ypositionCentrecavalier) {
		this.ypositionCentrecavalier = ypositionCentrecavalier;
	}

	public void setXpositionCentreTank(int xpositionCentreTank) {
		this.xpositionCentreTank = xpositionCentreTank;
	}

	public void setYpositionCentreTank(int ypositionCentreTank) {
		this.ypositionCentreTank = ypositionCentreTank;
	}

	public int getXpositionCentreCavalier() {
		return xpositionCentreCavalier;
	}

	public int getYpositionCentrecavalier() {
		return ypositionCentrecavalier;
	}

	public int getYpositionCentreTank() {
		return ypositionCentreTank;
	}

	public int getXpositionCentreTank() {
		return xpositionCentreTank;
	}
}