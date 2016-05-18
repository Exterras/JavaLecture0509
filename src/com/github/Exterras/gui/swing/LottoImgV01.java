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

public class LottoImgV01 extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int GRID_LAYOUT_ROWS = 3;
	private static final int GRID_LAYOUT_COLS = 1;

	private ImageIcon[] titleImgIcon = { new ImageIcon("img/Lotto.jpg") };
	private ImageIcon[] numImgIcon = new ImageIcon[7];
	private JLabel[] arrLabelGL2 = new JLabel[7];
	private ImageIcon[] btnimgIcon = { 
			new ImageIcon("img/lottoStart.jpg"), 
			new ImageIcon("img/lottoStop.jpg") };

	// private String htmlJLabel0
	// = "<html> "
	// + "<div class="
	// + "\""+ "lottoImg"+ "\"" +"name="+ "\""+ "lottoImg" + "\""+ ">"
	// + "<img class=" + "\""+ "lottoTitle" + "\""
	// + "src=../img/chr/lotto.jpg>"
	// + "</div>"
	// + "</html>";
	// private String htmlJLabel1;
	// private String htmlJLabel2;

	private void drawLayout() {
		setLayout(new GridLayout(GRID_LAYOUT_ROWS, GRID_LAYOUT_COLS));

		JPanel[] arrJPanel = new JPanel[GRID_LAYOUT_ROWS];
		JLabel label = null;
		JButton button = null;

//		String[] strJPanel2 = { "Out", "Stop" };

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
						 setLottoResult();
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
	}
	
	private void setLottoResult(){
		String imgUrl = null; 
		int[] lottoNum = new int[numImgIcon.length];
		
		for(int i=0; i < numImgIcon.length; i++){	
			lottoNum[i] = (int)(Math.random()*45 + 1);
			
			for (int j = 0; j < i; j++) {
				if (lottoNum[i] == lottoNum[j]) {
					i--;
					break;
				}
			} // de-duplication
			
			if(i != numImgIcon.length-1){ 
				// lotto Main Number Roll, include sorting
				for (int j = 0; j < lottoNum.length; j++) {
					int tempValue = 0;
					if (lottoNum[i] < lottoNum[j]) {
						tempValue = lottoNum[j];
						lottoNum[j] = lottoNum[i];
						lottoNum[i] = tempValue;
					}
				} 
			} else { 
				// Bonus Number Re-Roll, not include sorting
			}
			
		} // Lotto Processing Loof
		
		for (int i = 0; i < numImgIcon.length; i++) {
			if(lottoNum[i] < 10){
				imgUrl = "b0"+lottoNum[i]+".gif";
			}else{
				imgUrl = "b"+lottoNum[i]+".gif";
			}  
			
			arrLabelGL2[i].setIcon(new ImageIcon("img/"+imgUrl));
		} // Lotto Print Loof
	}

	public void play() {
		drawLayout();

		setTitle("LottoImgV01");
		setSize(500, 600);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // window terminate
	}

	public static void main(String[] args) {
		LottoImgV01 lotto = new LottoImgV01();
		lotto.play();
	}
}
