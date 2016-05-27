package jimin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SwingInsert extends JFrame implements ActionListener{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();		
		String pw = new String(passwordField.getPassword());
		int cnt = 0;
		
		if( action.equals(button[0].getText()) ){
			for( int i=0; i< textField.length; i++){
				if(i==1 && pw.equals("")){
					label[7].setText("비밀번호를 입력하세요");
					passwordField.requestFocus();
					break;
				}
				if( textField[i].getText().equals("") ){
					label[7].setText(alert[i]);
					textField[i].requestFocus();
					break;
				}	
				cnt++;			
				
			}	
			System.out.println("cnt: " + cnt);
			if( cnt == 5 ){
				MemberDTO oDTO = new MemberDTO(
						textField[0].getText(),					
						textField[1].getText(),
						pw,
						textField[4].getText(),
						textField[2].getText(),
						textField[3].getText()				
				);
				MemberDAO oDAO= new MemberDAO();
				if( oDAO.mInsert(oDTO) != 0 ){
					label[7].setText("회원가입성공");
				}
			}
		}		
	}

	JPanel jpanel = new JPanel();
	
	JLabel [] label = new JLabel [8];
	JTextField [] textField = new JTextField [5];
	JPasswordField passwordField = new JPasswordField();
	JButton [] button = new JButton [2];
	JPanel []panel = new JPanel[9];
	JPanel [] outterPanel = new JPanel[3];
	String [] info = {"ID", "PW", "Name", "E-mail", "Phone", "Add", "message" };
	String [] alert = {"ID를 입력하세요", "이름을 입력하세요", "E-mail을 입력하세요", "E-전화번호를 입력하세요", "주소를 입력하세요"};
	
	SwingInsert(){	
		for( int i=0; i<textField.length; i++){
			textField[i] = new JTextField("");
		}
		for( int i=0; i<panel.length; i++){
			panel[i] = new JPanel();
		}
		for( int i=0; i<outterPanel.length; i++){
			outterPanel[i] = new JPanel();
		}
		for( int i=1; i<label.length; i++){
			label[i] = new JLabel(info[i-1], JLabel.CENTER);
			label[i].setFont( new Font("", Font.BOLD, 15));
		}
		passwordField.setFont( new Font("", Font.BOLD, 15));
		passwordField.setEchoChar('★');
		label[0] = new JLabel( new ImageIcon("./imgLotto/welcome2.jpg"));

		outterPanel[0].add(label[0]);
		jpanel.add(outterPanel[0],BorderLayout.NORTH);
		
		outterPanel[1].setLayout( new GridLayout(6,1));
		for( int i=0; i<textField.length+1; i++){
			panel[i].setLayout(new GridLayout(1,2));	
			panel[i].add(label[i+1]);
			if( i==0 ){
				panel[i].add(textField[i]);
				outterPanel[1].add(panel[i]);
			} else if( i==1){
				panel[i].add(passwordField);
				outterPanel[1].add(panel[i]);
			} else {
				panel[i].add(textField[i-1]);
				outterPanel[1].add(panel[i]);
			}
		}	
		
		jpanel.add(outterPanel[1],BorderLayout.CENTER);
		
		outterPanel[2].setLayout( new GridLayout(2,1));
		button[0] = new JButton("회원가입");
		button[1] = new JButton("가입취소");
		panel[6].add(button[0]);
		panel[6].add(button[1]);		
		panel[7].add(label[7]);
		outterPanel[2].add(panel[6]);	
		outterPanel[2].add(panel[7]);
		jpanel.add(outterPanel[2]);
		
		jpanel.setLayout(new GridLayout(3,1));
		
		add(jpanel);
		
		/* addActionListener */
		button[0].addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // window terminate
	}
	
	public static void main(String args[]){
		SwingInsert insert = new SwingInsert();
		insert.setSize(500,700);
		insert.setVisible(true);
		
	}
}
