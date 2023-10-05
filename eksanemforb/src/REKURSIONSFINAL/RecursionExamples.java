package REKURSIONSFINAL;

public class RecursionExamples {

    public static void main(String[] args) {
        // Eksempler på rekursionsopgaver
        System.out.println(factorial(5)); // Factorial: 5! = 5 * 4 * 3 * 2 * 1 = 120
        System.out.println(fibonacci(10)); // Fibonacci-sekvens: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        System.out.println(sumOfDigits(12345)); // Summen af cifrene: 1 + 2 + 3 + 4 + 5 = 15
        System.out.println(reverseString("Hello")); // Omvendt streng: olleH
        System.out.println(isPalindrome("level")); // Palindrom: true
        System.out.println(power(2, 4)); // Potens: 2^4 = 16
    }

    // Factorial (fakultet)
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Fibonacci-sekvens
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // Summen af cifrene i et tal
    public static int sumOfDigits(int number) {
        if (number < 10) {
            return number;
        } else {
            return number % 10 + sumOfDigits(number / 10);
        }
    }

    // Omvendt en streng
    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }

    // Tjek om en streng er et palindrom
    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        } else {
            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);

            if (first == last) {
                return isPalindrome(str.substring(1, str.length() - 1));
            } else {
                return false;
            }
        }
    }

    // Potens (a^n)
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}
