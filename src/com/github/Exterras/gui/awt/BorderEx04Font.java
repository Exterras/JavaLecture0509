package com.github.Exterras.gui.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderEx04Font extends Frame{

	Color[] color = {
			Color.RED,
			Color.BLUE,
			Color.ORANGE,
			Color.YELLOW,
			Color.GREEN
	};
	
	String[] str = {
			"Red",
			"Blue",
			"Orange",
			"Thick",
			"Thin"
	};
	
	String[] loc = {
			"Center",
			"East",
			"West",
			"North",
			"South"
	};
	
	Button[] btn = new Button[str.length];
	
	public BorderEx04Font() {
		for (int i = 0; i < btn.length; i++) {
			add(btn[i] = new Button(str[i]),loc[i]);			
			btn[i].setFont(new Font("consolas", Font.BOLD, 15));
			btn[i].setBackground(color[i]);
		}
		
		setTitle("BorderEx04Font");
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
		new BorderEx04Font();
	}
}
