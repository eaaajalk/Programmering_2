package array;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(sum(array));

        String[] a = {"h", "hhhh", "gg"};
        System.out.println(longestWord(a));

        int[] array2 = {1, 9, 3, 4};
        System.out.println(faellesMaengde(array, array2));
    }

    public static int sum (int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    public static String longestWord(String[] a) {
        String r = a[0];
        for (int i = 1; i < a.length; i++) {
            String temp = a[i];
            if (r.length() < temp.length()) {
                r = temp;
            }
        }
        return r;
    }

    public static String faellesMaengde(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    res.add(a[i]);
                }
            }
        }
        return res.toString();
    }

    



}