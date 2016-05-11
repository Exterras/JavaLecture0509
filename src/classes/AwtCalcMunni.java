package classes;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtCalcMunni extends Frame implements ActionListener {

	public AwtCalcMunni() {
		setLayout(new GridLayout(5, 1));
		TextField textField = new TextField();
		textField.setFont(new Font("consolas", Font.BOLD, 50));
		add(textField); // GridLayout(1,1)

		Panel[] arrPanel = new Panel[4];
		String numStr[][] = { 
				{ "7", "8", "9", "+" },   // GridLayout(2,1)
				{ "4", "5", "6", "-" },   // GridLayout(3,1)
				{ "1", "2", "3", "*" },   // GridLayout(4,1)
				{ "0", ".", "/", "=" } }; // GridLayout(5,1)

		Button calculatorButton = null;
		for (int i = 0; i < numStr.length; i++) {
			arrPanel[i] = new Panel();
			arrPanel[i].setLayout(new GridLayout(1, 4));
			for (int j = 0; j < numStr[i].length; j++) {
				// String temp = numStr[i][j];
				calculatorButton = new Button(numStr[i][j]);
				calculatorButton.setFont(new Font("consolas", Font.BOLD, 35));
				calculatorButton.setForeground(Color.BLUE);
				arrPanel[i].add(calculatorButton);
				// tempButton.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent e) {
				// // TODO Auto-generated method stub
				// textField.setText(temp);
				// }
				// });
			}
			add(arrPanel[i]);
		} // GridLayout(2~5, 1)

		setTitle("Calculator");
		setSize(400, 500);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // window terminate
	}

	public static void main(String[] args) {
		new AwtCalcMunni();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}