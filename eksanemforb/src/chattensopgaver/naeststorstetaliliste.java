package chattensopgaver;

import java.util.List;

public class naeststorstetaliliste {


        public static void main(String[] args) {
            List<Integer> numbers = List.of(5, 10, 3, 8, 15);
            int secondLargest = findSecondLargest(numbers);
            System.out.println("Det næststørste tal er: " + secondLargest);
        }

        private static int findSecondLargest(List<Integer> numbers) {
            if (numbers.size() < 2) {
                throw new IllegalArgumentException("Listen skal have mindst to tal.");
            }

            int largest = Integer.MIN_VALUE;
            int secondLargest = Integer.MIN_VALUE;

            for (int number : numbers) {
                if (number > largest) {
                    secondLargest = largest;
                    largest = number;
                } else if (number > secondLargest && number != largest) {
                    secondLargest = number;
                }
            }

            if (secondLargest == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Der er ingen næststørste tal.");
            }

            return secondLargest;
        }
}
