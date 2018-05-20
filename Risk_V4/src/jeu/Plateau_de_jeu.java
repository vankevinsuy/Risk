package jeu;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Plateau_de_jeu extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private ImageIcon icopion;
	private Image imgpion;
	
	private int xposition;
	private int yposition;
	
	private Joueur current_player;
	
	private Maitre_du_jeu maitre_du_jeu;
	private  ArrayList<Joueur> listeJoueur;
	private  ArrayList<Territoire> listeTerritoire;	
	
	private int index = 0;

	private JButton btnSoldat;
	private JButton btnCavalier;
	private JButton btnTank;
	private JButton btnjouer;


	/**
	 * Create the frame.
	 */
	public Plateau_de_jeu(Maitre_du_jeu maitre_du_jeu, ArrayList<Joueur> listeJoueur , ArrayList<Territoire> listeTerritoire ) {
		this.maitre_du_jeu = maitre_du_jeu;
		this.listeJoueur = listeJoueur;
		this.current_player = listeJoueur.get(this.index);
		this.listeTerritoire = listeTerritoire;
		
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
				
				for (int i = 0; i < listeTerritoire.size(); i++) {
					if (listeTerritoire.get(i).getCouleur_territoire().getRed() == current_color.getRed() && listeTerritoire.get(i).getCouleur_territoire().getGreen() == current_color.getGreen()) {
						System.out.println(listeTerritoire.get(i).getName());
					}
					
					if (listeTerritoire.get(i).getCouleur_territoire().getRed() == current_color.getRed() && listeTerritoire.get(i).getCouleur_territoire().getBlue() == current_color.getBlue()) {
						System.out.println(listeTerritoire.get(i).getName());
					}
					
					if (listeTerritoire.get(i).getCouleur_territoire().getGreen() == current_color.getGreen() && listeTerritoire.get(i).getCouleur_territoire().getBlue() == current_color.getBlue()){
						System.out.println(listeTerritoire.get(i).getName());
					}					
						
				}
				
			}
		});
		fond.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/map_piece/Map.jpg")));
		fond.setBounds(0, 0, 1730, 860);
		contentPane.add(fond);
		
		
		//bouton jouer
		JButton btnJouer = new JButton();
		btnJouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (index == (maitre_du_jeu.getNombre_de_joueur()-1)) {
					index = 0;
					current_player = listeJoueur.get(index);
				}
				else {
					index = index+1;
					current_player = listeJoueur.get(index);
				}
				System.out.println("Tour de : "+current_player.getName());
				ClearBtn_end_round(btnCavalier, btnSoldat, btnTank);
			}
		});
		btnJouer.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/bouton/bouton_jouer.png")));
		btnJouer.setBounds(1400, 873, 280, 67);
		btnJouer.setOpaque(false);
		btnJouer.setContentAreaFilled(false);
		btnJouer.setBorderPainted(false);
		contentPane.add(btnJouer);
		
		
		
		//bouton soldat
		this.btnSoldat = new JButton("");
		btnSoldat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				icopion = new ImageIcon(getClass().getResource(current_player.getIcopionSoldat()));	
				imgpion = icopion.getImage();
				
				btnSoldat.setContentAreaFilled(true);
				btnSoldat.setOpaque(true);
				btnSoldat.setBorderPainted(true);
				btnSoldat.setBackground(current_player.getCouleur_joueur());
				
				ClearButton(btnCavalier,btnTank);
				
				
			}
		});
		this.btnSoldat.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/icone_bouton_game/soldatbtn.png")));
		this.btnSoldat.setBounds(292, 873, 83, 67);
		contentPane.add(this.btnSoldat);
		
		
		//bouton cavalier
		this.btnCavalier = new JButton("");
		this.btnCavalier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				icopion = new ImageIcon(getClass().getResource(current_player.getIcopionCavalier()));
				imgpion = icopion.getImage();
								
				btnCavalier.setContentAreaFilled(true);
				btnCavalier.setOpaque(true);
				btnCavalier.setBorderPainted(true);
				btnCavalier.setBackground(current_player.getCouleur_joueur());

				ClearButton(btnSoldat, btnTank);
			}
		});
		this.btnCavalier.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/icone_bouton_game/cavalierbtn.png")));
		this.btnCavalier.setBounds(486, 873, 83, 67);
		contentPane.add(this.btnCavalier);
		
		
		//bouton tank
		this.btnTank = new JButton("");
		this.btnTank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				icopion = new ImageIcon(getClass().getResource(current_player.getIcopionTank()));
				imgpion = icopion.getImage();
				
				btnTank.setContentAreaFilled(true);
				btnTank.setOpaque(true);
				btnTank.setBorderPainted(true);
				btnTank.setBackground(current_player.getCouleur_joueur());
				
				ClearButton(btnSoldat, btnCavalier);
			}
		});
		this.btnTank.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/icone_bouton_game/tankbtn.png")));
		this.btnTank.setBounds(678, 873, 83, 67);
		contentPane.add(this.btnTank);
		
		
		
		setResizable(false);
		setVisible(true);
	}

	public void ClearButton(JButton btn ,JButton btn2) {
		btn.setContentAreaFilled(false);
		btn.setOpaque(false);
		btn.setBorderPainted(false);
		
		btn2.setContentAreaFilled(false);
		btn2.setOpaque(false);
		btn2.setBorderPainted(false);
	}
	
	public void ClearBtn_end_round(JButton btn ,JButton btn2,JButton btn3) {
		btn.setContentAreaFilled(false);
		btn.setOpaque(false);
		btn.setBorderPainted(false);
		
		btn2.setContentAreaFilled(false);
		btn2.setOpaque(false);
		btn2.setBorderPainted(false);
		
		btn3.setContentAreaFilled(false);
		btn3.setOpaque(false);
		btn3.setBorderPainted(false);

	}

}
