package søgskrivfiler.src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Opgave5 {
    public static void main(String[] args) {

        String fileName = "/Users/piscatorem/Desktop/tal.txt";

        try {
            PrintWriter printWriter = new PrintWriter(fileName);
            Scanner scan = new Scanner(System.in);

            System.out.print("Skriv en række positive tal og slut med -1: ");

            boolean finished = false;
            while (!finished) {
                int tal = scan.nextInt();
                if (tal > 0) {
                    printWriter.println(tal);
                }
                if (tal == -1) {
                    finished = true;
                }
            }
            scan.close();
            printWriter.close();

        } catch (InputMismatchException i) {
            System.out.println("Indtast heltal");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
