package com.github.Exterras.gui.swing;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LottoImgV01Munni extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int GRID_LAYOUT_ROWS = 3;
	private static final int GRID_LAYOUT_COLS = 1;

	private ImageIcon[] titleImgIcon = { new ImageIcon("img/Lotto.jpg") };
	private ImageIcon[] numImgIcon = new ImageIcon[7];
	private JLabel[] arrLabelGL2 = new JLabel[7];
	private ImageIcon[] btnimgIcon = { 
			new ImageIcon("img/lottoStart.jpg"), 
			new ImageIcon("img/lottoStop.jpg") };

	private void drawLayout() {
		setLayout(new GridLayout(GRID_LAYOUT_ROWS, GRID_LAYOUT_COLS));

		JPanel[] arrJPanel = new JPanel[GRID_LAYOUT_ROWS];
		JLabel label = null;
		JButton button = null;

		for (int i = 0; i < arrJPanel.length; i++) {
			arrJPanel[i] = new JPanel();
			arrJPanel[i].setLayout(new GridLayout(1, 1));
			switch (i) {
			case 0: // GridLayout(1,1)
				label = new JLabel(imgSingleSizeControl(480, 150, titleImgIcon, 0));
				arrJPanel[0].add(label);
				break;
			case 1: // GridLayout(2,1)
				label = new JLabel("Number", JLabel.CENTER);
				for (int j = 0; j < numImgIcon.length; j++) {
					if (j == numImgIcon.length - 1) {
						numImgIcon[j] = new ImageIcon("img/p.png");
						label = new JLabel(imgSingleSizeControl(50, 50, numImgIcon, j));
						arrJPanel[1].add(label);
					}

					numImgIcon[j] = new ImageIcon("img/q.jpg");
					arrLabelGL2[j] = new JLabel(imgSingleSizeControl(50, 50, numImgIcon, j));
					arrJPanel[1].add(arrLabelGL2[j]);
				}
				break;
			case 2: // GridLayout(3,1)
				button = new JButton(imgSingleSizeControl(225, 125, btnimgIcon, 0));
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					}
				});
				arrJPanel[2].add(button);
				
				button = new JButton(imgSingleSizeControl(225, 125, btnimgIcon, 1));
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				arrJPanel[2].add(button);
				break;
			default:
				break;
			}
			add(arrJPanel[i]);
		}
	}

	private ImageIcon imgSingleSizeControl(int width, int height, ImageIcon[] imgIcon, int index) {
		ImageIcon tempImgIcon = new ImageIcon(
				imgIcon[index].getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		return tempImgIcon;
	} // image size change method

	public void play() {
		drawLayout();

		setTitle("LottoImgV01Munni");
		setSize(500, 600);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // window terminate
	}

	public static void main(String[] args) {
		LottoImgV01Munni lotto = new LottoImgV01Munni();
		lotto.play();
	}
}
