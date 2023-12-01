package application.helper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class FileOperations {

	private static Encryption encryption = new Encryption();
	private static SecretKey key;
	private static final String ENCRYPTION_KEY_PATH = "./src/application/resources/encryption.csv";

	static {
//        try {
//            key = loadSecretKey();
//        } catch (NoSuchAlgorithmException | IOException e) {
//            e.printStackTrace();
//        }
    }
	
	private static SecretKey loadSecretKey() throws NoSuchAlgorithmException, IOException {
	    File keyFile = new File(ENCRYPTION_KEY_PATH);
	    if (keyFile.exists()) {
	        try (BufferedReader br = new BufferedReader(new FileReader(keyFile))) {
	            String encodedKey = br.readLine(); 
	            if (encodedKey != null && !encodedKey.isEmpty()) {
	                byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
	                return new SecretKeySpec(decodedKey, "AES");
	            } else {
	                throw new IOException("Encoded key is null or empty");
	            }
	        }
	    } else {
	        SecretKey newKey = encryption.generateKey();
	        String encodedKey = Base64.getEncoder().encodeToString(newKey.getEncoded());
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(keyFile))) {
	            bw.write(encodedKey); 
	        }
	        return newKey;
	    }
	}


	
	
	public static void writeCSVFile(String filePath, ArrayList<Story> storyList) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                writer.write("StoryName, StoryId, StoryPoints, EstimationTime\n");
            }

            for(Story story: storyList) {
            	writer.write(story.getStoryId()+", "+story.getStoryName()+", "+story.getStoryPoints()+", "+story.getEstimationTime()+"\n");
            }

            System.out.println("Data written to the CSV file: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	public static void writeCSVFile(String filePath, ArrayList<Story> storyList, SecretKey key) {        //Writes list of encrypted stories to CSV file.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {        //Buffered writer to write and close the writer.
            for (Story story : storyList) {        //Iterate over each story in list.
                String dataToEncrypt = story.getStoryId() + "," + story.getStoryName() + "," + story.getStoryPoints() + "," + story.getEstimationTime();        //Concatenate story information for CSV file.
                String encryptedLine = encryption.encryptString(dataToEncrypt, key);        //Encrypt string.
                writer.write(encryptedLine);        //Write encrypted string as new line in file.
                writer.newLine();         //Move to next line.
            }
            System.out.println("Data written to the CSV file: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

	public static ArrayList<Story> readCSVFile(String filePath) {
		ArrayList<Story> storyList = new ArrayList<Story>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();		// skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Story story = new Story(data[0],data[1],Integer.valueOf(data[2].trim()),Integer.valueOf(data[3].trim()));
                storyList.add(story);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issue while reading the file :"+filePath);
        }
        return storyList;
    }
	
	
	public static ArrayList<Story> readEncryptedCSVFile(String filePath, SecretKey key) {
	    ArrayList<Story> storyList = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String decryptedLine = encryption.decryptString(line, key);
	            String[] data = decryptedLine.split(",");
	            Story story = new Story(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
	            storyList.add(story);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return storyList;
	}
	
	public static void main(String args[]) {
		String storiesFilePath = "./src/application/resources/Stories.csv";
	    String encryptedFilePath = "./src/application/resources/encryption.csv";

	    try {
	        SecretKey key = loadSecretKey(); 
	        ArrayList<Story> storyList = readCSVFile(storiesFilePath);

	        writeCSVFile(encryptedFilePath, storyList, key);
	        storyList.forEach(story -> System.out.println("Story Name: " + story.getStoryName() +
                    ", Story ID: " + story.getStoryId() +
                    ", Story Points: " + story.getStoryPoints() +
                    ", Estimation Time: " + story.getEstimationTime()));

	    } catch (NoSuchAlgorithmException | IOException e) {
	        e.printStackTrace();
	    }
}
}
