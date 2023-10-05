package søgskrivfiler.src;

import java.util.Scanner;

public class Opgave1 {

    public static void main(String[] args) {
        int[] prim = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Hvilket nr. primtal skal vises?: ");
            int n = scan.nextInt();
            if (n < 0 || n > 10) {
                throw new IllegalArgumentException("Tallet skal være mellem 0 og 10");
            }
            System.out.println("Primtal nr. " + n + " er "
                    + prim[n - 1] + "\n");
        }

    }
}
