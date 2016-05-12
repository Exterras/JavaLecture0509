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

public class GawiBawiBoMunni extends JFrame implements ActionListener{

	private void panelHeader(){
		JTextField textHeader = new JTextField("Select GawiBawiBoMunni");
		
		JPanel panelHeader = new JPanel();
		panelHeader.setLayout(new GridLayout());
	
		textHeader.setHorizontalAlignment(JTextField.CENTER);
		textHeader.setFont(new Font("consolas", Font.BOLD, 30));
//		textHeader.setBackground(Color.RED);
		textHeader.setEditable(false);
		panelHeader.add(textHeader); // GridLayout(1,1)
		add(panelHeader);
		
	}
	
	private void panelGawiBawiBoMunni(){
		JPanel panelGawiBawiBoMunni = new JPanel();
		JButton buttonGawiBawiBoMunni = null;
		String[] strGawiBawiBoMunni = {"Scissor", "Rock", "Paper"};
		panelGawiBawiBoMunni.setLayout(new GridLayout(1, strGawiBawiBoMunni.length));
		
		for (int i = 0; i < strGawiBawiBoMunni.length; i++) {
			buttonGawiBawiBoMunni = new JButton(strGawiBawiBoMunni[i]);
			buttonGawiBawiBoMunni.setFont(new Font("consolas", Font.BOLD, 15));
//			buttonGawiBawiBoMunni.setForeground(Color.BLUE);
//			buttonGawiBawiBoMunni.setBackground(Color.YELLOW);
			panelGawiBawiBoMunni.add(buttonGawiBawiBoMunni);
			add(panelGawiBawiBoMunni);
		}
	}
	
	private void panelComVsUser(){
		JTextField[] textComVsUser = {
				new JTextField("Computer"),
				new JTextField("Human")};
		JPanel panelComVsUser = new JPanel();
		panelComVsUser.setLayout(new GridLayout(1,textComVsUser.length));
	
		for (int i = 0; i < textComVsUser.length; i++) {
			textComVsUser[i].setHorizontalAlignment(JTextField.CENTER);
			textComVsUser[i].setFont(new Font("consolas", Font.BOLD, 25));
//			textComVsUser[i].setBackground(Color.RED);
			textComVsUser[i].setEditable(false);
			panelComVsUser.add(textComVsUser[i]); // GridLayout(1,1)
		}
		add(panelComVsUser);
	}
	
	private void panelComVsUserResult(){
		JButton[] ComVsUserResult = {
				new JButton(""),
				new JButton("")};
		JPanel panelComVsUser = new JPanel();
		panelComVsUser.setLayout(new GridLayout(1,ComVsUserResult.length));
	
		for (int i = 0; i < ComVsUserResult.length; i++) {
			ComVsUserResult[i].setHorizontalAlignment(JTextField.CENTER);
			ComVsUserResult[i].setFont(new Font("consolas", Font.BOLD, 15));
//			textComVsUser[i].setBackground(Color.RED);
			panelComVsUser.add(ComVsUserResult[i]); // GridLayout(1,1)
		}
		add(panelComVsUser);
	}
	
	private void panelFooter(){
		JTextField textFooter = new JTextField("Game Start");
		JButton gameStop = new JButton("Stop");
		JPanel panelFooter = new JPanel();
		panelFooter.setLayout(new GridLayout(1,2));
	
		textFooter.setHorizontalAlignment(JTextField.CENTER);
		textFooter.setFont(new Font("consolas", Font.BOLD, 20));
//		textHeader.setBackground(Color.RED);
		textFooter.setEditable(false);
		
		gameStop.setHorizontalAlignment(JTextField.CENTER);
		gameStop.setFont(new Font("consolas", Font.BOLD, 20));
//		textComVsUser[i].setBackground(Color.RED);
		
		panelFooter.add(textFooter); // GridLayout(1,1)
		panelFooter.add(gameStop); // GridLayout(1,2)
		add(panelFooter);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void play() {
		setLayout(new GridLayout(5, 1));
		panelHeader();
		panelGawiBawiBoMunni();
		panelComVsUser();
		panelComVsUserResult();
		panelFooter();
		
		setTitle("GawiBawiBoMunni");
		setSize(500, 600);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // window terminate
	}
	
	public static void main(String[] args) {
		GawiBawiBoMunni gbb = new GawiBawiBoMunni();
		gbb.play();
	}
}
