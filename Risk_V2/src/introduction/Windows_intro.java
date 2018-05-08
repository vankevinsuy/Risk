package introduction;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Windows_intro extends JPanel{

	private static final long serialVersionUID = 1L;

	private ImageIcon icobase;
	private Image imgbase;
	
	private ImageIcon icobutton;
	private Image imgbutton;
	
	private JButton bouton = new JButton("Mon premier bouton");

	
	
	//constructeur de la page d'intro
	public Windows_intro() {
		super();
		this.icobase = new ImageIcon(getClass().getResource("/image/intro.jpg"));
		this.imgbase = this.icobase.getImage();
		this.imgbase = ScaledImage(imgbase, 1280, 720);
		
		
		this.icobutton = new ImageIcon(getClass().getResource("/image/bouton_jouer.png"));
		this.imgbutton = this.icobutton.getImage();
		//this.imgbutton = ScaledImage(imgbutton, 200, 100);
	}
	
	
	//methode qui peint les images sur la fenetre 
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgbase,0,0,null);
	}


	private Image ScaledImage(Image image , int w, int h) {
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
			window.setSize(this.imgbase.getWidth(null), this.imgbase.getHeight(null)+20);//dimension de la fenêtre
			window.setLocation(0,0); // position de la fenêtre
			window.setResizable(true);
			window.setBackground(Color.WHITE);
			window.setAlwaysOnTop(false);
			

			//instancition de l'objet plateau
			Windows_intro windows_intro = new Windows_intro();
			window.setContentPane(windows_intro); 
			window.setVisible(true);
			
			//instantiation du bouton
			JButton bouton = new JButton(this.icobutton);
			window.setLayout(null);
			window.add(bouton);
			bouton.setOpaque(false);
			bouton.setContentAreaFilled(false);
			bouton.setBorderPainted(false);
			bouton.setBounds(600, 500, 300, 300);


	}

	
	
	
}
