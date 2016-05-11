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

public class ColorEventEx03 extends Frame implements WindowListener, ActionListener{

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
//		System.out.println("ActionEvent Activated");
//		System.out.println("Action Command : " + e.getActionCommand());
		label.setText(e.getActionCommand());
	}

	public ColorEventEx03() {

		for (int i = 0; i < str.length; i++) {
			b[i] = new Button(str[i]);
			panel1.add(b[i]);
			b[i].setBackground(colF[i]);
			b[i].setFont(new Font("consolas", Font.ITALIC | Font.BOLD, 25));
			b[i].setForeground(colF[(i + 1) % 5]);
			b[i].addActionListener(this);
		}
		add(panel1, loc[3]);

		
		label.setFont(new Font("consolas", Font.BOLD, 30));
		label.setForeground(colF[0]);
		add(label);

		for (int i = 0; i < str.length; i++) {
			b[i] = new Button(str[i]);
			panel2.add(b[i]);
			b[i].setBackground(Color.WHITE);
			b[i].setFont(new Font("Georgia", Font.ITALIC | Font.BOLD, 25));
			b[i].setForeground(colF[(i + 1) % 5]);
			b[i].addActionListener(this);
		}
		add(panel2, loc[4]);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {

		ColorEventEx03 obj = new ColorEventEx03();

		obj.setSize(800, 800);
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