package com.github.Exterras.gui.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingCalcMunni extends JFrame implements ActionListener {

	JTextField textField = new JTextField("0");

	public void play() {
		setLayout(new GridLayout(5, 1));

		panelTextField();
		panelCalculatorButton();

		setTitle("Calculator");
		setSize(400, 500);
		setVisible(true);
	}

	private void panelTextField() {
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout());

		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setFont(new Font("consolas", Font.BOLD, 50));
		textField.setBackground(Color.RED);
		textField.setEditable(false);
		textPanel.add(textField); // GridLayout(1,1)
		add(textPanel);
	}

	private void panelCalculatorButton() {
		JPanel[] buttonPanel = new JPanel[4];
		JButton calculatorButton = null;
		String numStr[][] = { 
				{ "7", "8", "9", "+" }, // GridLayout(2,1)
				{ "4", "5", "6", "-" }, // GridLayout(3,1)
				{ "1", "2", "3", "*" }, // GridLayout(4,1)
				{ "0", ".", "/", "=" } }; // GridLayout(5,1)

		for (int i = 0; i < numStr.length; i++) {
			buttonPanel[i] = new JPanel();
			buttonPanel[i].setLayout(new GridLayout(1, 4));
			for (int j = 0; j < numStr[i].length; j++) {
				calculatorButton = new JButton(numStr[i][j]);
				calculatorButton.setFont(new Font("consolas", Font.BOLD, 35));
				calculatorButton.setForeground(Color.BLUE);
				calculatorButton.setBackground(Color.YELLOW);
				buttonPanel[i].add(calculatorButton);

				String btnCharacter = numStr[i][j];
				calculatorButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (textField.getText().equals("0")) {
							textField.setText("");
						}
						String setBtnCharacter = textField.getText() + btnCharacter;
						textField.setText(setBtnCharacter);
					}
				});
			} // GridLayout(i,1~4)
			add(buttonPanel[i]);
		} // GridLayout(2~5, 1)
	}

	public static void main(String[] args) {
		SwingCalcMunni sc = new SwingCalcMunni();
		sc.play();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}