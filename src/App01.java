import java.io.*;
import java.util.Scanner;

/**
 * Application enters text in source file and then capitalizes it and copies
 * to destination file.
 *
 * Created by IvanovsV
 */

public class App01 {
    public static void main(String[] args) {
        String sourceFileName = "source.txt";
        String destFileName = "destination.txt";
        File source = null;
        File destination = null;


        try {
            source = new File(sourceFileName);
            if(!source.exists()){
                source.createNewFile();
            }

            destination = new File(destFileName);
            if(!destination.exists()){
                source.createNewFile();
            }
        } catch (IOException ex) {
            System.out.println("Cant create a file");
            ex.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writerSource = new PrintWriter(new FileWriter(source), true);
             PrintWriter writerDest = new PrintWriter(new FileWriter(destination), true);
             Scanner in = new Scanner(System.in)) {

            String content;
            System.out.println("Enter content. type \"-quit\" to exit");
            while (!((content = in.nextLine()).equals("-quit"))) {
                writerSource.println(content);
            }
            System.out.println("Completed writing to source file...");
            writerSource.flush();

            while ((content = reader.readLine()) != null) {
                writerDest.println(content.toUpperCase());
            }

            System.out.println("Content copied to destination...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
