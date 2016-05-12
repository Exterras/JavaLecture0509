package com.github.Exterras.gui.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ColorEventEx01 extends Frame {

	Panel panel1 = new Panel();
	Panel panel2 = new Panel();

	String[] loc = { "Center", "East", "West", "North", "South" };

	String[] str = { "Red", "Orange", "Yellow", "Green", "Blue", "BluishGreen", "Pink" };

	Button[] b = new Button[str.length];

	Color[] col = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.PINK };

	ColorEventEx01() {

		for (int i = 0; i < str.length; i++) {
			b[i] = new Button(str[i]);
			panel1.add(b[i]);
			b[i].setBackground(col[i]);
			b[i].setFont(new Font("consolas", Font.ITALIC | Font.BOLD, 25));
			b[i].setForeground(col[(i + 1) % 5]);
		}
		add(panel1, loc[3]);

		Label label = new Label("Nice day", Label.CENTER);
		label.setFont(new Font("궁서체", Font.BOLD, 30));
		label.setForeground(Color.BLUE);
		add(label);

		for (int i = 0; i < str.length; i++) {
			b[i] = new Button(str[i]);
			panel2.add(b[i]);
			b[i].setBackground(Color.WHITE);
			b[i].setFont(new Font("Georgia", Font.ITALIC | Font.BOLD, 25));
			b[i].setForeground(col[(i + 1) % 5]);
		}
		add(panel2, loc[4]);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {

		ColorEventEx01 obj = new ColorEventEx01();

		obj.setSize(800, 800);
		obj.setVisible(true);
	}
}