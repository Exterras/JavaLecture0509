package com.github.Exterras.gui.javafx.join.delete;

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

public class DeleteController implements Initializable{

	@FXML TextField txtId;
	@FXML PasswordField txtPwd;
	
	@FXML Button btnDelete;
	@FXML Button btnCancel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				handleBtnDeleteAction(event);		
			
			}
		});
		
		btnCancel.setOnAction(event->handleBtnCancelAction(event));
	}
	
	private void handleBtnDeleteAction(ActionEvent event) {
		System.out.println("Click Delete");
		
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
		} else if (id.equals("")) {
			System.out.println("Input ID");
			error.setContentText("Input ID");
			error.showAndWait();
		} else if (pw.equals("")) {
			System.out.println("Input PWD");
			error.setContentText("Input PWD");
			error.showAndWait();
		} else {
			System.out.println("Delete Success!");
			confirmation.setContentText("Delete Success!");
			confirmation.showAndWait();
		}
	}
	
	private void handleBtnCancelAction(ActionEvent event) {
		System.out.println("Click Cancel");
		
		txtId.clear();
		txtPwd.clear();
	}

}
