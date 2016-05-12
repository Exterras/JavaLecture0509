package com.github.Exterras.gui.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PanelEx01 extends Frame{

	Panel panel = new Panel();
	
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
	
	public PanelEx01() {
		
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(str[i]);	
			panel.add(btn[i]);
			btn[i].setFont(new Font("consolas", Font.BOLD, 15));
			btn[i].setBackground(color[i]);
			btn[i].setForeground(color[(i+1)%5]);
		}
		add(panel, loc[4]);
	
		setTitle("PanelEx01");
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
		new PanelEx01();
	}
}
