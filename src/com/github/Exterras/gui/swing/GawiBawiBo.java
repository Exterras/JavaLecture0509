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

public class GawiBawiBo extends JFrame implements ActionListener {

	private String strHeader = 				"Select GawiBawiBo";
	private String[] strGawiBawiBo = { "Scissor", "Rock", "Paper" };
	private String[] strComVsUser =  {     "Computer", "User"     };
	private String[] strComVsUserResult = {        "", ""         };
	private String[] strFooter =     {   "Game Start", "Stop"     };
	
	private String[] strFooterLeft = {"User Win", "Draw", "Computer Win"};
	private JLabel labelFooterLeft = new JLabel(strFooter[0], JLabel.CENTER);
	
	private JButton[] btnComVsUserResult = new JButton[strComVsUserResult.length];

	private static final int GRID_LAYOUT_ROWS = 5;
	private static final int GRID_LAYOUT_COLS = 1;

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void play() {
		drawLayout();

		setTitle("GawiBawiBo");
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
				break;
			case 1:
				panel.setLayout(new GridLayout(1, strGawiBawiBo.length));
				
				for (int j = 0; j < strGawiBawiBo.length; j++) {
					button = new JButton(strGawiBawiBo[j]);
					button.setFont(new Font("consolas", Font.BOLD, 25));
					// button.setForeground(Color.BLUE);
					// button.setBackground(Color.YELLOW);
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							setResult(e);
						}
					});
					panel.add(button);
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
				break;
			case 3:
				panel.setLayout(new GridLayout(1, strComVsUserResult.length));

				for (int j = 0; j < strComVsUserResult.length; j++) {
					btnComVsUserResult[j] = new JButton(strComVsUserResult[j]);
					btnComVsUserResult[j].setFont(new Font("consolas", Font.BOLD, 20));
					// button.setBackground(Color.RED);
					panel.add(btnComVsUserResult[j]); // GridLayout(1,1)
				}
				break;
			case 4:
				panel.setLayout(new GridLayout(1, 2));
				
				label = labelFooterLeft;
				button = new JButton(strFooter[1]);

				label.setFont(new Font("consolas", Font.BOLD, 20));
				// label.setBackground(Color.RED);
				button.setFont(new Font("consolas", Font.BOLD, 20));
				// button[i].setBackground(Color.RED);

				panel.add(label); // GridLayout(1,1)
				panel.add(button); // GridLayout(1,2)
				break;
			default:
				break;
			}
			add(panel);
		}
	}
	
	private void setResult(ActionEvent e) { // When You Click Rock or Scissor or Paper
		// Activity Processing
		int com = UserObj.getRandom(strGawiBawiBo.length);
		int user = 0;
		String str = e.getActionCommand();
		
		switch (str) {
		case "Scissor":
			user = 1;
			break;
		case "Rock":
			user = 2;
			break;
		case "Paper":
			user = 3;
			break;
		}
		
		// Activity Result
		btnComVsUserResult[0].setText(strGawiBawiBo[com - 1]);
		btnComVsUserResult[1].setText(strGawiBawiBo[user - 1]);
		
		// Game Result
		if ((com == 1 && user == 2) || (com == 2 && user == 3) || (com == 3 && user == 1)) { 
			labelFooterLeft.setText(strFooterLeft[0]); // User Win
		} else if (com == user) {
			labelFooterLeft.setText(strFooterLeft[1]); // Draw
		} else {
			labelFooterLeft.setText(strFooterLeft[2]); // Computer Win
		}

	}
	
	public static void main(String[] args) {
		GawiBawiBo gbb = new GawiBawiBo();
		gbb.play();
	}
}
