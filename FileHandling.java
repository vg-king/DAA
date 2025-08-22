import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        // Write to file
        try {
            FileWriter fw = new FileWriter("file.txt");
            fw.write("Hello, this is a test!\n12345");
            fw.close();
            System.out.println("Data written to file.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String line;
            System.out.println("Reading from file.txt:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}