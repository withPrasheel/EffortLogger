package application.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginSignupController {

    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Label loginStatus;

    // Reference to the primary stage
    private Stage primaryStage;

    public void initialize(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Add event handlers for login and signup
        loginButton.setOnAction(event -> handleLogin());
        signupButton.setOnAction(event -> handleSignup());
    }

    public void handleLogin() {
        String inputUsername = usernameInput.getText();
        String inputPassword = passwordInput.getText();
        boolean authenticated = Authentication.authenticateUser(inputUsername, inputPassword);
        if (authenticated) {
            loginStatus.setText("Login successful!");
            primaryStage = (Stage) usernameInput.getScene().getWindow();
    		Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("./../view/ChooseOptionScene.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Scene scene = new Scene(root);
    		primaryStage.setScene(scene);
    		primaryStage.show();
        } else {
            loginStatus.setText("Login failed. Please try again.");
        }
    }

    public void handleSignup() {
        RegistrationUI.showRegistrationForm(primaryStage);
    }
}

