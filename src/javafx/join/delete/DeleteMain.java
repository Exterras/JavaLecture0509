package javafx.join.delete;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DeleteMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent delete = FXMLLoader.load(getClass().getResource("delete.fxml"));
		Scene scene = new Scene(delete);
		
		primaryStage.setTitle("Delete Page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
