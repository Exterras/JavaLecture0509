package com.github.Exterras.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderEx04FlowLayout extends Frame{

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
	
	public BorderEx04FlowLayout() {
		setLayout(new FlowLayout());
		
		for (int i = 0; i < btn.length; i++) {
			add(btn[i] = new Button(str[i])/*,loc[i]*/);			
			btn[i].setFont(new Font("consolas", Font.BOLD, 15));
			btn[i].setBackground(color[i]);
			btn[i].setForeground(color[(btn.length-1)-i]);
			
			if(btn[i].getBackground() == btn[i].getForeground()){
				btn[i].setForeground(color[(btn.length-1)-(i+1)]);
			}
		}
		
		Panel panel = new Panel();
		Label nice = new Label("Nice",Label.LEFT);
		Label day = new Label("Day!",Label.RIGHT);
		
		panel.add(nice);
		panel.add(day);
		add(panel);
	
		setTitle("BorderEx04FlowLayout");
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
		new BorderEx04FlowLayout();
	}
}
