package application.helper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class FileOperations {
	
	public static void writeCSVFile(String filePath, ArrayList<Story> storyList) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                writer.write("Name, Age, City\n");
            }

            for(Story story: storyList) {
            	writer.write(story.getStoryId()+", "+story.getStoryName()+", "+story.getStoryPoints()+", "+story.getEstimationTime()+"\n");
            }

            System.out.println("Data written to the CSV file: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void readCSVFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                for (String value : data) {
                    System.out.print(value + "\t");
                }
                System.out.println(); // Move to the next line after each row
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String args[]) {
//		String filePath = "./src/application/resources/data.csv";
//        writeCSVFile(filePath);
//        readCSVFile(filePath);
	}
}
