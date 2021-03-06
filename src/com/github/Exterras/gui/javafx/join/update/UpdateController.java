package com.github.Exterras.gui.javafx.join.update;

import java.net.URL;
import java.util.ResourceBundle;

import com.github.Exterras.gui.javafx.join.AppTab;
import com.github.Exterras.gui.javafx.join.db.MemberDAO;
import com.github.Exterras.gui.javafx.join.db.MemberDTO;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UpdateController implements Initializable{

	@FXML public static TextField txtId;
	@FXML public static PasswordField txtPwd;
	@FXML public static TextField txtName;
	@FXML public static TextField txtEmail;
	@FXML public static TextField txtPhone;
	@FXML public static TextField txtAddress;
	
	@FXML Button btnUpdate;
	@FXML Button btnCancel;
	
	public void setFieldData(){ 
		if (AppTab.memberId != null) {
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.getMemberData(AppTab.memberId);  
			setTextMemberDTO(dto); 
		}
	}
	
	public void setTextMemberDTO(MemberDTO dto){
		txtId.setText(dto.getId());
		txtPwd.setText(dto.getPwd());
		txtName.setText(dto.getName());
		txtEmail.setText(dto.getEmail());
		txtPhone.setText(dto.getPhone());
		txtAddress.setText(dto.getAddr());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				handleBtnUpdateAction(event);		
			
			}
		});
		
		btnCancel.setOnAction(event->handleBtnCancelAction(event));
	}
	
	private void handleBtnUpdateAction(ActionEvent event) {
		System.out.println("Click Update");
		
		String id = txtId.getText();
		String pw = txtPwd.getText();
		String name = txtName.getText();
		String email = txtEmail.getText();
		String phone = txtPhone.getText();
		String address = txtAddress.getText();
		
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
		} else if (name.equals("")) {
			System.out.println("Input Name");
			error.setContentText("Input Name");
			error.showAndWait();
			txtName.requestFocus();
		} else if (email.equals("")) {
			System.out.println("Input Email");
			error.setContentText("Input Email");
			error.showAndWait();
			txtEmail.requestFocus();
		} else if (phone.equals("")) {
			System.out.println("Input Phone");
			error.setContentText("Input Phone");
			error.showAndWait();
			txtPhone.requestFocus();
		} else if (address.equals("")) {
			System.out.println("Input Address");
			error.setContentText("Input Address");
			error.showAndWait();
			txtAddress.requestFocus();
		} else {
			MemberDTO dto = new MemberDTO();
			
			dto.setId(id);
			dto.setPwd(pw);
			dto.setName(name);
			dto.setEmail(email);
			dto.setPhone(phone);
			dto.setAddr(address); 
			 
			if(isUpdate(dto)){
				System.out.println("Update Success!");
				confirmation.setContentText("Update Success!");
				
			}else{
				System.out.println("Update Fail!");
				confirmation.setContentText("Update Fail!");
			} 
			confirmation.showAndWait(); 
		}
	}
	
	private boolean isUpdate(MemberDTO dto){		
		MemberDAO dao = new MemberDAO();
		boolean isSuccess = dao.update(dto);
		return isSuccess;
	}
	
	private void handleBtnCancelAction(ActionEvent event) {
		System.out.println("Click Cancel");
		
		txtId.clear();
		txtPwd.clear();
		txtName.clear();
		txtEmail.clear();
		txtPhone.clear();
		txtAddress.clear();
		
	}
	
}
