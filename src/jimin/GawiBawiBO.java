package jimin;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class  GawiBawiBO extends JFrame implements ActionListener{

	public void	actionPerformed(ActionEvent e){
		String str = e.getActionCommand();
		int com = UserObj.getRandom(3);
		
		if( 1 == com ){
			button[3].setText("가위");
		} else if( 2 == com ){
			button[3].setText("바위");
		} else if( 3 == com ){
			button[3].setText("보");
		}

		if( str.equals("가위")) {
			button[4].setText("가위");
		} else if( str.equals("바위")) {
			button[4].setText("바위");
		} else if( str.equals("보")) {
			button[4].setText("보");
		} 
	}

	JTextField jtext = new JTextField(" ");
	JPanel[] panel = new JPanel[5];
	JButton[] button = new JButton [6];
	JLabel[] label= new JLabel[4];

	String [] strButton = { "가위", "바위", "보", "", "", "Stop" };
	String [] strLabel	= { "Select GawiBawiBo", "Computer", "User", "Game Start" };

	GawiBawiBO() {
		for( int i=0; i< panel.length; i++) {
			panel[i] = new JPanel();
		}
		for( int i=0; i< strButton.length; i++) {
			button[i] = new JButton(strButton[i]);
			button[i].setBackground(Color.PINK);
			button[i].setFont( new Font("", Font.BOLD, 15));
		}
		for( int i=0; i< strLabel.length; i++) {
			label[i] = new JLabel(strLabel[i], JLabel.CENTER);
			label[i].setFont( new Font("", Font.BOLD, 15));
		}
		/////////////////////////////////////////////
		panel[0].setLayout(new GridLayout(1,1));	
		panel[0].add(label[0]);		
		add(panel[0]);
		/////////////////////////////////////////////
		panel[1].setLayout(new GridLayout(1,3));	
		panel[1].add(button[0]);
		panel[1].add(button[1]);
		panel[1].add(button[2]);
		add(panel[1]);		
		for( int i=0; i< 3; i++) {
			button[i].addActionListener(this);
		}
		/////////////////////////////////////////////
		panel[2].setLayout(new GridLayout(1,2));	
		panel[2].add(label[1]);		
		panel[2].add(label[2]);		
		add(panel[2]);
		/////////////////////////////////////////////
		panel[3].setLayout(new GridLayout(1,2));	
		panel[3].add(button[3]);
		panel[3].add(button[4]);
		add(panel[3]);
		/////////////////////////////////////////////
		panel[4].setLayout(new GridLayout(1,2));	
		panel[4].add(label[3]);
		panel[4].add(button[5]);
		add(panel[4]);
	}
	public static void main(String[] args) 	{
		GawiBawiBO gBB = new GawiBawiBO();
		gBB.setSize(500, 500);
		gBB.setVisible(true);
		gBB.setLayout(new GridLayout(5,1) );

	}
}
