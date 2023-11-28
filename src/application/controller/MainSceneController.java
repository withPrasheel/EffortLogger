package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.event.ActionEvent;

public class MainSceneController {
	@FXML
	private TextField tfTitle;

	// Event Listener on Button.onAction
	@FXML
	public void btnOKClicked(ActionEvent event) {
		 Stage mainWindow = (Stage) tfTitle.getScene().getWindow();
		 String title = tfTitle.getText();
		 mainWindow.setTitle(title);
//		 ReadXLSX test = new ReadXLSX();
//		 Story st1 = new Story("Read a file in java", "sjfhj1",5,5);
//		 Story st2 = new Story("Write a file in java", "sjfhj3",10,6);
//		 Story st3 = new Story("execute a file in java", "sjfhsda1",22,30);
//		 ArrayList<Story> arList = new ArrayList<>();
//		 arList.add(st1);
//		 arList.add(st2);
//		 arList.add(st3);
//		 
//		 String filePath = "./src/application/resources/data.csv";
//		 FileOperations.writeCSVFile(filePath,arList);
//		 FileOperations.readCSVFile(filePath);
//		 ArrayList<Story> arList2 = new ArrayList<>();
//		 Story st4 = new Story("testing testing", "sjfhsda3",22,30);
//		 arList2.add(st4);
//		 FileOperations.writeCSVFile(filePath,arList2);
//		 FileOperations.readCSVFile(filePath);
	}
}
