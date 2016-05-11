package com.github.Exterras.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ColorEventEx04 extends Frame implements WindowListener, ActionListener{

	Panel panel1 = new Panel();
	Panel panel2 = new Panel();

	String[] loc = { "Center", "East", "West", "North", "South" };
	String[] str = { "Red", "Green", "Blue", "Yellow", "SkyBlue", "Purple", "Black" };
	Button[] b = new Button[str.length];
	Color[] colF = { new Color(255, 0, 0), new Color(0, 255, 0), new Color(0, 0, 255), new Color(255, 255, 0),
			new Color(0, 255, 255), new Color(255, 0, 255), new Color(0, 0, 0) };
	
	Label label = new Label("Nice day", Label.CENTER);
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public ColorEventEx04() {		
		panelNorth();

		label.setFont(new Font("consolas", Font.BOLD, 30));
		label.setForeground(colF[0]);
		add(label);

		panelSouth();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	void panelNorth(){
		for (int i = 0; i < str.length; i++) {
			Color color = colF[i];
			b[i] = new Button(str[i]);
			panel1.add(b[i]);
			b[i].setBackground(color);
			b[i].setFont(new Font("consolas", Font.ITALIC | Font.BOLD, 25));
			b[i].setForeground(colF[(i + 1) % 5]);
			b[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) { 
					label.setBackground(color); 
				}
			}); // Background Color Changed, improved, i-dont-know localVariable:color
		}
		add(panel1, loc[3]);
	}
	
	void panelSouth(){
		for (int i = 0; i < str.length; i++) {
			Color color = colF[i];
			b[i] = new Button(str[i]);
			panel2.add(b[i]);
			b[i].setBackground(Color.WHITE);
			b[i].setFont(new Font("Georgia", Font.ITALIC | Font.BOLD, 25));
			b[i].setForeground(colF[i]);
			b[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < str.length; i++) {
						if (str[i] == e.getActionCommand()) {
							label.setForeground(colF[i]);
							break;
						}
					}
				}
			}); // Foreground Color Changed
		}
		add(panel2, loc[4]);
	}

	public static void main(String[] args) {
		ColorEventEx04 obj = new ColorEventEx04();
		obj.setSize(800, 800);
//		obj.setBackground(Color.WHITE);
		obj.setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
}