package søgskrivfiler.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class læskriv {

    public static void main(String[] args) throws FileNotFoundException {

        File filein = new File("/Users/piscatorem/Desktop/tegn.txt");

        int counter = 0;
        try (Scanner scan = new Scanner(filein)) {
            while (scan.hasNext()) {
                counter++;
            }

        }
    }
}
