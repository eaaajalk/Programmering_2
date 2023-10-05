package søgskrivfiler.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave3 {
    public static void main(String[] args) throws FileNotFoundException {

        File filein = new File("/Users/piscatorem/Desktop/tal.txt");

        ArrayList<Integer> tal = new ArrayList<>();

        try(Scanner scan = new Scanner(filein)) {
            while (scan.hasNext()) {
                tal.add(scan.nextInt());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String fileName = "/Users/piscatorem/Desktop/tal.txt";

        try(PrintWriter printWriter = new PrintWriter(fileName)) {
            for (int n = tal.size()-1; n >= 0; n--) {
                printWriter.println(tal.get(n));
            }

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
