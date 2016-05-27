package javafx.join.insert;

import com.github.Exterras.gui.javafx.join.db.MemberDAO;
import com.github.Exterras.gui.javafx.join.db.MemberDTO;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InsertController implements Initializable{

	@FXML TextField txtId;
	@FXML PasswordField txtPwd;
	@FXML TextField txtName;
	@FXML TextField txtEmail;
	@FXML TextField txtPhone;
	@FXML TextField txtAddress;
	
	@FXML Button btnJoin;
	@FXML Button btnCancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnJoin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				handleBtnJoinAction(event);	
			}
		});
		
		btnCancel.setOnAction(event->handleBtnCancelAction(event));
	}
	
	private void handleBtnJoinAction(ActionEvent event) {
		System.out.println("Click Join");
		
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
		} else if (pw.equals("")) {
			System.out.println("Input PWD");
			error.setContentText("Input PWD");
			error.showAndWait();
		} else if (name.equals("")) {
			System.out.println("Input Name");
			error.setContentText("Input Name");
			error.showAndWait();
		} else if (email.equals("")) {
			System.out.println("Input Email");
			error.setContentText("Input Email");
			error.showAndWait();
		} else if (phone.equals("")) {
			System.out.println("Input Phone");
			error.setContentText("Input Phone");
			error.showAndWait();
		} else if (address.equals("")) {
			System.out.println("Input Address");
			error.setContentText("Input Address");
			error.showAndWait();
		} else { 
			
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPwd(pw);
			dto.setName(name);
			dto.setEmail(email);
			dto.setPhone(phone);
			dto.setAddr(address); 
			 
			if(isJoin(dto)){
				System.out.println("Join Success!");
				confirmation.setContentText("Join Success!");
				
			}else{
				System.out.println("Join Fail!");
				confirmation.setContentText("Join Fail!");
			} 
			confirmation.showAndWait(); 
		}
	}
	
	private boolean isJoin(MemberDTO dto){		
		boolean isSuccess = false;
		MemberDAO dao = new MemberDAO();
		int chk = dao.insert(dto);
		
		if(chk != 0){
			isSuccess = true;
		}
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
