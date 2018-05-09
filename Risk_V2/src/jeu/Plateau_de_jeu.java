package jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import introduction.Windows_intro;



public class Plateau_de_jeu extends JPanel{

	private static final long serialVersionUID = 1L;

	private ImageIcon icoplateau;
	private Image imgplateau;
	
	//constructeur du plateau de jeu
	public Plateau_de_jeu() {
		super();
		icoplateau = new ImageIcon(getClass().getResource("/image/Map.jpg"));
		this.imgplateau = this.icoplateau.getImage();
		this.imgplateau = ScaledImage(imgplateau, 1874, 865);	
	}
	
	
	//methode qui peint les images sur la fenetre 
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgplateau,0,0,null);
	}
	
	
	public Image ScaledImage(Image image , int w, int h) {
		BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = resizedImage.createGraphics();
		graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.drawImage(image,0,0,w,h,null);
		graphics2d.dispose();
		
		return resizedImage;
	}
	
	
	public static void Launch() {
		// création d'une fenêtre pour le jeu
			JFrame Map = new JFrame("Risk");
			
			//definir les caractéristiques de la fenêtre
			Map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Map.setSize(1874, 890);//dimension de la fenêtre
			Map.setLocation(0,0); // position de la fenêtre
			Map.setBackground(Color.WHITE);
			Map.setResizable(false);
			Map.setAlwaysOnTop(false);	
			
			//instancition de l'objet plateau
			Plateau_de_jeu plateau_de_jeu = new Plateau_de_jeu();
			Map.setContentPane(plateau_de_jeu); 
			Map.setVisible(true);			
	}
	
	
}
