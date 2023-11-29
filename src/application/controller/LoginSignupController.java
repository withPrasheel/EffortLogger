package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class LoginSignupController {
	@FXML
	private TextField tfTitle;
	
	private Stage primaryStage;
	
	@FXML Button viewStory;
	
	
	//Add close logic

	@FXML
	public void loginClicked(ActionEvent event) throws IOException {
		Stage primaryStage = (Stage) tfTitle.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("./../view/ChooseOptionScene.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
}
