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
	
	public static ArrayList<Story> readCSVFile(String filePath) {
		ArrayList<Story> storyList = new ArrayList<Story>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();		// skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Story story = new Story(data[0],data[1],Integer.valueOf(data[2]),Integer.valueOf(data[3]));
                storyList.add(story);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issue while reading the file :"+filePath);
        }
        return storyList;
    }
	
	public static void main(String args[]) {
//		String filePath = "./src/application/resources/Stories.csv";
////        writeCSVFile(filePath);
//		ArrayList<Story> stories = readCSVFile(filePath);
//		for(Story story:stories) {
//			System.out.println(story.getStoryName());
//		}
	}
}
