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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

//Job here is to read the readCSVFile to read and display everything.
public class StoryInputsController implements Initializable {
	
    ArrayList<Story> storyList = new ArrayList<Story>();

    public static void main(String[] args) {
        // Access the class member directly
        StoryInputsController controller = new StoryInputsController();
        FileOperations.writeCSVFile("./src/application/resources/Stories.csv", controller.storyList);
    }
	//Idea here is to separate them out so that, as the controller of ViewStories, they can see it. So, let's
	//make sure that we can actually control the scene first before doing anything else. 
	
    
	@FXML
	private AnchorPane anchorPlane;
	
	Stage primaryStage;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Button submitButton;
	
	@FXML
	private TextField storyNameText;
	
	@FXML
	private TextField storyIDText;
	
	@FXML
	private TextField storyPointsText;
	
	@FXML
	private TextField estimationTimeText;
	
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Story Inputs has started!");
	}
		
		// Event Listener on Button.onAction
	@FXML
	public void backBtnClicked(ActionEvent event) throws IOException {
		primaryStage = (Stage) anchorPlane.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("./../view/ChooseOptionScene.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("You've backed out of Story Inputs!");
	}
		
		public void submitBtnClicked(ActionEvent event) {
		    String storyName = storyNameText.getText();
		    String storyId = storyIDText.getText();
		    int storyPoints = 0;
		    int estimationTime = 0;
		    
		    try {
		        storyPoints = Integer.parseInt(storyPointsText.getText());
		        estimationTime = Integer.parseInt(estimationTimeText.getText());
		    } catch (NumberFormatException e) {
		        System.err.println("Invalid integer format for points or time.");
		        // Handle the error as needed, e.g., display a message to the user
		        return;
		    }

		        // Validate input if necessary
		    if (storyName.isEmpty() || storyId.isEmpty()) {
		        System.err.println("Please fill in all fields.");
		        return; // Don't proceed if any field is empty
		    }
		        // Create a new Story object
		        Story newStory = new Story(storyName, storyId, storyPoints, estimationTime);

		        // Add the new story to the list
		        storyList.add(newStory);

		        // Write the updated list to the CSV file
		        try {
		            FileOperations.writeCSVFile("./src/application/resources/Stories.csv", storyList);
		            System.out.println("Data written to CSV file successfully!");
		        } catch (NumberFormatException e) {
		            System.err.println("Error writing to CSV file: " + e.getMessage());
		            e.printStackTrace(); 
		        }

		        // Clear the input fields if needed
		        clearInputFields();
		    }

		    private void clearInputFields() {
		        storyNameText.clear();
		        storyIDText.clear();
		        storyPointsText.clear();
		        estimationTimeText.clear();
		    }
	
}
