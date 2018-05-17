package jeu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Plateau_de_jeu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private ImageIcon icopion;
	private Image imgpion;
	
	
	public Plateau_de_jeu() {
		
		this.icopion = new ImageIcon(getClass().getResource("/image/pion.png"));
		this.imgpion = this.icopion.getImage();
		
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
				Graphics graphics = getGraphics();
				graphics.drawImage(imgpion, (int)e.getX()-15,(int) e.getY()+15, null);
			}
		});
		fond.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/Map2.jpg")));
		fond.setBounds(0, 0, 1730, 860);
		contentPane.add(fond);
		
		JButton btnJouer = new JButton("");
		btnJouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Maitre_du_jeu.getJoueur_actuel() == Maitre_du_jeu.getNombre_de_joueur()) {
					Maitre_du_jeu.setJoueur_actuel(1);
					System.out.println("Tour du joueur " + Maitre_du_jeu.getJoueur_actuel());
				}
				else {
					Maitre_du_jeu.setJoueur_actuel(Maitre_du_jeu.getJoueur_actuel() + 1);
					System.out.println("Tour du joueur " + Maitre_du_jeu.getJoueur_actuel());
				}

			}
		});
		btnJouer.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/bouton_fin_tour.png")));
		btnJouer.setBounds(1400, 873, 280, 67);
		contentPane.add(btnJouer);
		
		setVisible(true);
	}
}
