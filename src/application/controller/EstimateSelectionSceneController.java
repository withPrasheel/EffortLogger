package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.ArrayList;

import application.helper.Story;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EstimateSelectionSceneController {
	@FXML
	private AnchorPane anchorPlane;
	
	Stage primaryStage;
	
	ArrayList<Story> storyList;

	// Event Listener on Button.onAction
//	@FXML
//	public void onEstimateClicked(ActionEvent event) {
//		try {
//			Stage secondaryStage = new Stage();
//			Parent root = FXMLLoader.load(getClass().getResource("./../view/EstimateCardScene.fxml"));
//			Scene scene = new Scene(root);
//			secondaryStage.setScene(scene);
//			secondaryStage.setTitle("Estimation Card");
//			secondaryStage.show();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@FXML
	public void onEstimateClicked(ActionEvent event) {
	    storyList = new ArrayList<>();

	    double totalEstTime = 0;

	    for (Story story : storyList) {
	        totalEstTime += story.getEstimationTime();
	    }

	    double averageEstTime = totalEstTime / storyList.size();

	    System.out.println("Average Estimated Time: " + averageEstTime);

	    VBox root = new VBox(); // Use VBox for vertical arrangement
	    Stage stage = new Stage();

	    Text averageTimeText = new Text("Estimated Story Point: " + averageEstTime);
	    Text estTime = new Text("Estimated Time: " + averageEstTime);

	    root.getChildren().addAll(averageTimeText, estTime); // Add both Text nodes to VBox

	    Scene scene = new Scene(root, 400, 400);
	    stage.setScene(scene);
	    stage.show();
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
