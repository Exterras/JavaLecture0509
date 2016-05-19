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

public class UpdateSwingJoinMunni extends JFrame implements ActionListener {

	JPanel p;
	JTextField tfId, tfName, tfAddr, tfEmail;
	JTextField tfTel1, tfTel2, tfTel3; // 전화
	JComboBox cbJob; // 직업
	JPasswordField pfPwd; // 비밀번호
	JTextField tfYear, tfMonth, tfDate; // 생년월일
	JRadioButton rbMan, rbWoman; // 남, 여
	JTextArea taIntro;
	JButton btnCancel, btnUpdate; // 취소, 수정 버튼
	GridBagLayout gb;
	GridBagConstraints gbc;

	public UpdateSwingJoinMunni() {
		super("회원수정");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		// 아이디
		JLabel bId = new JLabel("아이디 : ");
		JPanel pId = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfId = new JTextField(10);
		// 그리드백에 붙이기
		pId.add(tfId);
		gbAdd(bId, 0, 0, 1, 1);
		gbAdd(pId, 1, 0, 3, 1);

		// 비밀번호
		JLabel bPwd = new JLabel("비밀번호 : ");
		JPanel pPwd = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pfPwd = new JPasswordField(10);
		pPwd.add(pfPwd);
		gbAdd(bPwd, 0, 1, 1, 1);
		gbAdd(pPwd, 1, 1, 3, 1);

		// 이름
		JLabel bName = new JLabel("이름 :");
		JPanel pName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfName = new JTextField(10);
		pName.add(tfName);
		gbAdd(bName, 0, 2, 1, 1);
		gbAdd(pName, 1, 2, 3, 1);

		// 전화
		JLabel bTel = new JLabel("전화 :");
		JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfTel1 = new JTextField(3);
		tfTel2 = new JTextField(4);
		tfTel3 = new JTextField(4);
		pTel.add(tfTel1);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel2);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel3);
		gbAdd(bTel, 0, 3, 1, 1);
		gbAdd(pTel, 1, 3, 3, 1);

		// 주소
		JLabel bAddr = new JLabel("주소: ");
		JPanel pAddr = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfAddr = new JTextField(20);
		pAddr.add(tfAddr);
		gbAdd(bAddr, 0, 4, 1, 1);
		gbAdd(pAddr, 1, 4, 3, 1);

		// 생일
		JLabel bBirth = new JLabel("생일: ");
		tfYear = new JTextField(4);
		tfMonth = new JTextField(2);
		tfDate = new JTextField(2);
		JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBirth.add(tfYear);
		pBirth.add(new JLabel("년 "));
		pBirth.add(tfMonth);
		pBirth.add(new JLabel("월 "));
		pBirth.add(tfDate);
		pBirth.add(new JLabel("일 "));
		gbAdd(bBirth, 0, 5, 1, 1);
		gbAdd(pBirth, 1, 5, 3, 1);

		// 직업
		JLabel bJob = new JLabel("직업 : ");
		String[] arrJob = { "---", "학생", "직장인", "주부" };
		cbJob = new JComboBox(arrJob);
		JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pJob.add(cbJob);
		gbAdd(bJob, 0, 6, 1, 1);
		gbAdd(pJob, 1, 6, 3, 1);

		// 성별
		JLabel bGender = new JLabel("성별 : ");
		JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rbMan = new JRadioButton("남", true);
		rbWoman = new JRadioButton("여", true);
		ButtonGroup group = new ButtonGroup();
		group.add(rbMan);
		group.add(rbWoman);
		pGender.add(rbMan);
		pGender.add(rbWoman);
		gbAdd(bGender, 0, 7, 1, 1);
		gbAdd(pGender, 1, 7, 3, 1);

		// 이메일
		JLabel bEmail = new JLabel("이메일 : ");
		JPanel pEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfEmail = new JTextField(20);
		pEmail.add(tfEmail);
		gbAdd(bEmail, 0, 8, 1, 1);
		gbAdd(pEmail, 1, 8, 3, 1);

		// 자기소개
		JLabel bIntro = new JLabel("자기 소개: ");
		JPanel pIntro = new JPanel(new FlowLayout(FlowLayout.LEFT));
		taIntro = new JTextArea(5, 20); // 행 : 열
		JScrollPane pane = new JScrollPane(taIntro);
		pIntro.add(pane);
		gbAdd(bIntro, 0, 9, 1, 1);
		gbAdd(pIntro, 1, 9, 3, 1);

		// 버튼
		JPanel pButton = new JPanel();
        btnUpdate = new JButton("수정"); 
        btnCancel = new JButton("취소");  
        
        pButton.add(btnUpdate);
        pButton.add(btnCancel); 

		gbAdd(pButton, 0, 10, 4, 1);
		
        btnUpdate.addActionListener(this);
        btnCancel.addActionListener(this);

		setSize(350, 500);
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

		new UpdateSwingJoinMunni();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

	}// actionPerformed
}// end

// [출처] [AWT/SWING] 배치관리자 [LayoutManager] - GridBagLayout으로 메일보내기창, 회원가입창
// 만들기.|작성자 자바킹
