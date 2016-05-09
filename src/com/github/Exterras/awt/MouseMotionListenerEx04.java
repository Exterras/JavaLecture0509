package com.github.Exterras.awt;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MouseMotionListenerEx04 extends Frame implements MouseMotionListener, WindowListener{
	
	int vX, vY;
	String str = "Follow Me";
	
	public MouseMotionListenerEx04() {
		addMouseMotionListener(this);
		addWindowListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		vX = e.getX();
		vY = e.getY();
		setTitle("X : "+vX+" Y : "+vY);
		repaint(); // paint execute
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		vX = e.getX();
		vY = e.getY();
		setTitle("X : "+vX+" Y : "+vY);
		repaint(); // paint execute
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString(str, vX, vY);
	}
	
	public static void main(String[] args) {
		MouseMotionListenerEx04 motion = new MouseMotionListenerEx04();
		
		motion.setTitle("Nice Day");
		motion.setSize(500, 500);
		motion.setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
}