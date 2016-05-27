package javafx.join.update;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UpdateMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent update = FXMLLoader.load(getClass().getResource("update.fxml"));
		Scene scene = new Scene(update);
		
		primaryStage.setTitle("Update Page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
