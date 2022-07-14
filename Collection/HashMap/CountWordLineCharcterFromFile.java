package Collection.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CountWordLineCharcterFromFile {

    static String path = "./src/notes10may.txt";

    public static void main(String[] args) {

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        FileReader file;
        try {

            file = new FileReader(path);
            BufferedReader br = new BufferedReader(file);

            String currentLine = br.readLine();

            while (currentLine != null) {

                lineCount++;

                String[] words = currentLine.split(" ");
                wordCount += words.length;

                for (String word : words) {
                    charCount = charCount + word.length();
                }
                currentLine = br.readLine();

            }
            System.out.println("Lines of the file is" + lineCount);
            System.out.println("word of the file is" + wordCount);
            System.out.println("cahracter of the file is" + charCount);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
