package søgskrivfiler.src;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave6 {

    // FIND MAX
    public static int max (String filename) throws IOException {
        File filein = new File(filename);
        Scanner scan = new Scanner(filein);
        int max = scan.nextInt();

        while (scan.hasNext()) {
                int temp = scan.nextInt();
                if (temp > max) {
                    max = temp;
                }
        }
        scan.close();
        return max;
    }

    // FIND MIN
    public static int min(String fileName) throws IOException {
        File filein = new File(fileName);
        Scanner scan = new Scanner(filein);
        int min = scan.nextInt();

        while (scan.hasNext()) {
            int temp = scan.nextInt();
            if (temp < min) {
                min = temp;
            }
        }
        scan.close();
        return min;
    }

    // FIND GENNEMSNIT
    public static double gennemsnit(String fileName) throws IOException {
        File filein = new File(fileName);
        Scanner scan = new Scanner(filein);
        double average = 0;
        int sum = 0;
        int counter = 0;

        while (scan.hasNext()) {
            sum = sum + scan.nextInt();
            counter++;
            }
        if (sum > 0){
            average = (double) sum / counter;
        }
        scan.close();

        return average;
    }




    public static void main(String[] args) throws IOException {
        String fileName = "/Users/piscatorem/Desktop/tal1.txt";
        try {
            System.out.println(max(fileName));

            System.out.println(min(fileName));

            System.out.println(gennemsnit(fileName));

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
