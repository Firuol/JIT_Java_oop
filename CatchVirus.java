package catchvirus;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class CatchVirus {

    
    public static void main(String[] args) {
       

        String filePath = "C:\\Users\\murtii\\Documents\\NetBeansProjects\\WritetoFile\\file.txt";
        String wordToRemove = "sapien";
        String tempFilePath = "temp.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFilePath));

            String line = reader.readLine();
            while (line != null) {
                line = line.replaceAll(wordToRemove, "");
                writer.write(line + System.getProperty("line.separator"));
                line = reader.readLine();
            }

            reader.close();
            writer.close();

            // Delete the original file
            if (!new File(filePath).delete()) {
                System.out.println("Failed to delete the original file.");
            }

            // Rename the temporary file to the original file name
            if (!new File(tempFilePath).renameTo(new File(filePath))) {
                System.out.println("Failed to rename the temporary file.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file: " + e.getMessage());
        }
    



        
    }
    
}
