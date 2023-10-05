package søgskrivfiler.src;

import java.io.IOException;
import java.io.PrintWriter;

public class Opgave4 {
    public static void main(String[] args) {

        String fileName = "/Users/piscatorem/Desktop/tal.txt";

        try(PrintWriter printWriter = new PrintWriter(fileName)) {

            for (int n = 1; n <= 100; n++) {
                if (n % 2 != 0) {
                    printWriter.println(n);
                }
            }

            System.out.println("Filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
