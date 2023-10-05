import java.util.*;
public class chattens2 {
    public static void main(String[] args) {

    }
        // Opgave 1: Skriv en metode, der tager imod en liste af strenge og returnerer en ny liste, hvor alle ord er blevet sorteret i stigende længde.
        public static List<String> sortWordsByLength(List<String> words) {
            Collections.sort(words, Comparator.comparingInt(String::length));
            return words;
        }

        // Opgave 2: Skriv en metode, der tager imod en liste af tal og returnerer en ny liste, hvor alle lige tal er blevet fordoblet.
        public static List<Integer> doubleEvenNumbers(List<Integer> numbers) {
            List<Integer> doubledNumbers = new ArrayList<>();
            for (int number : numbers) {
                if (number % 2 == 0) {
                    doubledNumbers.add(number * 2);
                } else {
                    doubledNumbers.add(number);
                }
            }
            return doubledNumbers;
        }

        // Opgave 3: Skriv en metode, der tager imod en liste af strenge og returnerer en ny liste, hvor alle strenge er blevet omdrejningspunktet forbedret.
        public static List<String> improveStrings(List<String> strings) {
            List<String> improvedStrings = new ArrayList<>();
            for (String str : strings) {
                improvedStrings.add(str + " is improved");
            }
            return improvedStrings;
        }

        // Opgave 4: Skriv en metode, der tager imod en tekststreng og returnerer et map med karakterne som nøgler og deres forekomster som værdier.
        public static Map<Character, Integer> countCharacters(String text) {
            Map<Character, Integer> characterCountMap = new HashMap<>();
            for (char ch : text.toCharArray()) {
                characterCountMap.put(ch, characterCountMap.getOrDefault(ch, 0) + 1);
            }
            return characterCountMap;
        }

        // Opgave 5: Skriv en metode, der tager imod en liste af tal og returnerer det andet mindste tal i listen.
        public static int findSecondSmallestNumber(List<Integer> numbers) {
            if (numbers.size() < 2) {
                throw new IllegalArgumentException("Der er ikke nok tal i listen.");
            }
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            List<Integer> sortedNumbers = new ArrayList<>(uniqueNumbers);
            Collections.sort(sortedNumbers);
            return sortedNumbers.get(1);
        }

        // Opgave 6: Skriv en metode, der tager imod en tekststreng og returnerer en ny streng med alle vokaler fjernet.
        public static String removeVowels(String text) {
            return text.replaceAll("[aeiouAEIOU]", "");
        }

        // Opgave 7: Skriv en metode, der tager imod en liste af tal og returnerer en ny liste, hvor talene er blevet kvadrerede.
        public static List<Integer> squareNumbers(List<Integer> numbers) {
            List<Integer> squaredNumbers = new ArrayList<>();
            for (int number : numbers) {
                squaredNumbers.add(number * number);
            }
            return squaredNumbers;
        }

        // Opgave 8: Skriv en metode, der tager imod en tekststreng og returnerer true, hvis strengen er et pangram (indeholder alle bogstaver i alfabetet), og false ellers.
        public static boolean isPangram(String text) {
            Set<Character> alphabet = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
            for (char ch : text.toLowerCase().toCharArray()) {
                alphabet.remove(ch);
                if (alphabet.isEmpty()) {
                    return true;
                }
            }
            return false;
        }

        // Opgave 9: Skriv en metode, der tager imod en liste af tal og returnerer gennemsnittet af de tal, der er større end det forrige tal.
        public static double averageOfLargerNumbers(List<Integer> numbers) {
            double sum = 0;
            int count = 0;
            for (int i = 1; i < numbers.size(); i++) {
                if (numbers.get(i) > numbers.get(i - 1)) {
                    sum += numbers.get(i);
                    count++;
                }
            }
            return sum / count;
        }

        // Opgave 10: Skriv en metode, der tager imod to tekststrenge og returnerer true, hvis de er anagrammer, og false ellers.
        public static boolean isAnagram(String str1, String str2) {
            if (str1.length() != str2.length()) {
                return false;
            }
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (char ch : str1.toCharArray()) {
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
            for (char ch : str2.toCharArray()) {
                if (!charCountMap.containsKey(ch) || charCountMap.get(ch) == 0) {
                    return false;
                }
                charCountMap.put(ch, charCountMap.get(ch) - 1);
            }
            return true;
        }


}
