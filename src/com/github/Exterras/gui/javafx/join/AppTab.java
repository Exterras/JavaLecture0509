package com.github.Exterras.gui.javafx.join;

import com.github.Exterras.gui.javafx.join.delete.DeleteMain;
import com.github.Exterras.gui.javafx.join.insert.InsertMain;
import com.github.Exterras.gui.javafx.join.login.LoginMain;
import com.github.Exterras.gui.javafx.join.update.UpdateMain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AppTab extends Application {

    @Override
    public void start(Stage primaryStage) {
    	
    	AppMain main = new AppMain();
    	InsertMain join = new InsertMain();
    	UpdateMain update = new UpdateMain();
    	DeleteMain delete = new DeleteMain();
    	LoginMain login = new LoginMain();
    	
        primaryStage.setTitle("Tabs");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 800, Color.WHITE);
        
        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        String[] tabName = {
        		"Main",
        		"Join",
        		"Update",
        		"Delete",
        		"Login"
        };
        
        Object[] tabClass = {
        		main,
        		join,
        		update,
        		delete,
        		login
        };
       
        for (int i = 0; i < tabName.length; i++) {
            Tab tab = new Tab();
            tab.setText(tabName[i]);            
            HBox hbox = new HBox();
//            hbox.getChildren().add(new Label("Tab" + i));
            hbox.setAlignment(Pos.CENTER);
            tab.setContent(hbox);
            tabPane.getTabs().add(tab);
        }
        
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}