package søgskrivfiler.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave2 {


    public static void main(String[] args) throws FileNotFoundException {

        File filein = new File("/Users/piscatorem/Desktop/tal.txt");

        try (Scanner scan = new Scanner(filein)) {
            while (scan.hasNext()) {
                System.out.println(scan.nextInt() * 2);
            }

        }
    }
}
