package jeu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Plateau_de_jeu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private ImageIcon icopion;
	private Image imgpion;
	
	private int xposition;
	private int yposition;
	
	Maitre_du_jeu maitre_du_jeu;
	
	public Plateau_de_jeu(Maitre_du_jeu maitre_du_jeu, String name) {
		
		this.maitre_du_jeu= maitre_du_jeu;	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1730, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fond = new JLabel("");
		fond.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xposition = (int) MouseInfo.getPointerInfo().getLocation().getX();
				yposition = (int) MouseInfo.getPointerInfo().getLocation().getY();
				Robot robot = null;
				try {
					robot = new Robot();
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
				Color current_color = robot.getPixelColor(xposition, yposition);

				if (current_color.getRed()==255 && current_color.getGreen()==255 && current_color.getBlue()==255) {
					System.out.println("");
				}
				else {
					Graphics graphics = getGraphics();
					graphics.drawImage(imgpion, (int)e.getX()-15,(int) e.getY()+15, null);
				}
			}
		});
		fond.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/Map2.jpg")));
		fond.setBounds(0, 0, 1730, 860);
		contentPane.add(fond);
		
		JButton btnJouer = new JButton();
		btnJouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (maitre_du_jeu.getNumjoueur_actuel() == maitre_du_jeu.getNombre_de_joueur()) {
					maitre_du_jeu.setNumjoueur_actuel(1);
					System.out.println("Tour de " + name);
				}
				else {
					maitre_du_jeu.setNumjoueur_actuel(maitre_du_jeu.getNumjoueur_actuel() + 1);
					System.out.println("Tour de " + name);
					maitre_du_jeu.setCurrent_player(maitre_du_jeu.getListeJoueur(maitre_du_jeu.getNumjoueur_actuel()));
				}
				
			}
		});
		btnJouer.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/bouton_fin_tour.png")));
		btnJouer.setBounds(1400, 873, 280, 67);
		btnJouer.setOpaque(false);
		btnJouer.setContentAreaFilled(false);
		btnJouer.setBorderPainted(false);
		contentPane.add(btnJouer);
		
		JButton btnSoldat = new JButton("");
		btnSoldat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				icopion = new ImageIcon(getClass().getResource("/image/soldat.png"));
				imgpion = icopion.getImage();
			}
		});
		btnSoldat.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/soldatbtn.png")));
		btnSoldat.setBounds(292, 873, 83, 67);
		contentPane.add(btnSoldat);
		
		JButton btnCavalier = new JButton("");
		btnCavalier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				icopion = new ImageIcon(getClass().getResource("/image/cavalier.png"));
				imgpion = icopion.getImage();
			}
		});
		btnCavalier.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/cavalierbtn.png")));
		btnCavalier.setBounds(486, 873, 83, 67);
		contentPane.add(btnCavalier);
		
		JButton btnTank = new JButton("");
		btnTank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				icopion = new ImageIcon(getClass().getResource("/image/tank.png"));
				imgpion = icopion.getImage();
			}
		});
		btnTank.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/tankbtn.png")));
		btnTank.setBounds(678, 873, 83, 67);
		contentPane.add(btnTank);
		
		setResizable(false);
		setVisible(true);
	}
	
}
