package com.github.Exterras.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderEx04{
	
	Frame frame = new Frame();
	
	public BorderEx04(){
		frame.setTitle("BorderLayout");
		
		frame.add(new Button("North"), BorderLayout.NORTH);
		frame.add(new Button("South"), BorderLayout.SOUTH);
		frame.add(new Button("East"), BorderLayout.EAST);
		frame.add(new Button("West"), BorderLayout.WEST);
		frame.add(new Button("Center"), BorderLayout.CENTER);
		
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
		new BorderEx04();
	}
}
