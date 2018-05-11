package jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import introduction.Windows_intro;



public class Plateau_de_jeu extends JPanel{

	private static final long serialVersionUID = 1L;

	private ImageIcon icoplateau;
	private Image imgplateau;
	
	private static JButton bouton_fin_tour = new JButton();
	private static ImageIcon icoBoutonfin;
	
	//constructeur du plateau de jeu
	public Plateau_de_jeu() {
		super();
		icoplateau = new ImageIcon(getClass().getResource("/image/Map.jpg"));
		this.imgplateau = this.icoplateau.getImage();
		this.imgplateau = ScaledImage(imgplateau, 1874, 865);	
		
		icoBoutonfin = new ImageIcon(getClass().getResource("/image/bouton_fin_tour.png"));
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
			Map.getContentPane().addMouseListener(new Mouse_info());
			Map.setVisible(true);	
			
			//instantiation du bouton fin du tour
			bouton_fin_tour = new JButton(icoBoutonfin);
			Map.setLayout(null);
			bouton_fin_tour.setOpaque(false);
			bouton_fin_tour.setContentAreaFilled(false);
			bouton_fin_tour.setBorderPainted(false);
			Map.add(bouton_fin_tour);
			bouton_fin_tour.setBounds(750, 750, 280, 90);
			bouton_fin_tour.addMouseListener(new Mouse_function());
	}
	
	
	
	
}
