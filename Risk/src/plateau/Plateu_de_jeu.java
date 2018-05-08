package plateau;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import souris.*;

public class Plateu_de_jeu extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ImageIcon icobase;
	private Image imgbase;
	
	//constructeur du plateau de jeu
	public Plateu_de_jeu() {
		super();
		icobase = new ImageIcon(getClass().getResource("/image/base.png"));
		this.imgbase = this.icobase.getImage();
		this.imgbase = ScaledImage(imgbase, 1874, 865);			
	}

	//methode qui peint les images sur la fenetre 
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgbase,0,0,null);
	}
	
	
	
	public Image ScaledImage(Image image , int w, int h) {
		BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = resizedImage.createGraphics();
		graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.drawImage(image,0,0,w,h,null);
		graphics2d.dispose();
		
		return resizedImage;
	}
	
	
	public void Launch() {
		// création d'une fenêtre pour le jeu
			JFrame window = new JFrame("Risk");
			
			//definir les caractéristiques de la fenêtre
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setSize(1874, 890);//dimension de la fenêtre
			window.setLocation(0,0); // position de la fenêtre
			window.setBackground(Color.WHITE);
			window.setResizable(true);
			window.setAlwaysOnTop(false);	
			
			
			//instancition de l'objet plateau
			Plateu_de_jeu plateu_de_jeu = new Plateu_de_jeu();
			window.setContentPane(plateu_de_jeu); 
			window.setVisible(true);
			window.getContentPane().addMouseListener(new Mouse_function());
			Mouse_Info_Map mouse_control = new Mouse_Info_Map();
	}
	
}
