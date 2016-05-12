package com.github.Exterras.gui.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderEx02{
	Button north, south, east, west, center;
	
	Frame frame = new Frame();
	
	public BorderEx02(){
		frame.setTitle("BorderLayout"); //title
		frame.setLayout(new BorderLayout());
		
		frame.add(new Button("North"),"North");
		frame.add(new Button("South"),"South");
		frame.add(new Button("East"),"East");
		frame.add(new Button("West"),"West");
		frame.add(new Button("Center"),"Center");
	
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				//dispose();
				System.exit(0);
			}
		}); // window terminate
	}
	
	public static void main(String[] args) {
		new BorderEx02();
	}
}
