package REKURSIONSFINAL;

public class MoreRecursionExamples {
    public static void main(String[] args) {
        System.out.println(sum(5)); // Summen af talene fra 1 til 5: 1 + 2 + 3 + 4 + 5 = 15
        System.out.println(countDigits(12345)); // Antallet af cifre i tallet: 5
        System.out.println(countOccurrences("hello world", 'o')); // Antallet af forekomster af karakteren 'o': 2
        System.out.println(reverseArray(new int[] { 1, 2, 3, 4, 5 })); // Omvendt array: [5, 4, 3, 2, 1]
        System.out.println(binarySearch(new int[] { 2, 4, 6, 8, 10 }, 6)); // Binærsøgning: returnerer indeks af tallet 6
        System.out.println(findMax(new int[] { 5, 2, 8, 1, 9 })); // Find det største tal i arrayet: 9
        System.out.println(sumArray(new int[] { 1, 2, 3, 4, 5 })); // Summen af tallene i arrayet: 15
        System.out.println(countEvenNumbers(new int[] { 1, 2, 3, 4, 5 })); // Antallet af lige tal i arrayet: 2
        System.out.println(countUpperCaseLetters("Hello World")); // Antallet af store bogstaver i strengen: 2
        System.out.println(findSubstring("Hello World", "World")); // Find indekset af delstrengen: 6
        //System.out.println(reverseLinkedList(createLinkedList())); // Omvendt linked list: 3 -> 2 -> 1
        System.out.println(isSorted(new int[] { 1, 2, 3, 4, 5 })); // Tjek om arrayet er sorteret i stigende rækkefølge: true
        System.out.println(findGCD(24, 36)); // Find den største fælles divisor af 24 og 36: 12
        System.out.println(countBinaryDigits(10)); // Antallet af cifre i det binære tal: 4
        System.out.println(sumOfSubset(new int[] { 1, 2, 3, 4, 5 }, 7)); // Tjek om der findes en delmængde, der giver summen 7: true
        System.out.println(countPaths(3, 3)); // Antallet af mulige stier i et gitter: 6
    }

    // Opgave 1: Beregn summen af talene fra 1 til n
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    // Opgave 2: Tæl antallet af cifre i et tal
    public static int countDigits(int number) {
        if (number < 10) {
            return 1;
        } else {
            return 1 + countDigits(number / 10);
        }
    }

    // Opgave 3: Tæl antallet af forekomster af en karakter i en streng
    public static int countOccurrences(String str, char c) {
        if (str.length() == 0) {
            return 0;
        } else if (str.charAt(0) == c) {
            return 1 + countOccurrences(str.substring(1), c);
        } else {
            return countOccurrences(str.substring(1), c);
        }
    }

    // Opgave 4: Omvend et array
    public static int[] reverseArray(int[] arr) {
        return reverseArrayHelper(arr, 0, arr.length - 1);
    }

    private static int[] reverseArrayHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return arr;
        } else {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            return reverseArrayHelper(arr, start + 1, end - 1);
        }
    }

    // Opgave 5: Binærsøgning i et sorteret array
    public static int binarySearch(int[] arr, int target) {
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchHelper(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1; // Elementet blev ikke fundet
        } else {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearchHelper(arr, target, mid + 1, end);
            } else {
                return binarySearchHelper(arr, target, start, mid - 1);
            }
        }
    }

    // Opgave 6: Find det største tal i et array
    public static int findMax(int[] arr) {
        return findMaxHelper(arr, 0, arr.length - 1);
    }

    private static int findMaxHelper(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftMax = findMaxHelper(arr, start, mid);
            int rightMax = findMaxHelper(arr, mid + 1, end);
            return Math.max(leftMax, rightMax);
        }
    }

    // Opgave 7: Beregn summen af tallene i et array
    public static int sumArray(int[] arr) {
        return sumArrayHelper(arr, 0);
    }

    private static int sumArrayHelper(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        } else {
            return arr[index] + sumArrayHelper(arr, index + 1);
        }
    }

    // Opgave 8: Tæl antallet af lige tal i et array
    public static int countEvenNumbers(int[] arr) {
        return countEvenNumbersHelper(arr, 0);
    }

    private static int countEvenNumbersHelper(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        } else {
            if (arr[index] % 2 == 0) {
                return 1 + countEvenNumbersHelper(arr, index + 1);
            } else {
                return countEvenNumbersHelper(arr, index + 1);
            }
        }
    }

    // Opgave 9: Tæl antallet af store bogstaver i en streng
    public static int countUpperCaseLetters(String str) {
        return countUpperCaseLettersHelper(str, 0);
    }

    private static int countUpperCaseLettersHelper(String str, int index) {
        if (index == str.length()) {
            return 0;
        } else {
            if (Character.isUpperCase(str.charAt(index))) {
                return 1 + countUpperCaseLettersHelper(str, index + 1);
            } else {
                return countUpperCaseLettersHelper(str, index + 1);
            }
        }
    }

    // Opgave 10: Find indekset af en delstreng i en streng
    public static int findSubstring(String str, String substr) {
        return findSubstringHelper(str, substr, 0);
    }

    private static int findSubstringHelper(String str, String substr, int index) {
        if (index > str.length() - substr.length()) {
            return -1; // Delstrengen blev ikke fundet
        } else {
            if (str.substring(index, index + substr.length()).equals(substr)) {
                return index;
            } else {
                return findSubstringHelper(str, substr, index + 1);
            }
        }
    }

    // Opgave 11: Omvend et linked list
    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            Node newHead = reverseLinkedList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    // Hjælpeklasse til linked list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // Opgave 12: Tjek om et array er sorteret i stigende rækkefølge
    public static boolean isSorted(int[] arr) {
        return isSortedHelper(arr, 0);
    }

    private static boolean isSortedHelper(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return true;
        } else {
            if (arr[index] > arr[index + 1]) {
                return false;
            } else {
                return isSortedHelper(arr, index + 1);
            }
        }
    }

    // Opgave 13: Find den største fælles divisor af to tal
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }

    // Opgave 14: Tæl antallet af cifre i et binært tal
    public static int countBinaryDigits(int n) {
        if (n < 2) {
            return 1;
        } else {
            return 1 + countBinaryDigits(n / 2);
        }
    }

    // Opgave 15: Tjek om der findes en delmængde af et array, der giver en given sum
    public static boolean sumOfSubset(int[] arr, int target) {
        return sumOfSubsetHelper(arr, target, 0);
    }

    private static boolean sumOfSubsetHelper(int[] arr, int target, int index) {
        if (target == 0) {
            return true;
        } else if (target < 0 || index >= arr.length) {
            return false;
        } else {
            return sumOfSubsetHelper(arr, target - arr[index], index + 1)
                    || sumOfSubsetHelper(arr, target, index + 1);
        }
    }

    // Opgave 16: Beregn antallet af mulige stier i et gitter (n x m)
    public static int countPaths(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        } else {
            return countPaths(n - 1, m) + countPaths(n, m - 1);
        }
    }
}
