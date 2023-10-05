package fletning.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave4 {

    public static boolean linFileSearch(String fileName, int target) {
        File file = new File(fileName);

        boolean found = false;

        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext() && !found) {
                int tal = scan.nextInt();
                if (tal == target) {
                    found = true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return found;
    }


    public static void main(String[] args) {
        String fileName = "/Users/piscatorem/Desktop/talfil.txt";

        System.out.println(linFileSearch(fileName, 982));
    }






}
