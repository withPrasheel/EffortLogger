package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.helper.FileOperations;
import javafx.fxml.Initializable;
import application.helper.Story;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import application.helper.*;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class EstimateSelectionSceneController implements Initializable {
	@FXML
	private AnchorPane anchorPlane;
	
	Stage primaryStage;
	
	//behold, the mess of FXML items to get everything to work.
	@FXML
	private Text storyID1;
	@FXML
	private Text storyName1;
	@FXML
	private Text estimatedTime1;
	@FXML
	private Text storyPoints1;
	@FXML
	private CheckBox checkBox1;
	
	@FXML
	private Text storyID2;
	@FXML
	private Text storyName2;
	@FXML
	private Text estimatedTime2;
	@FXML
	private Text storyPoints2;
	@FXML
	private CheckBox checkBox2;
	
	@FXML
	private Text storyID3;
	@FXML
	private Text storyName3;
	@FXML
	private Text estimatedTime3;
	@FXML
	private Text storyPoints3;
	@FXML
	private CheckBox checkBox3;
	
	@FXML
	private Text storyID4;
	@FXML
	private Text storyName4;
	@FXML
	private Text estimatedTime4;
	@FXML
	private Text storyPoints4;
	@FXML
	private CheckBox checkBox4;
	
	@FXML
	private Text storyID5;
	@FXML
	private Text storyName5;
	@FXML
	private Text estimatedTime5;
	@FXML
	private Text storyPoints5;
	@FXML
	private CheckBox checkBox5;
	
	@FXML
	private Text storyID6;
	@FXML
	private Text storyName6;
	@FXML
	private Text estimatedTime6;
	@FXML
	private Text storyPoints6;
	@FXML
	private CheckBox checkBox6;
	
	ArrayList<Story> storyList = FileOperations.readCSVFile("./src/application/resources/Stories.csv");

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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//This is so that the function starts right away. It's Separate because it's more readable to me.
		System.out.println("Selection of Estimated Stories has statred!");
		
		//Whole job here is to dynamically build up a quick chart of items with a checkbox, which 
		//on onEstimateClicked will be able to check the items of in order to work through. Also, 
		//it will update numOfCheckBoxes so that it's easier for me to be sure 'oh ya I've hit the
		//end here'. 
		int howFar = 0;
		for (Story story : storyList) {
		    howFar++; //mildly hacky way to do it, but it should work.
		    
		    //This should make it so that, for the 6 available slots, it should work. 
		    switch (howFar) {
		    case 1: firstEstimateRow(story.getStoryId(), story.getStoryName(), String.valueOf(story.getEstimationTime()), String.valueOf(story.getStoryPoints()));
		    	break;
		    case 2: secondEstimateRow(story.getStoryId(), story.getStoryName(), String.valueOf(story.getEstimationTime()), String.valueOf(story.getStoryPoints()));
		    	break;
		    case 3: thirdEstimateRow(story.getStoryId(), story.getStoryName(), String.valueOf(story.getEstimationTime()), String.valueOf(story.getStoryPoints()));
		    	break;
		    case 4: forthEstimateRow(story.getStoryId(), story.getStoryName(), String.valueOf(story.getEstimationTime()), String.valueOf(story.getStoryPoints()));
		    	break;
		    case 5: fifthEstimateRow(story.getStoryId(), story.getStoryName(), String.valueOf(story.getEstimationTime()), String.valueOf(story.getStoryPoints()));
		    	break;
		    case 6: sixthEstimateRow(story.getStoryId(), story.getStoryName(), String.valueOf(story.getEstimationTime()), String.valueOf(story.getStoryPoints()));
		    	break;
		    default: //do nothing
		    	break;
		    	
		    }
			
			
		   
		}

		
		
	}
	
	@FXML
	public void onEstimateClicked(ActionEvent event) {
	    

	    double totalEstTime = 0;
	    int howManySelected = 0;
	    double totalStoryPoints = 0.0;
	    int order = 0;
	    for (Story story : storyList) {
	    	
	    	//Grab the estimates from ONLY THOSE THAT HAVE A CHECKMARK.
	    	if (checkBox1.isSelected() && order == 0){
	    		totalEstTime += story.getEstimationTime();	    
	    		howManySelected++;
	    		totalStoryPoints += story.getStoryPoints();
	    		System.out.println("You selected 1!!!!!!");
	    	} else if (checkBox2.isSelected() && order == 1) {
	    		totalEstTime += story.getEstimationTime();
	    		howManySelected++;
	    		totalStoryPoints += story.getStoryPoints();
	    		System.out.println("You selected 2!!!!!!");
	    	} else if (checkBox3.isSelected() && order == 2) {
	    		totalEstTime += story.getEstimationTime();
	    		howManySelected++;
	    		totalStoryPoints += story.getStoryPoints();
	    		System.out.println("You selected 3!!!!!!");
	    	} else if (checkBox4.isSelected() && order == 3) {
	    		totalEstTime += story.getEstimationTime();
	    		howManySelected++;
	    		totalStoryPoints += story.getStoryPoints();
	    		System.out.println("You selected 4!!!!!!");
	    	} else if (checkBox5.isSelected() && order == 4) {
	    		totalEstTime += story.getEstimationTime();
	    		howManySelected++;
	    		totalStoryPoints += story.getStoryPoints();
	    		System.out.println("You selected 5!!!!!!");
	    	} else if (checkBox6.isSelected() && order == 5) {
	    		totalEstTime += story.getEstimationTime();
	    		howManySelected++;
	    		totalStoryPoints += story.getStoryPoints();
	    		System.out.println("You selected 6!!!!!!");
	    	}
	    	System.out.println("The story here is " + story.getStoryName());
	    	order++;
	    }

	    double averageEstTime = totalEstTime / howManySelected;
	    double averageStoryPoints = totalStoryPoints / howManySelected;

	    System.out.println("Average Estimated Time: " + averageEstTime);
	    

	    VBox root = new VBox(); // Use VBox for vertical arrangement
	    Stage stage = new Stage();

	    Text averageTimeText = new Text("Estimated Story Point: " + averageStoryPoints);
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
	
	
	
	//Whole job here is to take in inputs and add them dynamically. Ish.
	public void firstEstimateRow(String storyID, String storyName, String expectedTime, String storyPoints) {
		storyID1.setText(storyID);
		storyName1.setText(storyName);
		estimatedTime1.setText(expectedTime);
		storyPoints1.setText(storyPoints);
		checkBox1.setOpacity(1);
	}
	
	public void secondEstimateRow(String storyID, String storyName, String expectedTime, String storyPoints) {
		storyID2.setText(storyID);
		storyName2.setText(storyName);
		estimatedTime2.setText(expectedTime);
		storyPoints2.setText(storyPoints);
		checkBox2.setOpacity(1);
	}
	
	public void thirdEstimateRow(String storyID, String storyName, String expectedTime, String storyPoints) {
		storyID3.setText(storyID);
		storyName3.setText(storyName);
		estimatedTime3.setText(expectedTime);
		storyPoints3.setText(storyPoints);
		checkBox3.setOpacity(1);
	}
	
	public void forthEstimateRow(String storyID, String storyName, String expectedTime, String storyPoints) {
		storyID4.setText(storyID);
		storyName4.setText(storyName);
		estimatedTime4.setText(expectedTime);
		storyPoints4.setText(storyPoints);
		checkBox4.setOpacity(1);
	}
	
	public void fifthEstimateRow(String storyID, String storyName, String expectedTime, String storyPoints) {
		storyID5.setText(storyID);
		storyName5.setText(storyName);
		estimatedTime5.setText(expectedTime);
		storyPoints5.setText(storyPoints);
		checkBox5.setOpacity(1);
	}
	
	public void sixthEstimateRow(String storyID, String storyName, String expectedTime, String storyPoints) {
		storyID5.setText(storyID);
		storyName5.setText(storyName);
		estimatedTime5.setText(expectedTime);
		storyPoints5.setText(storyPoints);
		checkBox5.setOpacity(1);
	}
	
}
