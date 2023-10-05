import java.util.*;
public class chattens3 {

        // Opgave 1: Skriv en metode, der tager imod en liste af strenge og returnerer en ny liste, hvor alle palindromiske strenge er fjernet.
        public static List<String> removePalindromes(List<String> strings) {
            List<String> result = new ArrayList<>();
            for (String str : strings) {
                if (!isPalindrome(str)) {
                    result.add(str);
                }
            }
            return result;
        }

        // Opgave 2: Skriv en metode, der tager imod et antal tal og returnerer deres median (midterste værdi).
        public static double calculateMedian(double... numbers) {
            Arrays.sort(numbers);
            int middle = numbers.length / 2;
            if (numbers.length % 2 == 0) {
                return (numbers[middle - 1] + numbers[middle]) / 2.0;
            } else {
                return numbers[middle];
            }
        }

        // Opgave 3: Skriv en metode, der tager imod en tekststreng og returnerer en ny streng med alle gentagne tegn fjernet.
        public static String removeDuplicates(String text) {
            StringBuilder result = new StringBuilder();
            Set<Character> seen = new HashSet<>();
            for (char ch : text.toCharArray()) {
                if (!seen.contains(ch)) {
                    result.append(ch);
                    seen.add(ch);
                }
            }
            return result.toString();
        }

        // Opgave 4: Skriv en metode, der tager imod et decimaltal og returnerer det som en brøk i simplest mulige form.
//        public static String decimalToFraction(double decimal) {
//            return Fraction.fromDecimal(decimal).toString();
//        }

        // Opgave 5: Skriv en metode, der tager imod en liste af strenge og returnerer en ny liste, hvor strengene er blevet sorteret efter deres anagramgrupper.
        public static List<String> sortAnagramGroups(List<String> strings) {
            Map<String, List<String>> anagramGroups = new HashMap<>();
            for (String str : strings) {
                String sortedStr = sortChars(str);
                List<String> group = anagramGroups.getOrDefault(sortedStr, new ArrayList<>());
                group.add(str);
                anagramGroups.put(sortedStr, group);
            }
            List<String> result = new ArrayList<>();
            for (List<String> group : anagramGroups.values()) {
                result.addAll(group);
            }
            return result;
        }

        // Opgave 6: Skriv en metode, der tager imod en tekststreng og returnerer en ny streng med ordene i omvendt rækkefølge, men bevarende rækkefølgen af bogstaver i hvert ord.
        public static String reverseWordsPreservingOrder(String text) {
            String[] words = text.split(" ");
            for (int i = 0; i < words.length; i++) {
                words[i] = reverseString(words[i]);
            }
            return String.join(" ", words);
        }

        // Opgave 7: Skriv en metode, der tager imod en liste af tal og returnerer en ny liste, hvor hvert tal er erstattet med det næste større primtal.
        public static List<Integer> replaceWithNextPrime(List<Integer> numbers) {
            List<Integer> result = new ArrayList<>();
            for (int num : numbers) {
                result.add(findNextPrime(num));
            }
            return result;
        }

        // Opgave 8: Skriv en metode, der tager imod to tekststrenge og returnerer true, hvis de er rotationsanagrammer, og false ellers.
        public static boolean isRotationAnagram(String str1, String str2) {
            if (str1.length() != str2.length()) {
                return false;
            }
            String str1str1 = str1 + str1;
            return str1str1.contains(str2);
        }

        // Opgave 9: Skriv en metode, der tager imod en tekststreng og returnerer true, hvis strengen er en isogram (dvs. den indeholder ingen gentagne bogstaver), og false ellers.
        public static boolean isIsogram(String str) {
            Set<Character> seen = new HashSet<>();
            for (char ch : str.toCharArray()) {
                if (seen.contains(ch)) {
                    return false;
                }
                seen.add(ch);
            }
            return true;
        }

        // Opgave 10: Skriv en metode, der tager imod en liste af tal og returnerer den maksimale sum, der kan opnås ved at vælge en delmængde af tal, hvor ingen tal er ved siden af hinanden.
        public static int maxSumNonAdjacent(List<Integer> numbers) {
            if (numbers.isEmpty()) {
                return 0;
            }
            int prevPrevSum = 0;
            int prevSum = 0;
            for (int num : numbers) {
                int currentSum = Math.max(prevSum, prevPrevSum + num);
                prevPrevSum = prevSum;
                prevSum = currentSum;
            }
            return prevSum;
        }

        // Hjælpefunktioner
        private static boolean isPalindrome(String str) {
            return str.equals(reverseString(str));
        }

        private static String reverseString(String str) {
            return new StringBuilder(str).reverse().toString();
        }

        private static String sortChars(String str) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        private static int findNextPrime(int num) {
            while (true) {
                num++;
                if (isPrime(num)) {
                    return num;
                }
            }
        }

        private static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        // Testmetode
        public static void main(String[] args) {
            // Test af opgaverne her...
        }


}
