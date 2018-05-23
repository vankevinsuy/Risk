package jeu;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	
	private String current_pion;

	private boolean btn_actif = false;
	private JTable table;

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
		contentPane.setBackground(Color.WHITE);
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
				
				//si on clique dans le vide on saute une ligne dans la console
				if (current_color.getRed()==255 && current_color.getGreen()==255 && current_color.getBlue()==255) {
					System.out.println("");
				}
				else {
					CheckLocation(xposition, yposition);
				}

			}
		});
		fond.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/map_piece/Map.png")));
		fond.setBounds(12, 0, 1700, 815);
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
				btn_actif = false;
//				current_player.ResetRound();
				current_pion = null;
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
	
				icopion = new ImageIcon(getClass().getResource(current_player.getCheminicopionSoldat()));	
				imgpion = icopion.getImage();			
				
				btnSoldat.setContentAreaFilled(true);
				btnSoldat.setOpaque(true);
				btnSoldat.setBorderPainted(true);
				btnSoldat.setBackground(current_player.getCouleur_joueur());
				
				ClearButton(btnCavalier,btnTank);
				btn_actif = true;
				current_pion = "soldat";
				
			}
		});
		this.btnSoldat.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/icone_bouton_game/soldatbtn.png")));
		this.btnSoldat.setBounds(79, 873, 83, 67);
		contentPane.add(this.btnSoldat);
		
		
		//bouton cavalier
		this.btnCavalier = new JButton("");
		this.btnCavalier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				icopion = new ImageIcon(getClass().getResource(current_player.getCheminicopionCavalier()));
				imgpion = icopion.getImage();
								
				btnCavalier.setContentAreaFilled(true);
				btnCavalier.setOpaque(true);
				btnCavalier.setBorderPainted(true);
				btnCavalier.setBackground(current_player.getCouleur_joueur());

				ClearButton(btnSoldat, btnTank);
				btn_actif = true;
				current_pion = "cavalier";
			}
		});
		this.btnCavalier.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/icone_bouton_game/cavalierbtn.png")));
		this.btnCavalier.setBounds(252, 873, 83, 67);
		contentPane.add(this.btnCavalier);
		
		
		//bouton tank
		this.btnTank = new JButton("");
		this.btnTank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				icopion = new ImageIcon(getClass().getResource(current_player.getCheminicopionTank()));
				imgpion = icopion.getImage();
				
				btnTank.setContentAreaFilled(true);
				btnTank.setOpaque(true);
				btnTank.setBorderPainted(true);
				btnTank.setBackground(current_player.getCouleur_joueur());
				
				ClearButton(btnSoldat, btnCavalier);
				btn_actif = true;
				current_pion = "tank";
			}
		});
		this.btnTank.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/icone_bouton_game/tankbtn.png")));
		this.btnTank.setBounds(410, 873, 83, 67);
		contentPane.add(this.btnTank);
		
		
		//tableau avec les informations du joueur
		table = new JTable();
		table.setBounds(554, 828, 834, 112);
		contentPane.add(table);
		table.setBackground(Color.WHITE);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
				{"Asie", null, null, null, null, null, null, null},
				{"Afrique", null, null, null, null, null, null, null},
				{"Am\u00E9rique du sud", null, null, null, null, null, null, null},
				{"Am\u00E9rique du nord", null, null, null, null, null, null, null},
				{"Europe", null, null, null, null, null, null, null},
				{"Oc\u00E9anie", null, null, null, null, null, null, null},
			},
			new String[] {
				"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
			}
		) {

			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(121);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);
		
		
		
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
	
	public void CheckLocation(int x , int y) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
		Color current_color = robot.getPixelColor(x, y);
		if (btn_actif == true) {
						for (int i = 0; i < listeTerritoire.size(); i++) {
				//clique sur Europe
				for (int j = 0; j < 7; j++) {
					for (int k = 0; k < 7; k++) {
						if (listeTerritoire.get(i).getCouleur_primaire_territoire1()+j == current_color.getRed() && listeTerritoire.get(i).getCouleur_primaire_territoire2()+k == current_color.getGreen()) {
							for (int l= 0; l < listeTerritoire.get(i).getListe_zone_possible().size() ; l++) {
								if (listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone().getBlue() == current_color.getBlue()) {
									System.out.println(listeTerritoire.get(i).getName() + " zone : " + listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone());
									
									if (current_pion == "soldat") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreSoldat(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentreSoldat(), null);	

									}
									
									if (current_pion == "cavalier") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreCavalier(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentrecavalier(), null);	

									}
									
									if (current_pion == "tank") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreTank(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentreTank(), null);	

									}
									
								}
							}
						}
					}
					
				}
				
				// clique sur Asie et Amerique du sud
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < 2; k++) {
						if (listeTerritoire.get(i).getCouleur_primaire_territoire1()+j == current_color.getRed() && listeTerritoire.get(i).getCouleur_primaire_territoire2()+k == current_color.getBlue()){
							for (int l= 0; l < listeTerritoire.get(i).getListe_zone_possible().size() ; l++) {
								if (listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone().getGreen() == current_color.getGreen()) {
									System.out.println(listeTerritoire.get(i).getName() + " zone : " + listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone());
									
									if (current_pion == "soldat") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreSoldat(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentreSoldat(), null);	

									}
									
									if (current_pion == "cavalier") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreCavalier(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentrecavalier(), null);	

									}
									
									if (current_pion == "tank") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreTank(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentreTank(), null);	

									}
								}
							}
							
						}
					}
				}
				
				//clique sur Afrique, Océanie et Amérique du nord
				for (int j = 0; j < 7; j++) {
					for (int k = 0; k < 7; k++) {
						if (listeTerritoire.get(i).getCouleur_primaire_territoire1()+j == current_color.getGreen() && listeTerritoire.get(i).getCouleur_primaire_territoire2()+k == current_color.getBlue()){
							for (int l= 0; l < listeTerritoire.get(i).getListe_zone_possible().size() ; l++) {
								if (listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone().getRed() == current_color.getRed()) {
									System.out.println(listeTerritoire.get(i).getName() + " zone : " + listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone());
									
									if (current_pion == "soldat") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreSoldat(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentreSoldat(), null);	

									}
									
									if (current_pion == "cavalier") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreCavalier(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentrecavalier(), null);	

									}
									
									if (current_pion == "tank") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreTank(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentreTank(), null);	

									}
								}
							}
						}	
					}
				}	
			}
		}

	}
}
