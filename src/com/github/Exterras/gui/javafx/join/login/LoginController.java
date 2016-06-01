package com.github.Exterras.gui.javafx.join.login;

import com.github.Exterras.gui.javafx.join.AppTab;
import com.github.Exterras.gui.javafx.join.db.MemberDAO;
import com.github.Exterras.gui.javafx.join.db.MemberDTO;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class LoginController implements Initializable{

	@FXML TextField txtId;
	@FXML PasswordField txtPwd;
	
	@FXML Button btnLogin;
	@FXML Button btnCancel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				handleBtnLoginAction(event);		
			
			}
		});
		
		btnCancel.setOnAction(event->handleBtnCancelAction(event));
	}
	
	private void handleBtnLoginAction(ActionEvent event) {
		System.out.println("Click Login");
		
		String id = txtId.getText();
		String pw = txtPwd.getText();
		
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Error");
		
		Alert confirmation = new Alert(AlertType.CONFIRMATION);
		confirmation.setTitle("None");
		
		if(id.equals("") && pw.equals("")){
			System.out.println("Input ID and PWD");
			error.setContentText("Input ID and PWD");
			error.showAndWait();
			txtId.requestFocus();
		} else if (id.equals("")) {
			System.out.println("Input ID");
			error.setContentText("Input ID");
			error.showAndWait();
			txtId.requestFocus();
		} else if (pw.equals("")) {
			System.out.println("Input PWD");
			error.setContentText("Input PWD");
			error.showAndWait();
			txtPwd.requestFocus();
		} else {
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPwd(pw);

			if(isLogin(dto)){
				System.out.println("Login Success!");
				confirmation.setContentText("Login Success!");
				AppTab.memberId = id;
				
			}else{
				System.out.println("Login Fail!");
				confirmation.setContentText("Login Fail!");
			} 
			confirmation.showAndWait(); 
		}
	}
	
	private boolean isLogin(MemberDTO dto){		
		boolean isSuccess = false;
		MemberDAO dao = new MemberDAO();
		
		if(dao.login(dto)){
			isSuccess = true;
		}
		return isSuccess;
	}
	
	private void handleBtnCancelAction(ActionEvent event) {
		System.out.println("Click Cancel");
		
		txtId.clear();
		txtPwd.clear();
	}
	
}
