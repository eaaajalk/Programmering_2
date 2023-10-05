package chattensopgaver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class tallelinjerordtegn {



        public static void main(String[] args) {
            String filename = "testfile.txt";

            try {
                int wordCount = countWords(filename);
                int lineCount = countLines(filename);
                int characterCount = countCharacters(filename);

                System.out.println("Antal ord: " + wordCount);
                System.out.println("Antal linjer: " + lineCount);
                System.out.println("Antal tegn: " + characterCount);
            } catch (IOException e) {
                System.out.println("Fejl under læsning af fil: " + e.getMessage());
            }
        }

        private static int countWords(String filename) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int wordCount = 0;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            reader.close();
            return wordCount;
        }

        private static int countLines(String filename) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            int lineCount = 0;

            while (reader.readLine() != null) {
                lineCount++;
            }

            reader.close();
            return lineCount;
        }

        private static int countCharacters(String filename) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            int characterCount = 0;

            int character;
            while ((character = reader.read()) != -1) {
                characterCount++;
            }

            reader.close();
            return characterCount;
        }


}
