package com.github.Exterras.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridLayoutEx01 extends Frame{

	Color[] color = {
			Color.RED,
			Color.BLUE,
			Color.ORANGE,
			Color.YELLOW,
			Color.GREEN,
			Color.PINK
	};
	
	String[] str = {
			"Red",
			"Blue",
			"Orange",
			"Yellow",
			"Green",
			"Pink"
	};
	
	String[] loc = {
			"Center",
			"East",
			"West",
			"North",
			"South"
	};
	
	Button[] btn = new Button[str.length];
	
	public GridLayoutEx01() {
		setLayout(new GridLayout(3,2));
		
		for (int i = 0; i < btn.length; i++) {
			add(btn[i] = new Button(str[i]));			
			btn[i].setFont(new Font("consolas", Font.BOLD, 15));
			btn[i].setBackground(color[i]);
			btn[i].setForeground(color[(btn.length-1)-i]);
			
			if(btn[i].getBackground() == btn[i].getForeground()){
				btn[i].setForeground(color[(i+1) % 6]);
			}
		}
	
		setTitle("GridLayoutEx01");
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
		new GridLayoutEx01();
	}
}
