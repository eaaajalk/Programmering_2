package fletning.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave6 {

    public static void findfællesTal(String fileName1, String fileName2, String fileNameNy) {
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);

        try (Scanner scan1 = new Scanner(file1);
             Scanner scan2 = new Scanner(file2);
             PrintWriter printWriter = new PrintWriter(fileNameNy)) {

            int i1 = scan1.nextInt();
            int i2 = scan2.nextInt();

            while (i1 != 2147483647 && i2 != 2147483647) {

                if (i1 < i2)
                    i1 = scan1.nextInt();

                else if (i1 > i2)
                    i2 = scan2.nextInt();

                else {
                    printWriter.println(i1);
                    i1 = scan1.nextInt();
                    i2 = scan2.nextInt();
                }
            }

    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        String filename1 = "/Users/piscatorem/Desktop/tal1.txt";
        String filename2 = "/Users/piscatorem/Desktop/tal2.txt";
        String filenameNy = "/Users/piscatorem/Desktop/talNY.txt";
        findfællesTal(filename1, filename2, filenameNy);

    }




}
