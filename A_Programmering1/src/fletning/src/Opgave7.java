package fletning.src;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave7 {

    public static String linFileSearchPerson(String fileName, String target) {
        File filein = new File(fileName);
        StringBuilder sb = new StringBuilder();

        try (Scanner scan = new Scanner(filein)) {

            String temp = null;

            while (scan.hasNext()) {
                String line = scan.nextLine();

                for (int j = 0; j < line.length(); j++) {
                    if (match(line, target, j)) {
                        temp = line;
                    }
                }
                if (temp != null){
                    sb.append(temp).append("\n");
                    temp = null;
                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        return String.valueOf(sb);
    }

        private static boolean match(String sm, String m, int i) {
            boolean foundDiff = false;
            int j = 0;
            while (!foundDiff && j < m.length()) {
                if (sm.charAt(i+j)!= m.charAt(j)) {
                    foundDiff = true;
                }
                else {
                    j++;
                }
            }
            return !foundDiff;
        }


        public static void main(String[] args) {
        String filename = "/Users/piscatorem/Desktop/personer.txt";
        System.out.println(linFileSearchPerson(filename, "Jensen"));

    }

}
