package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EstimateSelectionSceneController {
	@FXML
	private AnchorPane anchorPlane;
	
	Stage primaryStage;

	// Event Listener on Button.onAction
	@FXML
	public void onEstimateClicked(ActionEvent event) {
		try {
			Stage secondaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("./../view/EstimateCardScene.fxml"));
			Scene scene = new Scene(root);
			secondaryStage.setScene(scene);
			secondaryStage.setTitle("Estimation Card");
			secondaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void backBtnClicked(ActionEvent event) throws IOException {
		primaryStage = (Stage) anchorPlane.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("./../view/ChooseOptionScene.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
