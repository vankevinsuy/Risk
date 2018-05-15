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
	
	public static JFrame window = new JFrame("Risk");
	
	public static JButton boutonmain = new JButton();
	public static JButton bouton_2joueurs = new JButton();
	public static JButton bouton_3joueurs = new JButton();
	public static JButton bouton_4joueurs = new JButton();
	public static JButton bouton_5joueurs = new JButton();
	public static JButton bouton_6joueurs = new JButton();

	private ImageIcon icoboutonjouer2 ;
	private ImageIcon icoboutonjouer3 ;
	private ImageIcon icoboutonjouer4 ;
	private ImageIcon icoboutonjouer5 ;
	private ImageIcon icoboutonjouer6 ;
	
	public static int nombre_de_joueur;
	
	//constructeur de la page d'intro
	public Windows_intro() {
		super();
		this.icobase = new ImageIcon(getClass().getResource("/image/intro.jpg"));
		this.imgbase = this.icobase.getImage();
		this.imgbase = ScaledImage(imgbase, 1280, 720);
		
		this.icobutton = new ImageIcon(getClass().getResource("/image/bouton_jouer.png"));
		
		this.icoboutonjouer2 = new ImageIcon(getClass().getResource("/image/bouton_2joueurs.png"));
		this.icoboutonjouer3 = new ImageIcon(getClass().getResource("/image/bouton_3joueurs.png"));
		this.icoboutonjouer4 = new ImageIcon(getClass().getResource("/image/bouton_4joueurs.png"));
		this.icoboutonjouer5 = new ImageIcon(getClass().getResource("/image/bouton_5joueurs.png"));
		this.icoboutonjouer6 = new ImageIcon(getClass().getResource("/image/bouton_6joueurs.png"));
		
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
			
			//definir les caractéristiques de la fenêtre
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window.setSize(this.imgbase.getWidth(null), this.imgbase.getHeight(null)+20);//dimension de la fenêtre
			window.setLocation(0,0); // position de la fenêtre
			window.setResizable(false);
			window.setBackground(Color.WHITE);
			window.setAlwaysOnTop(false);
			

			//instantiation de l'objet plateau
			Windows_intro windows_intro = new Windows_intro();
			window.setContentPane(windows_intro); 
			window.setVisible(true);
			
			//instantiation du bouton "jouer"
			boutonmain = new JButton(this.icobutton);
			window.setLayout(null);
			boutonmain.setName("bouton_jouer");
			window.add(boutonmain);
			boutonmain.setOpaque(false);
			boutonmain.setContentAreaFilled(false);
			boutonmain.setBorderPainted(false);
			boutonmain.setBounds(500, 570, 280, 90);
			boutonmain.addMouseListener(new Mouse_control());
			
			
			//instantiation du bouton "2joueurs"
			bouton_2joueurs = new JButton(this.icoboutonjouer2);
			window.setLayout(null);
			bouton_2joueurs.setName("bouton_2joueurs");
			window.add(bouton_2joueurs);
			bouton_2joueurs.setOpaque(false);
			bouton_2joueurs.setContentAreaFilled(false);
			bouton_2joueurs.setBorderPainted(false);
			bouton_2joueurs.setBounds(50, 300, 280, 90);
			bouton_2joueurs.addMouseListener(new Mouse_control());
			
			//instantiation du bouton "3joueurs"
			bouton_3joueurs = new JButton(this.icoboutonjouer3);
			window.setLayout(null);
			bouton_3joueurs.setName("bouton_3joueurs");
			window.add(bouton_3joueurs);
			bouton_3joueurs.setOpaque(false);
			bouton_3joueurs.setContentAreaFilled(false);
			bouton_3joueurs.setBorderPainted(false);
			bouton_3joueurs.setBounds(350, 300, 280, 90);
			bouton_3joueurs.addMouseListener(new Mouse_control());
			
			
			//instantiation du bouton "4joueurs"
			bouton_4joueurs = new JButton(this.icoboutonjouer4);
			window.setLayout(null);
			bouton_4joueurs.setName("bouton_4joueurs");
			window.add(bouton_4joueurs);
			bouton_4joueurs.setOpaque(false);
			bouton_4joueurs.setContentAreaFilled(false);
			bouton_4joueurs.setBorderPainted(false);
			bouton_4joueurs.setBounds(650, 300, 280, 90);
			bouton_4joueurs.addMouseListener(new Mouse_control());
			
			
			//instantiation du bouton "5joueurs"
			bouton_5joueurs = new JButton(this.icoboutonjouer5);
			window.setLayout(null);
			bouton_5joueurs.setName("bouton_5joueurs");
			window.add(bouton_5joueurs);
			bouton_5joueurs.setOpaque(false);
			bouton_5joueurs.setContentAreaFilled(false);
			bouton_5joueurs.setBorderPainted(false);
			bouton_5joueurs.setBounds(950, 300, 280, 90);
			bouton_5joueurs.addMouseListener(new Mouse_control());
			
			
			//instantiation du bouton "6joueurs"
			bouton_6joueurs = new JButton(this.icoboutonjouer6);
			window.setLayout(null);
			bouton_6joueurs.setName("bouton_6joueurs");
			window.add(bouton_6joueurs);
			bouton_6joueurs.setOpaque(false);
			bouton_6joueurs.setContentAreaFilled(false);
			bouton_6joueurs.setBorderPainted(false);
			bouton_6joueurs.setBounds(500, 430, 280, 90);
			bouton_6joueurs.addMouseListener(new Mouse_control());
			
	}
	


}
