package com.github.Exterras.gui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AwtSwing extends JFrame{
	
	String htmlLabel01;
	String htmlLabel02;
	String htmlLabel03;
	
	private void htmlLabel(){
		htmlLabel01 = "";
		htmlLabel02 = "";
		htmlLabel03 = "";
	}
	
	private void drawLayout(){
		Container container = new Container();
		JPanel panel01 = new JPanel();
		JPanel panel02 = new JPanel();
		JPanel panel03 = new JPanel();
		
		JLabel label01 = new JLabel(htmlLabel01);
		JLabel label02 = new JLabel(htmlLabel02);
		JLabel label03 = new JLabel(htmlLabel03);
		
		container.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		panel01.setLayout(new FlowLayout());
		panel01.setBackground(Color.RED);
		panel01.setPreferredSize(new Dimension(600, 100));
		container.add(panel01);
		
		panel02.setLayout(new FlowLayout());
		panel02.setBackground(Color.BLACK);
		panel02.setPreferredSize(new Dimension(600, 400));
		container.add(panel02);
		
		panel03.setLayout(new FlowLayout());
		panel03.setBackground(Color.BLUE);
		panel03.setPreferredSize(new Dimension(600, 100));
		container.add(panel03);
		
		add(container);
	}
	
	public void play(){
		setTitle("AwtSwing");
		setSize(600, 635);
		
		drawLayout();
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		AwtSwing awtSwing = new AwtSwing();
		awtSwing.play();
	}
}
