package com.github.Exterras.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderEx05 extends Frame{
	Button[] button = {
			new Button("North"),
			new Button("South"),
			new Button("East"),
			new Button("West"),
			new Button("Center")
	};
	
	String[] position = {
			BorderLayout.NORTH,
			BorderLayout.SOUTH,
			BorderLayout.EAST,
			BorderLayout.WEST,
			BorderLayout.CENTER
	};
	
	public BorderEx05(){
		super("BorderLayout"); //title

		for (int i = 0; i < button.length; i++) {
			add(button[i],position[i]);
		}
		
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
		new BorderEx05();
	}
}
