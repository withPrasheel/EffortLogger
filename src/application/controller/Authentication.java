package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Authentication {

    private static final String EXCEL_FILE_PATH = "src/application/resources/user_data.csv"; // Use a CSV file instead of an Excel file

    private static final Map<String, String> userData = new HashMap<>();
    
    private static void loadUserDataFromFile() {
        File csvFile = new File(EXCEL_FILE_PATH);

        if (csvFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                String line;
                boolean isFirstLine = true;

                while ((line = br.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false; // Skip the header line
                        continue;
                    }

                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String username = parts[0].trim();
                        String hashedPassword = parts[1].trim();
                        userData.put(username, hashedPassword);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean authenticateUser(String username, String password) {
    	loadUserDataFromFile();
        String storedHashedPassword = userData.get(username);

        if (storedHashedPassword != null) {
            String hashedEnteredPassword = hashPassword(password);
            if (storedHashedPassword.equals(hashedEnteredPassword)) {
                return true; // Authentication successful
            }
        }

        return false; // Authentication failed
    }

    public static boolean registerUser(String username, String password) {
    	loadUserDataFromFile();
    	if (userData.containsKey(username)) {
    		return false;
    	}
        if (username.length() < 4 || username.length() > 32) {
            return false; // Size restriction not met
        }

        if (!username.matches("^[a-zA-Z0-9._-]+$")) {
            return false; // Lexical restriction not met
        }

        for (int i = 0; i < username.length() - 1; i++) {
            if (username.charAt(i) == '.' || username.charAt(i) == '-' || username.charAt(i) == '_') {
                if (!Character.isLetterOrDigit(username.charAt(i + 1))) {
                    return false; // Syntactic restriction not met
                }
            }
        }

        String hashedPassword = hashPassword(password);
        userData.put(username, hashedPassword);

        try (FileWriter writer = new FileWriter(EXCEL_FILE_PATH, true)) {
            // Append the new user to the CSV file
            writer.write(username + "," + hashedPassword + "\n");
            writer.flush();
            return true; // Registration successful
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Registration failed
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedPassword) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}

