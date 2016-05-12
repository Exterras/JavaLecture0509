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
import javax.swing.JTextField;

public class SwingCalculator extends JFrame implements ActionListener {

	JTextField textField = new JTextField("0");
	String numStr[][] = { 
			{ "(", ")", "<", "+" }, // GridLayout(2,1)
			{ "7", "8", "9", "-" }, // GridLayout(3,1)
			{ "4", "5", "6", "*" }, // GridLayout(4,1)
			{ "1", "2", "3", "/" }, // GridLayout(5,1)
			{ ".", "0", "C", "=" }, }; // GridLayout(6,1)
	
	String strResult = null;
	String setBtnCharacter = null;
	char oper = 0;
	double a = 0, b = 0;
	double result = 0;

	public void play() {
		setLayout(new GridLayout(6, 1));

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
		JPanel[] buttonPanel = new JPanel[5];
		JButton calculatorButton = null;

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
				String btnText = calculatorButton.getText();
				calculatorButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) { 
						if (textField.getText().equals("0")) {
							textField.setText("");
						} 
						
						switch (btnText) {
						case "+": 
							inputNumA();
							oper = '+';
							break;
						case "-":
							inputNumA();
							oper = '-';
							break;
						case "*":
							inputNumA();
							oper = '*';
							break;
						case "/":
							inputNumA();
							oper = '/';
							break;
						case "=":							
							b = Integer.parseInt(textField.getText());
							result();
							oper = 0;
							textField.setText(strResult);
							break;
						case "C":
							setBtnCharacter = null;
							textField.setText("0");
							break;
						default:
							setBtnCharacter = textField.getText() + btnCharacter;
							textField.setText(setBtnCharacter);
							break;
						}
					}
				});
			} // GridLayout(i,1~4)
			
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			}); // window terminate

			add(buttonPanel[i]);
		} // GridLayout(2~5, 1)
	}

	private void inputNumA(){
		a = Double.parseDouble(textField.getText()); 
		textField.setText("");
	}
	
	private void result(){
		switch (oper) {
		case '+':
			result = a + b;
			strResult = Double.toString(result);
			break;
		case '-':
			result = a - b;	
			strResult = Double.toString(result);
			break;
		case '*':
			result = a * b;
			strResult = Double.toString(result);
			break;
		case '/':
			result = ((double)a / (double)b);
			strResult = Double.toString(result);
			break;
		default:
			break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}
	
	public static void main(String[] args) {
		SwingCalculator sc = new SwingCalculator();
		sc.play();
	}
	
}