package com.github.Exterras.gui.javafx.join;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppTab extends Application{
	
	public static String memberId = null;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("tab.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Main Page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

