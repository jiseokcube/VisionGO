/*
 * File Name: Main.java
 * Project: VisionGO
 * Author: Jiseok Choi, Chloe Choi
 * Start Date: 12/23/2016
 * End Date: 
 * Description: This is the main class file that launches the application.
 */

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("Application.fxml"));
    
        Scene scene = new Scene(root, 300, 275);
    
        stage.setTitle("VisionGO");
        stage.setScene(scene);
        stage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
