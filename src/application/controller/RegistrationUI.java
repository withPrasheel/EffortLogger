package application.controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegistrationUI {
	public static void showRegistrationForm(Stage primaryStage) {
        Stage registrationStage = new Stage();
        registrationStage.setTitle("Registration");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label usernameLabel = new Label("New Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        Label passwordLabel = new Label("New Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);

        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 1, 2);

        Label registrationStatus = new Label("");
        GridPane.setConstraints(registrationStatus, 1, 3);

        registerButton.setOnAction(e -> {
            String newUsername = usernameInput.getText();
            String newPassword = passwordInput.getText();
            boolean registered = Authentication.registerUser(newUsername, newPassword);
            if (registered) {
                registrationStatus.setText("Registration successful!");
            } else {
                registrationStatus.setText("Registration failed. Please try again.");
            }
        });

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, registerButton, registrationStatus);

        Scene scene = new Scene(grid, 400, 200);
        registrationStage.setScene(scene);
        registrationStage.show();
    }
}
