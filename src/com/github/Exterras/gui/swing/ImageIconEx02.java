package com.github.Exterras.gui.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ImageIconEx02 extends Frame{
	Panel panel = new Panel();
	
	private ImageIcon[] icon = {
			new ImageIcon("img/home.png"),
			new ImageIcon("img/profile.png"),
			new ImageIcon("img/picture.png"),
			new ImageIcon("img/coolsite.png"),
			new ImageIcon("img/email.png")
	};
	
	private JButton jBtn[] = new JButton[icon.length];
	private JLabel jLabel[] = new JLabel[icon.length];	
	
	private void button(){
		Image img = null;
		ImageIcon tempIcon = null;
//		for (int i = 0; i < jBtn.length; i++) {	
		for (int i = 0; i < jLabel.length; i++) {	
			
			img = icon[i].getImage();
			Image newimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			tempIcon = new ImageIcon(newimg);
//			jBtn[i] = new JButton(tempIcon);
			jLabel[i] = new JLabel(tempIcon);	
//			add(jBtn[i]);
			add(jLabel[i]);
			
		}
	}
	
	public void play(){
		setLayout(new FlowLayout());
		button();
//		setSize(800, 200); jBtn
		setSize(600, 200); //jLabel
//		setBackground(Color.WHITE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // window terminate
	}
	
	
	public static void main(String[] args) {
		ImageIconEx02 image = new ImageIconEx02();
		image.play();
	}
}
