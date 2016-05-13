package com.github.Exterras.gui.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GawiBawiBoMunniAdv extends JFrame implements ActionListener {

	private String strHeader = "Select GawiBawiBo";
	private String[] strGawiBawiBoMunniAdv = { "Scissor", "Rock", "Paper" };
	private String[] strComVsUser = { "Computer", "User" };
	private String[] strComVsUserResult = { "", "" };
	private String[] strFooter = { "Game Start", "Stop" };

	private static final int GRID_LAYOUT_ROWS = 5;
	private static final int GRID_LAYOUT_COLS = 1;

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void play() {
		drawLayout();

		setTitle("GawiBawiBoMunniAdv");
		setSize(500, 600);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // window terminate
	}

	private void drawLayout() {
		setLayout(new GridLayout(GRID_LAYOUT_ROWS, GRID_LAYOUT_COLS));

		JPanel panel = null;
		JLabel label = null;
		JButton button = null;
		
		for (int i = 0; i < GRID_LAYOUT_ROWS; i++) {
			panel = new JPanel();
			
			switch (i) {
			case 0:
				panel.setLayout(new GridLayout(1, 1));
				
				label = new JLabel(strHeader,JLabel.CENTER);
				label.setFont(new Font("consolas", Font.BOLD, 30));
				// label.setBackground(Color.RED);
				panel.add(label); // GridLayout(1,1)
				add(panel);
				break;
			case 1:
				panel.setLayout(new GridLayout(1, strGawiBawiBoMunniAdv.length));
				
				for (int j = 0; j < strGawiBawiBoMunniAdv.length; j++) {
					button = new JButton(strGawiBawiBoMunniAdv[j]);
					button.setFont(new Font("consolas", Font.BOLD, 25));
					// button.setForeground(Color.BLUE);
					// button.setBackground(Color.YELLOW);
					panel.add(button);
					add(panel);
				}
				break;
			case 2:
				panel.setLayout(new GridLayout(1, strComVsUser.length));
		
				for (int j = 0; j < strComVsUser.length; j++) {
					label = new JLabel(strComVsUser[j], JLabel.CENTER);
					label.setFont(new Font("consolas", Font.BOLD, 25));
					// label.setBackground(Color.RED);
					panel.add(label); // GridLayout(1,1)
				}
				add(panel);
				break;
			case 3:
				panel.setLayout(new GridLayout(1, strComVsUserResult.length));

				for (int j = 0; j < strComVsUserResult.length; j++) {
					button = new JButton(strComVsUserResult[j]);
					button.setHorizontalAlignment(JLabel.CENTER);
					button.setFont(new Font("consolas", Font.BOLD, 15));
					// button.setBackground(Color.RED);
					panel.add(button); // GridLayout(1,1)
				}
				add(panel);
				break;
			case 4:
				panel.setLayout(new GridLayout(1, 2));
				
				label = new JLabel(strFooter[0],JLabel.CENTER);
				button = new JButton(strFooter[1]);

				label.setFont(new Font("consolas", Font.BOLD, 20));
				// label.setBackground(Color.RED);
				button.setFont(new Font("consolas", Font.BOLD, 20));
				// button[i].setBackground(Color.RED);

				panel.add(label); // GridLayout(1,1)
				panel.add(button); // GridLayout(1,2)
				add(panel);
				break;
			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		GawiBawiBoMunniAdv gbb = new GawiBawiBoMunniAdv();
		gbb.play();
	}
}
