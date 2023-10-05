package chattensopgaver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class udskrivalmindeligeorditekstfilm {
        public static void main(String[] args) {
            File file = new File("tekstfil.txt");
            try {
                Map<String, Integer> wordCountMap = countWords(file);
                System.out.println("Mest almindelige ord:");
                for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } catch (FileNotFoundException e) {
                System.out.println("Filen blev ikke fundet.");
            }
        }

        private static Map<String, Integer> countWords(File file) throws FileNotFoundException {
            Map<String, Integer> wordCountMap = new HashMap<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
            scanner.close();
            return wordCountMap;
        }


}
