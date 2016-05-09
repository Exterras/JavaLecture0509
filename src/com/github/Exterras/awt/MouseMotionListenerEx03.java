package com.github.Exterras.awt;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionListenerEx03 extends Frame implements MouseMotionListener{
	
	int vX, vY;
	String str = "Follow Me";
	
	public MouseMotionListenerEx03() {
		// TODO Auto-generated constructor stub
		addMouseMotionListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		vX = e.getX();
		vY = e.getY();
		setTitle("X : "+vX+" Y : "+vY);
		repaint(); // paint execute
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		vX = e.getX();
		vY = e.getY();
		setTitle("X : "+vX+" Y : "+vY);
		repaint(); // paint execute
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString(str, vX, vY);
	}
	
	public static void main(String[] args) {
		MouseMotionListenerEx03 motion = new MouseMotionListenerEx03();
		
		motion.setTitle("Nice Day");
		motion.setSize(500, 500);
		motion.setVisible(true);
	}
}