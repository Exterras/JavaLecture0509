package com.github.Exterras.gui.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderEx04Arr2 extends Frame{

	Color[] color = {
			Color.RED,
			Color.BLUE,
			Color.ORANGE,
			Color.GREEN,
			Color.YELLOW
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
	
	public BorderEx04Arr2() {
		for (int i = 0; i < btn.length; i++) {
			add(btn[i] = new Button(str[i]),loc[i]);
			btn[i].setBackground(color[i]);
		}
		
		setTitle("BorderEx04Arr2");
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
		new BorderEx04Arr2();
	}
}
