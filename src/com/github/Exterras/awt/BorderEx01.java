package com.github.Exterras.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderEx01 extends Frame{
	Button north, south, east, west, center;
	
	public BorderEx01(){
		super("BorderLayout"); //title
		setLayout(new BorderLayout());
		
		add(new Button("North"),"North");
		add(new Button("South"),"South");
		add(new Button("East"),"East");
		add(new Button("West"),"West");
		add(new Button("Center"),"Center");
	
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
		new BorderEx01();
	}
}
