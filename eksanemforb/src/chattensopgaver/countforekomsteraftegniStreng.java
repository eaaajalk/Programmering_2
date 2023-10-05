package chattensopgaver;

import java.util.HashMap;
import java.util.Map;

public class countforekomsteraftegniStreng {


        public static void main(String[] args) {
            String text = "Hello, World!";
            Map<Character, Integer> characterCountMap = countCharacters(text);
            System.out.println("Antal forekomster af hver karakter: " + characterCountMap);
        }

        private static Map<Character, Integer> countCharacters(String text) {
            Map<Character, Integer> characterCountMap = new HashMap<>();
            for (char c : text.toCharArray()) {
                characterCountMap.put(c, characterCountMap.getOrDefault(c, 0) + 1);
            }
            return characterCountMap;
        }


}
