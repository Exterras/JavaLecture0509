package com.github.Exterras.gui.javafx.join.insert;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InsertMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent insert = FXMLLoader.load(getClass().getResource("insert.fxml"));
		Scene scene = new Scene(insert);
		
		primaryStage.setTitle("Join Page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
