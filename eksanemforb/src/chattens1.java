import java.util.List;

public class chattens1 {
        // Opgave 1: Skriv en metode, der tager imod et tal og returnerer dets fakultet.
        public static int factorial(int n) {
            if (n == 0) {
                return 1;
            } else {
                return n * factorial(n - 1);
            }
        }

        // Opgave 2: Skriv en metode, der tager imod en streng og returnerer antallet af vokaler i strengen.
        public static int countVowels(String str) {
            str = str.toLowerCase();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }
            return count;
        }

        // Opgave 3: Skriv en metode, der tager imod en liste af tal og returnerer summen af tallene.
        public static int sum(List<Integer> numbers) {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return sum;
        }

        // Opgave 4: Skriv en metode, der tager imod et tal og returnerer true, hvis tallet er et primtal, og false ellers.
        public static boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        // Opgave 5: Skriv en metode, der tager imod en streng og returnerer den omvendte streng.
        public static String reverseString(String str) {
            StringBuilder reversed = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                reversed.append(str.charAt(i));
            }
            return reversed.toString();
        }

        // Opgave 6: Skriv en metode, der tager imod et tal og returnerer true, hvis tallet er en Armstrong number, og false ellers.
        public static boolean isArmstrongNumber(int n) {
            int sum = 0;
            int originalNumber = n;
            while (n > 0) {
                int digit = n % 10;
                sum += Math.pow(digit, 3);
                n /= 10;
            }
            return sum == originalNumber;
        }

        // Opgave 7: Skriv en metode, der tager imod en liste af strenge og returnerer længden af den længste streng.
        public static int maxLength(List<String> strings) {
            int maxLength = 0;
            for (String str : strings) {
                if (str.length() > maxLength) {
                    maxLength = str.length();
                }
            }
            return maxLength;
        }


}
