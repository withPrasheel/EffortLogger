package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.helper.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//Job here is to read the readCSVFile to read and display everything.
public class ViewStoriesController implements Initializable {
	//read the file / grab the info
	ArrayList<Story> storyList = FileOperations.readCSVFile("./src/application/resources/Stories.csv");
	
	//Idea here is to separate them out so that, as the controller of ViewStories, they can see it. So, let's
	//make sure that we can actually control the scene first before doing anything else. 
	
	//This was taken directly from ChooseOptionSceneController for the going back function.
	@FXML
	private AnchorPane anchorPlane;
	
	Stage primaryStage;

	
	
	//This is for this controller.
	@FXML
	private TextArea storyIDTextArea;
	
	@FXML
	private TextArea storyNameTextArea;
	
	@FXML
	private TextArea expectedTimeTextArea;
	
	@FXML
	private TextArea storyPointsTextArea;
	
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//This is so that the function starts right away. It's Separate because it's more readable to me.
		System.out.println("View Stories has started!");
		displayStories();
	}
	
		//Now, for the actual method that will handle everything relevant (for the storyList should have all the stories)
		//this WILL start up automatically, if it doesn't we have a different issue.	
		public void displayStories() {
			
			String storyIDsend = "", storyNamesend = "", expectedTimesend = "", storyPointssend = "";
			
			//Loop formatting is as such:
			//Call upon the list, call the item in i part of list
			//Using pre-made strings, add relevant item to relevant string with a \n at the end
			//repeat until empty/null
			//then add those to the relevant text areas
			
			for (Story story : storyList) {
				//This action is done PER LOOP
				storyIDsend += story.getStoryId() + "\n";
				storyNamesend += story.getStoryName() + "\n";
				expectedTimesend += String.valueOf(story.getEstimationTime()) + "\n";
				storyPointssend += String.valueOf(story.getStoryPoints()) + "\n";
			}
			
			//Once it reaches this point, it should be as easy as just set it and we're done.
			storyIDTextArea.setText(storyIDsend);
			storyNameTextArea.setText(storyNamesend);
			expectedTimeTextArea.setText(expectedTimesend);
			storyPointsTextArea.setText(storyPointssend);
			
		}
		
		//This is taken from other parts of the code, thanks Prasheel for making this! It's job is to return
		//back to where we need to go.
		
		// Event Listener on Button.onAction
		@FXML
		public void backBtnClicked(ActionEvent event) throws IOException {
			primaryStage = (Stage) anchorPlane.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("./../view/ChooseOptionScene.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			System.out.println("You've backed out of View Stories!")
		}
	
}
