package com.github.Exterras.gui.awt;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionListenerEx02 extends Frame implements MouseMotionListener{
	
	public MouseMotionListenerEx02() {
		// TODO Auto-generated constructor stub
		addMouseMotionListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		setTitle("X : "+e.getX()+" Y : "+e.getY());
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		setTitle("X : "+e.getX()+" Y : "+e.getY());
	}
	
	public static void main(String[] args) {
		MouseMotionListenerEx02 motion = new MouseMotionListenerEx02();
		
		motion.setTitle("Nice Day");
		motion.setSize(500, 500);
		motion.setVisible(true);
	}
}
