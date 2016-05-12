package classes;

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

	String strHeader = "Select GawiBawiBo";
	String[] strGawiBawiBo = { "Scissor", "Rock", "Paper" };
	String[] strComVsUser = { "Computer", "User" };
	String[] strComVsUserResult = { "", "" };
	String[] strFooter = { "Game Start", "Stop" };

	private static final int GRIDLAYOUT_ROWS = 5;
	private static final int GRIDLAYOUT_COLS = 1;

	private void panelHeader() {
		
		JPanel panelHeader = new JPanel();
		JLabel textHeader = new JLabel(strHeader);
	
		panelHeader.setLayout(new GridLayout());

		textHeader.setHorizontalAlignment(JLabel.CENTER);
		textHeader.setFont(new Font("consolas", Font.BOLD, 30));
		// textHeader.setBackground(Color.RED);
		panelHeader.add(textHeader); // GridLayout(1,1)
		add(panelHeader);

	}

	private void panelGawiBawiBo() {
		JPanel panelGawiBawiBo = new JPanel();
		JButton buttonGawiBawiBo = null;

		panelGawiBawiBo.setLayout(new GridLayout(1, strGawiBawiBo.length));
		for (int i = 0; i < strGawiBawiBo.length; i++) {
			buttonGawiBawiBo = new JButton(strGawiBawiBo[i]);
			buttonGawiBawiBo.setFont(new Font("consolas", Font.BOLD, 25));
			// buttonGawiBawiBo.setForeground(Color.BLUE);
			// buttonGawiBawiBo.setBackground(Color.YELLOW);
			panelGawiBawiBo.add(buttonGawiBawiBo);
			add(panelGawiBawiBo);
		}
	}

	private void panelComVsUser() {
		JPanel panelComVsUser = new JPanel();
		JLabel[] textComVsUser = new JLabel[strComVsUser.length];
		panelComVsUser.setLayout(new GridLayout(1, textComVsUser.length));

		for (int i = 0; i < textComVsUser.length; i++) {
			textComVsUser[i] = new JLabel(strComVsUser[i]);
			textComVsUser[i].setHorizontalAlignment(JLabel.CENTER);
			textComVsUser[i].setFont(new Font("consolas", Font.BOLD, 25));
			// textComVsUser[i].setBackground(Color.RED);
			panelComVsUser.add(textComVsUser[i]); // GridLayout(1,1)
		}
		add(panelComVsUser);
	}

	private void panelComVsUserResult() {
		JPanel panelComVsUser = new JPanel();
		JButton[] ComVsUserResult = new JButton[strComVsUserResult.length];
		panelComVsUser.setLayout(new GridLayout(1, ComVsUserResult.length));

		for (int i = 0; i < ComVsUserResult.length; i++) {
			ComVsUserResult[i] = new JButton(strComVsUserResult[i]);
			ComVsUserResult[i].setHorizontalAlignment(JLabel.CENTER);
			ComVsUserResult[i].setFont(new Font("consolas", Font.BOLD, 15));
			// textComVsUser[i].setBackground(Color.RED);
			panelComVsUser.add(ComVsUserResult[i]); // GridLayout(1,1)
		}
		add(panelComVsUser);
	}

	private void panelFooter() {
		JPanel panelFooter = new JPanel();
		panelFooter.setLayout(new GridLayout(1, 2));
		
		JLabel textFooter = new JLabel(strFooter[0]);
		JButton gameStop = new JButton(strFooter[1]);

		textFooter.setHorizontalAlignment(JLabel.CENTER);
		textFooter.setFont(new Font("consolas", Font.BOLD, 20));
		// textHeader.setBackground(Color.RED);

		gameStop.setHorizontalAlignment(JLabel.CENTER);
		gameStop.setFont(new Font("consolas", Font.BOLD, 20));
		// textComVsUser[i].setBackground(Color.RED);

		panelFooter.add(textFooter); // GridLayout(1,1)
		panelFooter.add(gameStop); // GridLayout(1,2)
		add(panelFooter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void play() {
//		drawLayout();
		
		setLayout(new GridLayout(GRIDLAYOUT_ROWS, GRIDLAYOUT_COLS));
		panelHeader();
		panelGawiBawiBo();
		panelComVsUser();
		panelComVsUserResult();
		panelFooter();

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
		setLayout(new GridLayout(GRIDLAYOUT_ROWS, GRIDLAYOUT_COLS));

		JPanel panel = null;
		JLabel label = null;
		JButton button = null;
		
		for (int i = 0; i < GRIDLAYOUT_ROWS; i++) {
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
				panel.setLayout(new GridLayout(1, strGawiBawiBo.length));
				
				for (int j = 0; j < strGawiBawiBo.length; j++) {
					button = new JButton(strGawiBawiBo[j]);
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
		GawiBawiBo gbb = new GawiBawiBo();
		gbb.play();
	}
}
