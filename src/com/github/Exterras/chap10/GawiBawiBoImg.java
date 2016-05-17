package com.github.Exterras.chap10;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.Exterras.gui.swing.UserObj;

import javax.swing.JLabel;

public class GawiBawiBoImg extends JFrame implements ActionListener {

	private String strHeader = "Select GawiBawiBo";
	// private String[] strGawiBawiBo = { "Scissor", "Rock", "Paper" };
	private String[] strComVsUser = { "Computer", "User" };
	private String[] strComVsUserResult = { "", "" };
	private String[] strFooter = { "Game Start", "Stop" };
	private String[] strFooterLeft = { "User Win", "Draw", "Computer Win" };
	
	private ImageIcon[] icon = { 
			new ImageIcon("img/scissor.png"), 
			new ImageIcon("img/rock.png"),
			new ImageIcon("img/paper.png") };
	
	private JLabel labelFooterLeft = new JLabel(strFooter[0], JLabel.CENTER);

	private JButton[] btnComVsUserResult = new JButton[strComVsUserResult.length];
	
	private JPanel gTemp = new JPanel(); // GridLayout(4,1)'s Panel

	private static final int GRID_LAYOUT_ROWS = 5;
	private static final int GRID_LAYOUT_COLS = 1;
	
	int conWin;
	int userWin;

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
			case 0: // GridLayout(1,1)
				panel.setLayout(new GridLayout(1, 1));

				label = new JLabel(strHeader, JLabel.CENTER);
				label.setFont(new Font("consolas", Font.BOLD, 30));
				// label.setBackground(Color.RED);
				panel.add(label); // GridLayout(1,1)

				add(panel);
				break;
			case 1: // GridLayout(2,1)
				panel.setLayout(new GridLayout(1, icon.length));
				Image img = null;
				ImageIcon tempIcon = null;
				for (int j = 0; j < icon.length; j++) {

					button = new JButton(imgSingleSizeControl(100, 100, j));
					panel.add(button); // GridLayout(1,1)
					int userNum = j; // index -> tempCount
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							setResult(e, userNum); // userNum is parameter of user result
						}
					});
				}
				add(panel);
				break;
			case 2: // GridLayout(3,1)
				panel.setLayout(new GridLayout(1, strComVsUser.length));

				for (int j = 0; j < strComVsUser.length; j++) {
					label = new JLabel(strComVsUser[j], JLabel.CENTER);
					label.setFont(new Font("consolas", Font.BOLD, 25));
					// label.setBackground(Color.RED);
					panel.add(label); // GridLayout(1,1)
				}

				add(panel);
				break;
			case 3: // GridLayout(4,1)
				gTemp.setLayout(new GridLayout(1, strComVsUserResult.length));
				reset();
				break;
			case 4: // GridLayout(5,1)
				panel.setLayout(new GridLayout(1, strFooter.length));

				label = labelFooterLeft;
				button = new JButton(strFooter[1]);

				label.setFont(new Font("consolas", Font.BOLD, 20));
				// label.setBackground(Color.RED);
				button.setFont(new Font("consolas", Font.BOLD, 20));
				// button[i].setBackground(Color.RED);

				panel.add(label); // GridLayout(1,1)
				panel.add(button); // GridLayout(1,2)
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// for (int j = 0; j < btnComVsUserResult.length; j++) {
						// gTemp.remove(btnComVsUserResult[j]); }
						// for (int j = 0; j < btnComVsUserResult.length; j++) {
						// gTemp.add(btnComVsUserResult[j]); }
					}
				});
				add(panel);
				break;
			default:
				break;
			}

		}
	}

	private void reset() {
		for (int j = 0; j < strComVsUserResult.length; j++) {
			btnComVsUserResult[j] = new JButton(strComVsUserResult[j]);
			btnComVsUserResult[j].setFont(new Font("consolas", Font.BOLD, 20));
			gTemp.add(btnComVsUserResult[j]); // GridLayout(1,1)
		}
		add(gTemp);
	}

	private ImageIcon imgSingleSizeControl(int width, int height, int index) {
		Image img = null;
		ImageIcon imgIcon = null;
		img = icon[index].getImage();
		imgIcon = new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		return imgIcon;
	}

	private void setResult(ActionEvent e, int userNum) { 
		// When You Click Rock or Scissor or Paper

		// Activity Processing
		int com = UserObj.getRandom(icon.length);
		int user = userNum + 1;
		String strResult = null;

		for (int i = 0; i < btnComVsUserResult.length; i++) {
			gTemp.remove(btnComVsUserResult[i]);
		}

		btnComVsUserResult[0] = new JButton(imgSingleSizeControl(100, 100, (com - 1)));
		btnComVsUserResult[1] = new JButton(imgSingleSizeControl(100, 100, (user - 1)));

		for (int i = 0; i < btnComVsUserResult.length; i++) {
			gTemp.add(btnComVsUserResult[i]);
		}
		
		
		// Game Result
		if ((com == 1 && user == 2) || (com == 2 && user == 3) || (com == 3 && user == 1)) {
			userWin++;
			strResult = strFooterLeft[0];
			// User Win
		} else if (com == user) {
			strResult = strFooterLeft[1];
			// Draw
		} else {
			conWin++;
			strResult = strFooterLeft[2];
			// Computer Win
		}
		labelFooterLeft.setText("<html>"+strResult+"<br/>"+"Com: "+conWin+" User : "+userWin+"</html>"); // Computer Win
	
	}

	public static void main(String[] args) {
		GawiBawiBoImg gbb = new GawiBawiBoImg();
		gbb.play();
	}
}
