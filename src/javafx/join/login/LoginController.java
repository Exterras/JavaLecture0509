package javafx.join.login;

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
		} else if (id.equals("")) {
			System.out.println("Input ID");
			error.setContentText("Input ID");
			error.showAndWait();
		} else if (pw.equals("")) {
			System.out.println("Input PWD");
			error.setContentText("Input PWD");
			error.showAndWait();
		} else {
			System.out.println("Login Success!");
			confirmation.setContentText("Login Success!");
			confirmation.showAndWait();
			
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPwd(pw);

			if(isLogin(dto)){
				System.out.println("Login Success!");
				confirmation.setContentText("Login Success!");
				
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
	}
	
}
