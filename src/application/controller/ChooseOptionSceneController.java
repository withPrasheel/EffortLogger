package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChooseOptionSceneController {
	@FXML
	private AnchorPane anchorPlane;
	
	Stage primaryStage;

	// Event Listener on Button.onAction
	@FXML
	public void onCreateStoryBtnClicked(ActionEvent event) throws IOException {
		primaryStage = (Stage) anchorPlane.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("./../view/CreateStoryScene.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Event Listener on Button.onAction
	@FXML
	public void onEstimateBtnClicked(ActionEvent event) throws IOException {
		primaryStage = (Stage) anchorPlane.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("./../view/EstimateSelectionScene.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Event Listener on Button.onAction
	@FXML
	public void onViewStoriesBtnClicked(ActionEvent event) throws IOException {
		primaryStage = (Stage) anchorPlane.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("./../view/ViewStoriesScene.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Event Listener on Button.onAction
	@FXML
	public void backBtnClicked(ActionEvent event) throws IOException {
		primaryStage = (Stage) anchorPlane.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("./../view/LoginSignupScene.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Event Listener on Button.onAction
	@FXML
	public void closeBtnClicked(ActionEvent event) {
		primaryStage  = (Stage) anchorPlane.getScene().getWindow();
		System.out.println("You successfully closed");
		primaryStage.close();
	}
}
