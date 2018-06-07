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

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
	
	private int tour = 1; // 1) initialisation + poser les premiers pions   2) et plus attaque et déplacement
	private int index = 0;

	private JButton btnSoldat;
	private JButton btnCavalier;
	private JButton btnTank;
	private JButton btnjouer;
	
	private String current_pion;

	private boolean btn_actif_soldat = false;
	private boolean btn_actif_cavalier = false;
	private boolean btn_actif_tank = false;
	private JTable table;
	private JLabel current_player_displyed_info;
	private JLabel lblnb_reste_cavalier;
	private JLabel lblnb_reste_tank;
	private JLabel lblnb_reste_soldat;
	private JLabel lblmove_ou_attack;

	private JSlider sliderSoldat;
	private JSlider slider_Cavalier;
	private JSlider slider_Tank;

	private JLabel NbSoldatdeplacerlbl;
	private JLabel lblNombreDeCavalier;
	private JLabel NbCavalierAdeplacer;

	private ArrayList<Pion_soldat> listePionAttaquantSoldat;
	private ArrayList<Pion_Cavalier> listePionAttaquantCavalier;
	private ArrayList<Pion_Tank> listePionAttaquantTank;
	
	private ArrayList<Pion_soldat> listePionDefenseurSoldat;
	private ArrayList<Pion_Cavalier> listePionDefenseurCavalier;
	private ArrayList<Pion_Tank> listePionDefenseurTank;
	private boolean Defense;
	

	/**
	 * Create the frame.
	 */
	public Plateau_de_jeu(Maitre_du_jeu maitre_du_jeu, ArrayList<Joueur> listeJoueur , ArrayList<Territoire> listeTerritoire ) {
		setResizable(false);
		this.maitre_du_jeu = maitre_du_jeu;
		this.listeJoueur = listeJoueur;
		this.current_player = listeJoueur.get(this.index);
		this.listeTerritoire = listeTerritoire;
		this.tour = 1;
		this.listePionAttaquantSoldat = new ArrayList<Pion_soldat>();
		this.listePionAttaquantCavalier = new ArrayList<Pion_Cavalier>();
		this.listePionAttaquantTank = new ArrayList<Pion_Tank>();
		
		this.listePionDefenseurSoldat = new ArrayList<Pion_soldat>();
		this.listePionDefenseurCavalier = new ArrayList<Pion_Cavalier>();
		this.listePionDefenseurTank  = new ArrayList<Pion_Tank>();
		this.Defense = false;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1900, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel fond = new JLabel("");
		fond.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/map_piece/Map.png")));
		fond.setBounds(12, 0, 1700, 815);
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
					Defense = false;
					DrawAllPion();
				}
				else {
					
					
					
					table.setModel(new DefaultTableModel(
							new Object[][] {
								{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
								{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
								{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
								{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
								{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
								{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
								{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
							},
							new String[] {
								"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
							}));
					
					
					
					if (current_player.getArmee() == 0 && tour>=maitre_du_jeu.getNombre_de_joueur()) {
						btn_actif_soldat = false;
						btn_actif_cavalier = false;
						btn_actif_tank =false;
						DrawAllPion();
						Attaque(xposition, yposition);
						current_player_displyed_info.setText("Attaque de "+ current_player.getName());

					}
					else {
						if (CanIplay(xposition, yposition) == true) {
							DrawAllPion();
							PlacerPion(xposition, yposition);
							if (current_player.getArmee()-7 < 0) {
								btnTank.setEnabled(false);
								btn_actif_tank = false;
								imgpion = null;
								lblnb_reste_tank.setText("0");
								
								
							}
	
							
							if (current_player.getArmee()-1< 0) {
								btnSoldat.setEnabled(false);
								btn_actif_soldat = false;
								imgpion = null;
								lblnb_reste_soldat.setText("0");
								
							}
	
							
							if (current_player.getArmee()-3< 0) {
								btnCavalier.setEnabled(false);
								btn_actif_cavalier = false;
								lblnb_reste_cavalier.setText("0");
								
							}
						}
						else {
							System.out.println("choisir une autre zone");
						}
						
					}
				}

			}
		});
		
		//bouton de effacer les pions
		JButton btnNewButton = new JButton("Effacer les pions");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fond.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/map_piece/Map.png")));
				System.out.println("refresh");
			}
		});
		
		JLabel lblNombreDeTank = new JLabel("Nombre de tank \u00E0 d\u00E9placer : ");
		lblNombreDeTank.setBounds(1508, 181, 197, 26);
		contentPane.add(lblNombreDeTank);
		
		NbCavalierAdeplacer = new JLabel("");
		NbCavalierAdeplacer.setBounds(1717, 122, 26, 26);
		contentPane.add(NbCavalierAdeplacer);
		
		JLabel NbTankAdeplacer = new JLabel("");
		NbTankAdeplacer.setBounds(1717, 181, 26, 26);
		contentPane.add(NbTankAdeplacer);
		
		lblNombreDeCavalier = new JLabel("Nombre de cavalier \u00E0 d\u00E9placer : ");
		lblNombreDeCavalier.setBounds(1508, 122, 197, 26);
		contentPane.add(lblNombreDeCavalier);
		
		lblmove_ou_attack = new JLabel("");
		lblmove_ou_attack.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblmove_ou_attack.setBounds(889, 657, 442, 67);
		contentPane.add(lblmove_ou_attack);
		
		NbSoldatdeplacerlbl = new JLabel("Nombre de soldats \u00E0 d\u00E9placer : ");
		NbSoldatdeplacerlbl.setBounds(1508, 69, 197, 26);
		contentPane.add(NbSoldatdeplacerlbl);
		
		JLabel NbSoldatAdeplacer = new JLabel("");
		NbSoldatAdeplacer.setBounds(1717, 69, 26, 26);
		contentPane.add(NbSoldatAdeplacer);
		
		sliderSoldat = new JSlider();
		sliderSoldat.setValue(0);
		sliderSoldat.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				NbSoldatAdeplacer.setText(Integer.toString(sliderSoldat.getValue()));
			}
		});		
		sliderSoldat.setBounds(1755, 69, 127, 26);
		sliderSoldat.setEnabled(false);
		contentPane.add(sliderSoldat);
		
		current_player_displyed_info = new JLabel("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
		current_player_displyed_info.setFont(new Font("Tahoma", Font.PLAIN, 21));
		current_player_displyed_info.setBounds(554, 723, 701, 67);
		contentPane.add(current_player_displyed_info);
		btnNewButton.setBounds(1400, 818, 138, 25);
		contentPane.add(btnNewButton);

		contentPane.add(fond);
		

							
		lblnb_reste_cavalier = new JLabel(Integer.toString(current_player.getArmee()/3));
		lblnb_reste_cavalier.setBounds(252, 827, 56, 16);
		contentPane.add(lblnb_reste_cavalier);
		
		lblnb_reste_tank = new JLabel(Integer.toString(current_player.getArmee()/7));
		lblnb_reste_tank.setBounds(410, 827, 56, 16);
		contentPane.add(lblnb_reste_tank);
		
		lblnb_reste_soldat = new JLabel(Integer.toString(current_player.getArmee()));
		lblnb_reste_soldat.setBounds(92, 827, 56, 16);
		contentPane.add(lblnb_reste_soldat);

		icopion = new ImageIcon(getClass().getResource(current_player.getCheminicopionSoldat()));	
		imgpion = icopion.getImage();
		
		
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
				btn_actif_cavalier = false;
				btn_actif_soldat = false;
				btn_actif_tank = false;
				ResetRound();
				current_pion = null;
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
							{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
							{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
							{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
							{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
							{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
							{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
						},
						new String[] {
							"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
						}));
				current_player.setArmee(Plateau_de_jeu.this.maitre_du_jeu.getArmeeeDeDepartinit());
				lblnb_reste_soldat.setText(Integer.toString(current_player.getArmee()));
				lblnb_reste_cavalier.setText(Integer.toString(current_player.getArmee()/3));
				lblnb_reste_tank.setText(Integer.toString(current_player.getArmee()/7));
				current_player.setArmee(Plateau_de_jeu.this.maitre_du_jeu.getArmeeDeDepart());
				current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
				tour = tour + 1;
				System.out.println(tour);
			}
		});
		btnJouer.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/bouton/bouton_fin_tour.png")));
		btnJouer.setBounds(1400, 873, 280, 67);
		btnJouer.setOpaque(false);
		btnJouer.setContentAreaFilled(false);
		btnJouer.setBorderPainted(false);
		lblmove_ou_attack.setText("");
		System.out.println(this.tour);
		System.out.println(maitre_du_jeu.getNombre_de_joueur());
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
				btn_actif_soldat = true;
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
				btn_actif_cavalier = true;
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
				btn_actif_tank = true;
				current_pion = "tank";
			}
		});
		this.btnTank.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/icone_bouton_game/tankbtn.png")));
		this.btnTank.setBounds(410, 873, 83, 67);
		contentPane.add(this.btnTank);
		
		
		//tableau avec les informations du joueur
		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setBounds(554, 828, 834, 112);
		contentPane.add(table);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
					{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
					{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
					{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
					{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
					{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
					{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
				},
				new String[] {
					"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
				}));
		
		slider_Cavalier = new JSlider();
		slider_Cavalier.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				NbCavalierAdeplacer.setText(Integer.toString(slider_Cavalier.getValue()));
			}
		});
		slider_Cavalier.setValue(0);
		slider_Cavalier.setEnabled(false);
		slider_Cavalier.setBounds(1755, 122, 127, 26);
		contentPane.add(slider_Cavalier);
		
		slider_Tank = new JSlider();
		slider_Tank.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				NbTankAdeplacer.setText(Integer.toString(slider_Tank.getValue()));
			}
		});
		slider_Tank.setValue(0);
		slider_Tank.setEnabled(false);
		slider_Tank.setBounds(1755, 181, 127, 26);
		contentPane.add(slider_Tank);
		
		JButton btnDessinerLesPions = new JButton("Dessiner les pions");
		btnDessinerLesPions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DrawAllPion();
			}
		});
		btnDessinerLesPions.setBounds(1566, 818, 146, 25);
		contentPane.add(btnDessinerLesPions);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(121);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);
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
	
	public void PlacerPion(int x , int y) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
		Color current_color = robot.getPixelColor(x, y);
		if (btn_actif_cavalier == true  || btn_actif_soldat == true || btn_actif_tank == true) {
			for (int i = 0; i < listeTerritoire.size(); i++) {
				//clique sur Europe
				for (int j = 0; j < 7; j++) {
					for (int k = 0; k < 7; k++) {
						if (listeTerritoire.get(i).getCouleur_primaire_territoire1()+j == current_color.getRed() && listeTerritoire.get(i).getCouleur_primaire_territoire2()+k == current_color.getGreen()) {
							for (int l= 0; l < listeTerritoire.get(i).getListe_zone_possible().size() ; l++) {
								if (listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone().getBlue() == current_color.getBlue()) {
									// System.out.println(listeTerritoire.get(i).getName() + " zone : " +
									// listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone());
									
									if (current_pion == "soldat") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreSoldat(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentreSoldat(), null);	
										
										current_player.Add_Soldat(1, new Pion_soldat(current_player.getCheminicopionSoldat(), new Zone(listeTerritoire.get(i).getName(), listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone(), listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone())));
//										System.out.println(current_player.getListe_de_pion_soldat().size());
										table.setModel(new DefaultTableModel(
												new Object[][] {
													{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
													{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
													{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
													{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
													{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
													{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
													{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
												},
												new String[] {
													"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
												}));
										
										current_player.setArmee(current_player.getArmee() - 1);
										lblnb_reste_soldat.setText(Integer.toString(current_player.getArmee()));
										lblnb_reste_cavalier.setText(Integer.toString(current_player.getArmee()/3));
										lblnb_reste_tank.setText((Integer.toString(current_player.getArmee()/7)));
										if (current_player.getArmee() == 0 && tour>=maitre_du_jeu.getNombre_de_joueur()) {
											current_player_displyed_info.setText("Pour passer en phase d'attaque cliquez sur la carte");
										}
										else {
											current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										}
									}
									
									if (current_pion == "cavalier") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreCavalier(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentrecavalier(), null);	
										
										current_player.AddCavalier(1, new Pion_Cavalier(current_player.getCheminicopionCavalier(), new Zone(listeTerritoire.get(i).getName(), listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone(), listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone())));
										table.setModel(new DefaultTableModel(
												new Object[][] {
													{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
													{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
													{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
													{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
													{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
													{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
													{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
												},
												new String[] {
													"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
												}));
										current_player.setArmee(current_player.getArmee() - 3);
										lblnb_reste_soldat.setText(Integer.toString(current_player.getArmee()));
										
										lblnb_reste_cavalier.setText(Integer.toString(current_player.getArmee()/3));
										
										lblnb_reste_tank.setText((Integer.toString(current_player.getArmee()/7)));
										
										current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										if (current_player.getArmee() == 0 && tour>=maitre_du_jeu.getNombre_de_joueur()) {
											current_player_displyed_info.setText("Pour passer en phase d'attaque cliquez sur la carte");
										}
										else {
											current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										}
									}
									
									if (current_pion == "tank") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreTank(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentreTank(), null);	
										
										current_player.AddTank(1, new Pion_Tank(current_player.getCheminicopionTank(), new Zone(listeTerritoire.get(i).getName(), listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone(), listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone())));
										table.setModel(new DefaultTableModel(
												new Object[][] {
													{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
													{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
													{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
													{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
													{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
													{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
													{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
												},
												new String[] {
													"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
												}));
										current_player.setArmee(current_player.getArmee() - 7);
										lblnb_reste_soldat.setText(Integer.toString(current_player.getArmee()));
										
										lblnb_reste_cavalier.setText(Integer.toString(current_player.getArmee()/3));
										
										lblnb_reste_tank.setText((Integer.toString(current_player.getArmee()/7)));
										
										current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										if (current_player.getArmee() == 0 && tour>=maitre_du_jeu.getNombre_de_joueur()) {
											current_player_displyed_info.setText("Pour passer en phase d'attaque cliquez sur la carte");
										}
										else {
											current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										}
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
										
										current_player.Add_Soldat(1, new Pion_soldat(current_player.getCheminicopionSoldat(), new Zone(listeTerritoire.get(i).getName(), listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone(), listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone())));
										table.setModel(new DefaultTableModel(
												new Object[][] {
													{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
													{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
													{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
													{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
													{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
													{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
													{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
												},
												new String[] {
													"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
												}));
										current_player.setArmee(current_player.getArmee() - 1);
										lblnb_reste_soldat.setText(Integer.toString(current_player.getArmee()));
										lblnb_reste_cavalier.setText(Integer.toString(current_player.getArmee()/3));
										lblnb_reste_tank.setText(Integer.toString(current_player.getArmee()/7));
										current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										if (current_player.getArmee() == 0 && tour>=maitre_du_jeu.getNombre_de_joueur()) {
											current_player_displyed_info.setText("Pour passer en phase d'attaque cliquez sur la carte");
										}
										else {
											current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										}
									}
									
									if (current_pion == "cavalier") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreCavalier(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentrecavalier(), null);	
										
										current_player.AddCavalier(1, new Pion_Cavalier(current_player.getCheminicopionCavalier(), new Zone(listeTerritoire.get(i).getName(), listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone(), listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone())));
										table.setModel(new DefaultTableModel(
												new Object[][] {
													{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
													{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
													{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
													{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
													{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
													{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
													{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
												},
												new String[] {
													"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
												}));
										current_player.setArmee(current_player.getArmee() - 3);
										lblnb_reste_soldat.setText(Integer.toString(current_player.getArmee()));
										lblnb_reste_cavalier.setText(Integer.toString(current_player.getArmee()/3));
										lblnb_reste_tank.setText(Integer.toString(current_player.getArmee()/7));
										current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										if (current_player.getArmee() == 0 && tour>=maitre_du_jeu.getNombre_de_joueur()) {
											current_player_displyed_info.setText("Pour passer en phase d'attaque cliquez sur la carte");
										}
										else {
											current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										}
									}
									
									if (current_pion == "tank") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreTank(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentreTank(), null);	
										
										current_player.AddTank(1, new Pion_Tank(current_player.getCheminicopionTank(), new Zone(listeTerritoire.get(i).getName(), listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone(), listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone())));
										table.setModel(new DefaultTableModel(
												new Object[][] {
													{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
													{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
													{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
													{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
													{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
													{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
													{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
												},
												new String[] {
													"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
												}));
										current_player.setArmee(current_player.getArmee() - 7);
										lblnb_reste_soldat.setText(Integer.toString(current_player.getArmee()));
										lblnb_reste_cavalier.setText(Integer.toString(current_player.getArmee()/3));
										lblnb_reste_tank.setText(Integer.toString(current_player.getArmee()/7));
										current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										if (current_player.getArmee() == 0 && tour>=maitre_du_jeu.getNombre_de_joueur()) {
											current_player_displyed_info.setText("Pour passer en phase d'attaque cliquez sur la carte");
										}
										else {
											current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										}
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
										current_player.Add_Soldat(1, new Pion_soldat(current_player.getCheminicopionSoldat(), new Zone(listeTerritoire.get(i).getName(), listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone(), listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone())));
										table.setModel(new DefaultTableModel(
												new Object[][] {
													{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
													{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
													{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
													{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
													{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
													{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
													{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
												},
												new String[] {
													"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
												}));
										current_player.setArmee(current_player.getArmee() - 1);
										lblnb_reste_soldat.setText(Integer.toString(current_player.getArmee()));
										lblnb_reste_cavalier.setText(Integer.toString(current_player.getArmee()/3));
										lblnb_reste_tank.setText(Integer.toString(current_player.getArmee()/7));
										current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										if (current_player.getArmee() == 0 && tour>=maitre_du_jeu.getNombre_de_joueur()) {
											current_player_displyed_info.setText("Pour passer en phase d'attaque cliquez sur la carte");
										}
										else {
											current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										}
									}
									
									if (current_pion == "cavalier") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreCavalier(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentrecavalier(), null);	
										current_player.AddCavalier(1, new Pion_Cavalier(current_player.getCheminicopionCavalier(), new Zone(listeTerritoire.get(i).getName(), listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone(), listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone())));
										table.setModel(new DefaultTableModel(
												new Object[][] {
													{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
													{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
													{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
													{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
													{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
													{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
													{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
												},
												new String[] {
													"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
												}));
										current_player.setArmee(current_player.getArmee() - 3);
										lblnb_reste_soldat.setText(Integer.toString(current_player.getArmee()));
										lblnb_reste_cavalier.setText(Integer.toString(current_player.getArmee()/3));
										lblnb_reste_tank.setText(Integer.toString(current_player.getArmee()/7));
										current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										if (current_player.getArmee() == 0 && tour>=maitre_du_jeu.getNombre_de_joueur()) {
											current_player_displyed_info.setText("Pour passer en phase d'attaque cliquez sur la carte");
										}
										else {
											current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										}
									}
									
									if (current_pion == "tank") {
										Graphics graphics = getGraphics();
										graphics.drawImage(imgpion, listeTerritoire.get(i).getListe_zone_possible().get(l).getXpositionCentreTank(),listeTerritoire.get(i).getListe_zone_possible().get(l).getYpositionCentreTank(), null);	
										current_player.AddTank(1, new Pion_Tank(current_player.getCheminicopionTank(), new Zone(listeTerritoire.get(i).getName(), listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone(), listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone())));
										table.setModel(new DefaultTableModel(
												new Object[][] {
													{"Soldat / Cavalier / Tank", "Zone 1", "Zone 2", "Zone  3", "Zone 4 ", "Zone  5", "Zone  6  ", "Zone  7"},
													{"Asie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Asie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Asie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Asie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Asie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Asie").size()},
													{"Afrique", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Afrique").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Afrique").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Afrique").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Afrique").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Afrique").size()},
													{"Amerique du sud", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_sud").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_sud").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_sud").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_sud").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_sud").size()},
													{"Amerique du nord", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Amerique_du_nord").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Amerique_du_nord").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Amerique_du_nord").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Amerique_du_nord").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Amerique_du_nord").size()},
													{"Europe", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Europe").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Europe").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Europe").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Europe").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Europe").size()},
													{"Oceanie", current_player.getListe_de_pion_soldatinZone_and_terriroire(1, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(1, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(1, "Oceanie").size()  ,  current_player.getListe_de_pion_soldatinZone_and_terriroire(2, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(2, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(2, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(3, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(3, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(3, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(4, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(4, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(4, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(5, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(5, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(5, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(6, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(6, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(6, "Oceanie").size()  ,current_player.getListe_de_pion_soldatinZone_and_terriroire(7, "Oceanie").size()+ " / " + current_player.getListe_de_pion_cavalierinZone_and_terriroire(7, "Oceanie").size() + " / " + current_player.getListe_de_pion_tankinZone_and_terriroire(7, "Oceanie").size()},
												},
												new String[] {
													"", "Zone 1", "Zone 2", "Zone 3", "Zone 4", "Zone 5", "Zone 6", "Zone 7"
												}));
										current_player.setArmee(current_player.getArmee() - 7);
										lblnb_reste_soldat.setText(Integer.toString(current_player.getArmee()));
										lblnb_reste_cavalier.setText(Integer.toString(current_player.getArmee()/3));
										lblnb_reste_tank.setText(Integer.toString(current_player.getArmee()/7));
										current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
										if (current_player.getArmee() == 0 && tour>=maitre_du_jeu.getNombre_de_joueur()) {
											current_player_displyed_info.setText("Pour passer en phase d'attaque cliquez sur la carte");
										}
										else {
											current_player_displyed_info.setText("Tour de " + current_player.getName() + " reste " + Integer.toString(current_player.getArmee()) + " à placer");
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

	public void Attaque(int x , int y) {
		String territoireAttaquant = null;
		int zonenumAttaquant = 0;
		String territoireDefenseur = null;
		int zonenumDefenseur = 0;
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		Color current_color = robot.getPixelColor(x, y);
		
		//récupérer la zone 
		//en europe
		for (int i = 0; i < listeTerritoire.size(); i++) {
			if (listeTerritoire.get(i).getCouleur_primaire_territoire1() == current_color.getRed() && listeTerritoire.get(i).getCouleur_primaire_territoire2() == current_color.getGreen()) {
				for (int l= 0; l < listeTerritoire.get(i).getListe_zone_possible().size() ; l++) {
					if (listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone().getBlue() == current_color.getBlue()) {
//						System.out.println(listeTerritoire.get(i).getName()+ " zone : " +  listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone());
						if (Defense == false) {
							territoireAttaquant = listeTerritoire.get(i).getName();
							zonenumAttaquant = listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone();
						}
						else {
							territoireDefenseur = listeTerritoire.get(i).getName();
							zonenumDefenseur = listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone();
						}
						
						
					}
					
				}
			}
		}
		//Asie et Amerique du sud
		for (int i = 0; i < listeTerritoire.size(); i++) {
			if (listeTerritoire.get(i).getCouleur_primaire_territoire1() == current_color.getRed() && listeTerritoire.get(i).getCouleur_primaire_territoire2() == current_color.getBlue()) {
				for (int l= 0; l < listeTerritoire.get(i).getListe_zone_possible().size() ; l++) {
					if (listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone().getGreen() == current_color.getGreen()) {
//						System.out.println(listeTerritoire.get(i).getName()+ " zone : " +  listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone());
						if (Defense == false) {
							territoireAttaquant = listeTerritoire.get(i).getName();
							zonenumAttaquant = listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone();
						}
						else {
							territoireDefenseur = listeTerritoire.get(i).getName();
							zonenumDefenseur = listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone();
						}
					}
					
				}
			}
		}
		
		for (int i = 0; i < listeTerritoire.size(); i++) {
			if (listeTerritoire.get(i).getCouleur_primaire_territoire1() == current_color.getGreen() && listeTerritoire.get(i).getCouleur_primaire_territoire2() == current_color.getBlue()) {
				for (int l= 0; l < listeTerritoire.get(i).getListe_zone_possible().size() ; l++) {
					if (listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone().getRed() == current_color.getRed()) {
//						System.out.println(listeTerritoire.get(i).getName()+ " zone : " +  listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone());
						if (Defense == false) {
							territoireAttaquant = listeTerritoire.get(i).getName();
							zonenumAttaquant = listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone();
						}
						else {
							territoireDefenseur = listeTerritoire.get(i).getName();
							zonenumDefenseur = listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone();
						}
					}
					
				}
			}
		}
		
		if (CanIplay(x, y) == true && tour>=maitre_du_jeu.getNombre_de_joueur()) {
			if (current_player.getListe_de_pion_soldatinZone_and_terriroire(zonenumAttaquant, territoireAttaquant).size()>0 || current_player.getListe_de_pion_cavalierinZone_and_terriroire(zonenumAttaquant, territoireAttaquant).size()>0 || current_player.getListe_de_pion_tankinZone_and_terriroire(zonenumAttaquant, territoireAttaquant).size()>0) {
				System.out.println("tu peux bouger tes pions");
				sliderSoldat.setEnabled(true);
				slider_Cavalier.setEnabled(true);
				slider_Tank.setEnabled(true);
				
				sliderSoldat.setMaximum(current_player.getListe_de_pion_soldatinZone_and_terriroire(zonenumAttaquant, territoireAttaquant).size());
				slider_Cavalier.setMaximum(current_player.getListe_de_pion_cavalierinZone_and_terriroire(zonenumAttaquant, territoireAttaquant).size());
				slider_Tank.setMaximum(current_player.getListe_de_pion_tankinZone_and_terriroire(zonenumAttaquant, territoireAttaquant).size());
				
				lblmove_ou_attack.setText(territoireAttaquant+ " zone "+zonenumAttaquant);
				

			}

		}			
		else {
				System.out.println("tu n'as as de pion içi");
				sliderSoldat.setEnabled(false);
				slider_Cavalier.setEnabled(false);
				slider_Tank.setEnabled(false);
			}
		
		if (listePionAttaquantSoldat.size()==0 && CanIplay(x, y)==true) {
			listePionAttaquantSoldat = current_player.getListe_de_pion_soldatinZone_and_terriroire(zonenumAttaquant, territoireAttaquant);
			listePionAttaquantCavalier = current_player.getListe_de_pion_cavalierinZone_and_terriroire(zonenumAttaquant, territoireAttaquant);
			listePionAttaquantTank = current_player.getListe_de_pion_tankinZone_and_terriroire(zonenumAttaquant, territoireAttaquant);
		}
		
		if (listePionAttaquantSoldat.size()>0 && CanIplay(x, y)==true) {
			listePionAttaquantSoldat = current_player.getListe_de_pion_soldatinZone_and_terriroire(zonenumAttaquant, territoireAttaquant);
			listePionAttaquantCavalier = current_player.getListe_de_pion_cavalierinZone_and_terriroire(zonenumAttaquant, territoireAttaquant);
			listePionAttaquantTank = current_player.getListe_de_pion_tankinZone_and_terriroire(zonenumAttaquant, territoireAttaquant);
		}
		if (listePionAttaquantSoldat.size()>0 && CanIplay(x, y)==false) {
			for (int j = 0; j < listeJoueur.size(); j++) {
				if (listeJoueur.get(j).getListe_de_pion_soldatinZone_and_terriroire(zonenumAttaquant, territoireAttaquant).size()!=0) {
					listePionDefenseurSoldat = listeJoueur.get(j).getListe_de_pion_soldatinZone_and_terriroire(zonenumAttaquant, territoireAttaquant);
//					current_player.AddTank(10, new Pion_Tank(current_player.getCheminicopionTank(), new Zone("Asie", 1, new Color(227, 180, 78))));
					lblmove_ou_attack.setText("attaquant :" + (listePionAttaquantSoldat.size() + listePionAttaquantCavalier.size() + listePionAttaquantTank.size()) + " defense :" + (listePionDefenseurSoldat.size()+ listePionDefenseurCavalier.size()+listePionDefenseurTank.size()));
					
					for (int j2 = 0; j < sliderSoldat.getValue()-1; j2++) {
						listePionAttaquantSoldat.get(j2).getZone().setNum_zone(zonenumAttaquant);
						current_player.getListe_de_pion_soldat().get(j2).getZone().setNum_zone(zonenumAttaquant);
					}
					for (int j2 = 0; j < slider_Cavalier.getValue()-1; j2++) {
						listePionAttaquantCavalier.get(j2).getZone().setNum_zone(zonenumAttaquant);
						current_player.getListe_de_pion_soldat().get(j2).getZone().setNum_zone(zonenumAttaquant);

					}
					for (int j2 = 0; j < slider_Tank.getValue()-1; j2++) {
						listePionAttaquantTank.get(j2).getZone().setNum_zone(zonenumAttaquant);
						current_player.getListe_de_pion_soldat().get(j2).getZone().setNum_zone(zonenumAttaquant);

					}
					
					listePionAttaquantSoldat.clear();
					listePionAttaquantCavalier.clear();
					listePionAttaquantTank.clear();
				}
			}
		}
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ResetRound() {
		btnSoldat.setEnabled(true);
		btnCavalier.setEnabled(true);
		btnTank.setEnabled(true);
		
		sliderSoldat.setEnabled(false);
		slider_Cavalier.setEnabled(false);
		slider_Tank.setEnabled(false);
	}
	
	
	
	public boolean CanIplay(int x , int y) {
		Robot robot = null;
		String clickTerritoire = null;
		int clickZone = 0;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
		Color current_color = robot.getPixelColor(x, y);
		//en europe
		for (int i = 0; i < listeTerritoire.size(); i++) {
			if (listeTerritoire.get(i).getCouleur_primaire_territoire1() == current_color.getRed() && listeTerritoire.get(i).getCouleur_primaire_territoire2() == current_color.getGreen()) {
				for (int l= 0; l < listeTerritoire.get(i).getListe_zone_possible().size() ; l++) {
					if (listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone().getBlue() == current_color.getBlue()) {
						clickTerritoire = listeTerritoire.get(i).getName();
						clickZone = listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone();
//						System.out.println(clickTerritoire+ " zone : " + clickZone);
					}
					
				}
			}
		}
		//Asie et Amerique du sud
		for (int i = 0; i < listeTerritoire.size(); i++) {
			if (listeTerritoire.get(i).getCouleur_primaire_territoire1() == current_color.getRed() && listeTerritoire.get(i).getCouleur_primaire_territoire2() == current_color.getBlue()) {
				for (int l= 0; l < listeTerritoire.get(i).getListe_zone_possible().size() ; l++) {
					if (listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone().getGreen() == current_color.getGreen()) {
						clickTerritoire = listeTerritoire.get(i).getName();
						clickZone = listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone();
//						System.out.println(clickTerritoire+ " zone : " + clickZone);
					}
					
				}
			}
		}
		
		for (int i = 0; i < listeTerritoire.size(); i++) {
			if (listeTerritoire.get(i).getCouleur_primaire_territoire1() == current_color.getGreen() && listeTerritoire.get(i).getCouleur_primaire_territoire2() == current_color.getBlue()) {
				for (int l= 0; l < listeTerritoire.get(i).getListe_zone_possible().size() ; l++) {
					if (listeTerritoire.get(i).getListe_zone_possible().get(l).getCouleur_zone().getRed() == current_color.getRed()) {
						clickTerritoire = listeTerritoire.get(i).getName();
						clickZone = listeTerritoire.get(i).getListe_zone_possible().get(l).getNum_zone();
//						System.out.println(clickTerritoire+ " zone : " + clickZone);
					}
					
				}
			}
		}
		
		
//		si il y a quelqu'un dans la zone
		for (int i = 0; i < listeJoueur.size(); i++) {
			if (listeJoueur.get(i).getListe_de_pion_soldatinZone_and_terriroire(clickZone, clickTerritoire).size() >0 && current_player!= listeJoueur.get(i)) {
//				System.out.println("il y a deja un joueur");
				return false;
			}
		}
		return true;
		
	}
	
	
	
	public void DrawAllPion() {
		
		for (int i = 0; i <listeJoueur.size(); i++) {
			for (int j = 0; j < listeJoueur.get(i).getListe_de_pion_soldat().size(); j++) {
				Graphics graphics = getGraphics();
				ImageIcon icon = new ImageIcon(getClass().getResource(listeJoueur.get(i).getCheminicopionSoldat()));
				Image image = icon.getImage();
				graphics.drawImage(image, listeJoueur.get(i).getListe_de_pion_soldat().get(j).getZone().getXpositionCentreSoldat(),listeJoueur.get(i).getListe_de_pion_soldat().get(j).getZone().getYpositionCentreSoldat(), null);	
			}
		}
		
		for (int i = 0; i <listeJoueur.size(); i++) {
			for (int j = 0; j < listeJoueur.get(i).getListe_de_pion_cavalier().size(); j++) {
				Graphics graphics = getGraphics();
				ImageIcon icon = new ImageIcon(getClass().getResource(listeJoueur.get(i).getCheminicopionCavalier()));
				Image image = icon.getImage();
				graphics.drawImage(image, listeJoueur.get(i).getListe_de_pion_cavalier().get(j).getZone().getXpositionCentreCavalier(),listeJoueur.get(i).getListe_de_pion_cavalier().get(j).getZone().getYpositionCentrecavalier(), null);	
			}
		}
		
		for (int i = 0; i <listeJoueur.size(); i++) {
			for (int j = 0; j < listeJoueur.get(i).getListe_de_pion_tank().size(); j++) {
				Graphics graphics = getGraphics();
				ImageIcon icon = new ImageIcon(getClass().getResource(listeJoueur.get(i).getCheminicopionTank()));
				Image image = icon.getImage();
				graphics.drawImage(image, listeJoueur.get(i).getListe_de_pion_tank().get(j).getZone().getXpositionCentreTank(),listeJoueur.get(i).getListe_de_pion_tank().get(j).getZone().getYpositionCentreTank(), null);	
			}
		}
	}
}