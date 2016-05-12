package com.github.Exterras.gui.awt;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LabelEx01Adv extends Frame{
	
	public LabelEx01Adv(){
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		Panel panel = new Panel();
		Label nice = new Label("Nice",Label.LEFT);
		Label day = new Label("Day",Label.RIGHT);
		
		panel.add(nice);
		panel.add(day);
		add(panel);
		
//		add(nice);
//		add(day);
		
		setTitle("LabelEx01Adv");
		setSize(300, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				//dispose();
				System.exit(0);
			}
		}); // window terminate
	}

	public static void main(String[] args) {
		new LabelEx01Adv();
	}
	
}
