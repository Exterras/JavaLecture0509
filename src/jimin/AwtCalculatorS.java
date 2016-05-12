package jimin;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Panel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.*;

public class  AwtCalculatorS  extends JFrame implements ActionListener{
	int sum = 0;
	String op = "=";

	public void actionPerformed(ActionEvent e) {
		String result = e.getActionCommand();
		int num = 0;

		if( e.getActionCommand().equals("C") ){
			jtext.setText("0");
			sum = 0;
			op = "=";
		} else if( jtext.getText().equals("0") ) {
			jtext.setText( e.getActionCommand() );
		} else {
			switch (result) {
				case "0":
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
					jtext.setText( jtext.getText() + e.getActionCommand() );
					break;
				case "+":
					num = Integer.parseInt(jtext.getText());
					if(op.equals("+")) {
						sum += num;
						op = "+";
						System.out.println(sum);
						jtext.setText("0");
						break;
					} else if(op.equals("-")) {
						sum -= num;
						op = "+";
						System.out.println(sum);
						jtext.setText("0");
						break;
					} else if(op.equals("*")) {
						sum *= num;
						op = "+";
						System.out.println(sum);
						jtext.setText("0");
						break;
					} 
					op = "+";
					sum = num;
					System.out.println(sum);
					jtext.setText("0");
					break;
				case "-":
					num = Integer.parseInt(jtext.getText());
					if(op.equals("+")) {
						sum += num;
						op = "-";
						System.out.println(sum);
						jtext.setText("0");
						break;
					} else if(op.equals("-")) {
						sum -= num;
						op = "-";
						System.out.println(sum);
						jtext.setText("0");
						break;
					} else if(op.equals("*")) {
						sum *= num;
						op = "-";
						System.out.println(sum);
						jtext.setText("0");
						break;
					} 
					op = "-";
					sum = num;
					System.out.println(sum);
					jtext.setText("0");
					break;
				case "*":
					num = Integer.parseInt(jtext.getText());
					if(op.equals("+")) {
						sum += num;
						op = "*";
						System.out.println(sum);
						jtext.setText("0");
						break;
					} else if(op.equals("-")) {
						sum -= num;
						op = "*";
						System.out.println(sum);
						jtext.setText("0");
						break;
					} else if(op.equals("*")) {
						sum *= num;
						op = "*";
						System.out.println(sum);
						jtext.setText("0");
						break;
					}  
					op = "*";
					sum = num;
					System.out.println(sum);
					jtext.setText("0");
					break;
				case "=":		
					num = Integer.parseInt(jtext.getText());
					if(op.equals("+")) {
						sum += num;
						System.out.println(sum);
						jtext.setText( Integer.toString(sum) );
						sum=0;
						op = "=";
						break;
					} else if(op.equals("-")) {
						sum -= num;
						System.out.println(sum);
						jtext.setText( Integer.toString(sum) );
						sum=0;
						op = "=";
						break;
					} else if(op.equals("*")) {
						sum *= num;
						System.out.println(sum);
						jtext.setText( Integer.toString(sum) );
						sum=0;
						op = "=";
						break;
					} 
			}
		}
	
	}


	JPanel [] panel = new JPanel[5];	

	String [][] num = { 
		{"1", "2", "3", "+"},
		{"4", "5", "6", "-"}, 
		{"7", "8", "9", "*"}, 
		{"C", "��", "0", "="}
	};
	Color [] colorF = {
		new Color(255, 104, 104),
		new Color(255, 145 , 91 ),
		new Color(251 ,243 , 104 ),
		new Color(135 ,249 , 115 ),
		new Color(85 ,89 ,249 )
	};

	JButton [][] button = new JButton[4][4];
	JTextField jtext = new JTextField("0");

	AwtCalculatorS() { 
		for(int i=0; i< panel.length; i++) {

			panel[i] = new JPanel();
			
			if(i==0){				
				panel[i].add(jtext);
				jtext.setFont(new Font("", Font.BOLD, 30));
				jtext.setBackground(colorF[0]);
				jtext.setHorizontalAlignment(JTextField.RIGHT);
				jtext.setEditable(false);
				panel[i].setLayout(new GridLayout(1, 1));
				add(panel[i]);
			}else {
				for( int k=0; k <num[i-1].length; k++) {
					button[i-1][k] = new JButton (num[i-1][k]);
					button[i-1][k].setBackground(new Color(251 , 243, 104));
					button[i-1][k].setFont(new Font("", Font.BOLD, 30));			
					panel[i].add(button[i-1][k]);
					button[i-1][k].addActionListener(this);
				}		
				panel[i].setLayout(new GridLayout(1,4));
				add(panel[i]);				
			}		
//			panel[i].setBackground(colorF[i]);
		}
	}

	public static void main(String[] args) 	{
		AwtCalculatorS  aCalc =	new AwtCalculatorS();	
		aCalc.setTitle("����");
		aCalc.setLayout(new GridLayout(5,1));
		aCalc.setSize(500, 500);
		aCalc.setVisible(true);	
	}
}