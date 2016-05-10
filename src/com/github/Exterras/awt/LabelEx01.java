package com.github.Exterras.awt;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LabelEx01 extends Frame{
	
	public LabelEx01(){
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		Label nice = new Label("Nice",Label.LEFT);
		Label day = new Label("Day",Label.RIGHT);
		
		add(nice);
		add(day);
		
		setTitle("LabelEx01");
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
		new LabelEx01();
	}
	
}
