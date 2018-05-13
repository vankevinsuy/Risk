package jeu;

import java.awt.Graphics;

import java.awt.Image;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Plateau extends JFrame implements MouseListener{

	private static final long serialVersionUID = 1L;
	ImageIcon icofond;
	Image imgfond;
	
	public Plateau() {
		super();
		this.icofond = new ImageIcon(getClass().getResource("/image/Map.jpg"));
		this.imgfond = this.icofond.getImage();
		Image newfond = this.imgfond.getScaledInstance(1874, 865, java.awt.Image.SCALE_SMOOTH);
		this.icofond = new ImageIcon(newfond);
		
		JLabel fond = new JLabel(this.icofond);
		this.add(fond);
		
		this.setTitle("Risk");
	    this.setSize(1874, 890);
	    this.setLocationRelativeTo(null);               
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.setVisible(true);
	    
		addMouseListener(this);
		
	}
	
	
	public void mouseClicked(MouseEvent e) {
		Graphics graphics = getGraphics();
		graphics.drawOval(e.getX(), e.getY(), 20, 20);
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	

}
