package chattensopgaver;

import java.util.Scanner;

public class forste10 {

    //alle primtal fra 2 tal
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Indtast et tal: ");
            int num = scanner.nextInt();

            System.out.println("Primtal fra 2 til " + num + ":");
            for (int i = 2; i <= num; i++) {
                if (isPrime(i)) {
                    System.out.println(i);
                }
            }
        }
        private static boolean isPrime(int number) {
            if (number < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }





    }



