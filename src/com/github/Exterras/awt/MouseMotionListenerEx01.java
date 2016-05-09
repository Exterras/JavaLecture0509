package com.github.Exterras.awt;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionListenerEx01 extends Frame implements MouseMotionListener{
	
	public MouseMotionListenerEx01() {
		// TODO Auto-generated constructor stub
		addMouseMotionListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		setTitle("Dragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		setTitle("Moved");
	}
	
	public static void main(String[] args) {
		MouseMotionListenerEx01 motion = new MouseMotionListenerEx01();
		
		motion.setTitle("Nice Day");
		motion.setSize(500, 500);
		motion.setVisible(true);
	}
	
}
