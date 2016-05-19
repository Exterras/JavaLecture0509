package com.github.Exterras.gui.swing;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginSwingJoinMunni extends JFrame implements ActionListener {

	JPanel p;
	JTextField tfId; // ID
	JPasswordField pfPwd; // 비밀번호
	JButton btnCancel, btnLogin; // 취소, 삭제 버튼
	GridBagLayout gb;
	GridBagConstraints gbc;
	int x = 350;
	int y = 150;

	public LoginSwingJoinMunni() {
		super("로그인");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		// 아이디
		JLabel bId = new JLabel("아이디 : ");
		tfId = new JTextField(10);
		// 그리드백에 붙이기
		gbAdd(bId, 0, 0, 1, 1);
		gbAdd(tfId, 1, 0, 3, 1);

		// 비밀번호
		JLabel bPwd = new JLabel("비밀번호 : ");
		pfPwd = new JPasswordField(10);
		gbAdd(bPwd, 0, 1, 1, 1);
		gbAdd(pfPwd, 1, 1, 3, 1);

		// 버튼
		JPanel pButton = new JPanel();
        btnLogin = new JButton("로그인"); 
        btnCancel = new JButton("취소");  
        
        pButton.add(btnLogin);
        pButton.add(btnCancel); 

		gbAdd(pButton, 0, 3, 4, 1);
		
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);

		setSize(x, y);
		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.		

	}// 생성자

	// 그리드백레이아웃에 붙이는 메소드
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		// gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c, gbc);
	}// gbAdd
	
	

	public static void main(String[] args) {

		new LoginSwingJoinMunni();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

	}// actionPerformed
}// end

// [출처] [AWT/SWING] 배치관리자 [LayoutManager] - GridBagLayout으로 메일보내기창, 회원가입창
// 만들기.|작성자 자바킹
