package jeu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Plateau_de_jeu extends JFrame {

	private JPanel contentPane;
	private ImageIcon icofond;
	private Image imgfond;

	public Plateau_de_jeu() {
		
		this.icofond = new ImageIcon(getClass().getResource("/image/Map.jpg"));
		this.imgfond = this.icofond.getImage();
		Image newfond = this.imgfond.getScaledInstance(1874, 865, java.awt.Image.SCALE_SMOOTH);
		this.icofond = new ImageIcon(newfond);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, this.icofond.getIconWidth()+10, this.icofond.getIconHeight()+200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fond = new JLabel("");
		fond.setIcon(this.icofond);
		fond.setBounds(0, 0, this.icofond.getIconWidth(), this.icofond.getIconHeight());
		contentPane.add(fond);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Plateau_de_jeu.class.getResource("/image/bouton_fin_tour.png")));
		btnNewButton.setBounds(1500, 900, 285, 87);
		contentPane.add(btnNewButton);
		
		setVisible(true);
	}
	
}
