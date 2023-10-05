package fletning.src;

import java.util.Arrays;

public class Opgave2 {

    /**
     * Returnerer et sorteret array der indeholder alle
     * elementer l1 og l2 har til fælles
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static int[] fællesTal(int[] l1, int[] l2) {

        int[] result = new int[l1.length];
        int i1 = 0;
        int i2 = 0;
        int j = 0;

        while (i1 < l1.length && i2 < l2.length) {

            if (l1[i1] < l2[i2])
                i1++;

            else if (l1[i1] > l2[i2])
                i2++;

            else {
                result[j] = l1[i1];
                j++;
                i1++;
                i2++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {2, 4, 6, 8, 10, 12, 14};
        int[] array2 = {1, 2, 4, 5, 6, 9, 12, 17};

        System.out.println(Arrays.toString(fællesTal(array1, array2)));



    }
}
