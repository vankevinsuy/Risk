package jeu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Introduction extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton button_6joueurs;
	private JButton button_5joueurs;
	private JButton button_4joueurs;
	private JButton button_3joueurs;
	private JButton button_2joueurs;
	


	public Introduction() {
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(100, 100, 1258, 750);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		
		
		JButton button_6joueurs = new JButton(new ImageIcon(Introduction.class.getResource("/image/bouton_6joueurs.png")));
		button_6joueurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Maitre_du_jeu.setNombre_de_joueur(6);
				button_6joueurs.setOpaque(true);
				button_6joueurs.setContentAreaFilled(true);
				button_6joueurs.setBorderPainted(true);
				button_6joueurs.setBackground(Color.RED);
				
				button_5joueurs.setOpaque(false);
				button_5joueurs.setContentAreaFilled(false);
				button_5joueurs.setBorderPainted(false);	
				
				button_4joueurs.setOpaque(false);
				button_4joueurs.setContentAreaFilled(false);
				button_4joueurs.setBorderPainted(false);
				
				button_3joueurs.setOpaque(false);
				button_3joueurs.setContentAreaFilled(false);
				button_3joueurs.setBorderPainted(false);
				
				button_2joueurs.setOpaque(false);
				button_2joueurs.setContentAreaFilled(false);
				button_2joueurs.setBorderPainted(false);
			}
		});
		button_6joueurs.setBounds(494, 386, 287, 79);
		button_6joueurs.setOpaque(false);
		button_6joueurs.setContentAreaFilled(false);
		button_6joueurs.setBorderPainted(false);
		contentPane.add(button_6joueurs);
		
		button_5joueurs = new JButton(new ImageIcon(Introduction.class.getResource("/image/bouton_5joueurs.png")));
		button_5joueurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Maitre_du_jeu.setNombre_de_joueur(5);
				button_5joueurs.setOpaque(true);
				button_5joueurs.setContentAreaFilled(true);
				button_5joueurs.setBorderPainted(true);
				button_5joueurs.setBackground(Color.RED);
				
				button_6joueurs.setOpaque(false);
				button_6joueurs.setContentAreaFilled(false);
				button_6joueurs.setBorderPainted(false);
				
				button_4joueurs.setOpaque(false);
				button_4joueurs.setContentAreaFilled(false);
				button_4joueurs.setBorderPainted(false);
				
				button_3joueurs.setOpaque(false);
				button_3joueurs.setContentAreaFilled(false);
				button_3joueurs.setBorderPainted(false);
				
				button_2joueurs.setOpaque(false);
				button_2joueurs.setContentAreaFilled(false);
				button_2joueurs.setBorderPainted(false);
				
				
			}
		});
		button_5joueurs.setBounds(975, 230, 287, 79);
		button_5joueurs.setOpaque(false);
		button_5joueurs.setContentAreaFilled(false);
		button_5joueurs.setBorderPainted(false);
		contentPane.add(button_5joueurs);
		
		button_3joueurs = new JButton(new ImageIcon(Introduction.class.getResource("/image/bouton_3joueurs.png")));
		button_3joueurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Maitre_du_jeu.setNombre_de_joueur(3);
				button_3joueurs.setOpaque(true);
				button_3joueurs.setContentAreaFilled(true);
				button_3joueurs.setBorderPainted(true);
				button_3joueurs.setBackground(Color.RED);
				
				
				button_6joueurs.setOpaque(false);
				button_6joueurs.setContentAreaFilled(false);
				button_6joueurs.setBorderPainted(false);
				
				button_5joueurs.setOpaque(false);
				button_5joueurs.setContentAreaFilled(false);
				button_5joueurs.setBorderPainted(false);
				
				button_4joueurs.setOpaque(false);
				button_4joueurs.setContentAreaFilled(false);
				button_4joueurs.setBorderPainted(false);
				
				button_2joueurs.setOpaque(false);
				button_2joueurs.setContentAreaFilled(false);
				button_2joueurs.setBorderPainted(false);
			}
		});
		button_3joueurs.setBounds(324, 230, 287, 79);
		button_3joueurs.setOpaque(false);
		button_3joueurs.setContentAreaFilled(false);
		button_3joueurs.setBorderPainted(false);
		contentPane.add(button_3joueurs);
		
		button_2joueurs = new JButton(new ImageIcon(Introduction.class.getResource("/image/bouton_2joueurs.png")));
		button_2joueurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Maitre_du_jeu.setNombre_de_joueur(2);
				button_2joueurs.setOpaque(true);
				button_2joueurs.setContentAreaFilled(true);
				button_2joueurs.setBorderPainted(true);
				button_2joueurs.setBackground(Color.RED);
				
				
				button_6joueurs.setOpaque(false);
				button_6joueurs.setContentAreaFilled(false);
				button_6joueurs.setBorderPainted(false);
				
				button_5joueurs.setOpaque(false);
				button_5joueurs.setContentAreaFilled(false);
				button_5joueurs.setBorderPainted(false);
				
				button_4joueurs.setOpaque(false);
				button_4joueurs.setContentAreaFilled(false);
				button_4joueurs.setBorderPainted(false);
				
				button_3joueurs.setOpaque(false);
				button_3joueurs.setContentAreaFilled(false);
				button_3joueurs.setBorderPainted(false);
			}
		});
		button_2joueurs.setBounds(0, 230, 287, 79);
		button_2joueurs.setOpaque(false);
		button_2joueurs.setContentAreaFilled(false);
		button_2joueurs.setBorderPainted(false);
		contentPane.add(button_2joueurs);
		
	    button_4joueurs = new JButton(new ImageIcon(Introduction.class.getResource("/image/bouton_4joueurs.png")));
		button_4joueurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Maitre_du_jeu.setNombre_de_joueur(4);
				button_4joueurs.setOpaque(true);
				button_4joueurs.setContentAreaFilled(true);
				button_4joueurs.setBorderPainted(true);
				button_4joueurs.setBackground(Color.RED);
				
				button_6joueurs.setOpaque(false);
				button_6joueurs.setContentAreaFilled(false);
				button_6joueurs.setBorderPainted(false);
				
				button_5joueurs.setOpaque(false);
				button_5joueurs.setContentAreaFilled(false);
				button_5joueurs.setBorderPainted(false);
				
				button_3joueurs.setOpaque(false);
				button_3joueurs.setContentAreaFilled(false);
				button_3joueurs.setBorderPainted(false);
				
				button_2joueurs.setOpaque(false);
				button_2joueurs.setContentAreaFilled(false);
				button_2joueurs.setBorderPainted(false);
			}
		});
		button_4joueurs.setBounds(648, 230, 287, 79);
		button_4joueurs.setOpaque(false);
		button_4joueurs.setContentAreaFilled(false);
		button_4joueurs.setBorderPainted(false);
		contentPane.add(button_4joueurs);
		
		JButton bouton_jouer = new JButton(new ImageIcon(Introduction.class.getResource("/image/bouton_jouer.png")));
		bouton_jouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Maitre_du_jeu.getNombre_de_joueur() == 0) {
					System.out.println("Choisissez un nombre de joueur");
				}
				else {
					System.out.println("partie à " + Maitre_du_jeu.getNombre_de_joueur() + " joueurs");
					dispose();
					Maitre_du_jeu.LaunchGame();
				}
			}
		});
		bouton_jouer.setBounds(494, 558, 287, 79);
		bouton_jouer.setOpaque(false);
		bouton_jouer.setContentAreaFilled(false);
		bouton_jouer.setBorderPainted(false);
		contentPane.add(bouton_jouer);
		
		JLabel fondLbl = new JLabel(new ImageIcon(Introduction.class.getResource("/image/intro.jpg")));
		fondLbl.setBounds(0, 0, 1252, 724);
		this.contentPane.add(fondLbl);
		
		this.setVisible(true);
	}

	

}
