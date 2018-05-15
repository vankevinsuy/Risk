package jeu;

import java.awt.Graphics;

import java.awt.Image;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;

public class Plateau extends JFrame implements MouseListener{

	private static final long serialVersionUID = 1L;
	ImageIcon icofond;
	Image imgfond;
	
	ImageIcon icopion;
	Image imgpion;
		
	
	public Plateau() {
		super();
		this.icofond = new ImageIcon(getClass().getResource("/image/Map.jpg"));
		this.imgfond = this.icofond.getImage();
		Image newfond = this.imgfond.getScaledInstance(1874, 865, java.awt.Image.SCALE_SMOOTH);
		this.icofond = new ImageIcon(newfond);
		
		this.icopion = new ImageIcon(getClass().getResource("/image/pion.png"));
		this.imgpion = this.icopion.getImage();
		Image newPion = this.imgpion.getScaledInstance(20, 02, java.awt.Image.SCALE_SMOOTH);
		this.icopion  = new ImageIcon(newPion);
		
		JButton bout = new JButton("eee");
		JLabel fond = new JLabel(icofond);
		JPanel panel = new JPanel();
		
		panel.add(bout);
		panel.add(fond);
		
		
		
		this.add(panel);
		
		this.setTitle("Risk");
	    this.setSize(1874, 890);
	    this.setLocationRelativeTo(null);               
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.setVisible(true);
	    
		addMouseListener(this);
		
	}
	
	
	
	public void mouseClicked(MouseEvent e) {
		Graphics graphics = getGraphics();
		graphics.drawImage(imgpion, (int)e.getX()-15,(int) e.getY()-15, null);

	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	
	
	public class Bouton_fin_tour extends JPanel{
		private static final long serialVersionUID = 1L;
		ImageIcon icobouton_fin;
		Image imgbouton_fin;	
		
		public Bouton_fin_tour() {
			super();
			this.icobouton_fin = new ImageIcon(getClass().getResource("/image/bouton_fin_tour.png"));
			this.imgbouton_fin = this.icobouton_fin.getImage();
			
		}
		
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			arg0.drawImage(imgbouton_fin,0,0,null);
		}
		
	}

}
