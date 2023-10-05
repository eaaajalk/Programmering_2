package webserver;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class main {

        public static void main(String[] args) {
            // Angiv stien til din tekstfil her
            String filePath = "/Users/piscatorem/Desktop/hejsa.txt";

            try {
                String inputText = readTextFromFile(filePath);
                String processedText = processText(inputText);
                System.out.println(processedText);
            } catch (IOException e) {
                System.err.println("Fejl ved læsning af fil: " + e.getMessage());
            }
        }

        public static String readTextFromFile(String filePath) throws IOException {
            StringBuilder text = new StringBuilder();
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine());
                if (scanner.hasNextLine()) {
                    text.append("\n"); // Tilføj linjeskift mellem linjer
                }
            }
            scanner.close();
            return text.toString();
        }

        public static String processText(String input) {
            // Fjern tal og punktummer
            String withoutNumbersAndPeriods = input.replaceAll("[0-9.]", "");

            // Erstat linjeskift med mellemrum
            String withSpacesInsteadOfNewlines = withoutNumbersAndPeriods.replace("\n", " ");

            return withSpacesInsteadOfNewlines;
        }
    }
