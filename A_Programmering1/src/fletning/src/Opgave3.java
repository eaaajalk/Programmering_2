package fletning.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Opgave3 {
    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * customers fra l1 der ikke er i l2
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static ArrayList<Customer> goodCustomers(ArrayList<Customer> l1, Customer[] l2) {

            ArrayList<Customer> result = new ArrayList<Customer>();
            int i1 = 0;
            int i2 = 0;

        while (i1 < l1.size() && i2 < l2.length) {

            if (l1.get(i1).compareTo(l2[i2]) > 0) {
                i2++;
            }

            else if (l1.get(i1).compareTo(l2[i2]) < 0) {
                result.add(l1.get(i1));
                i1++;
            }

            else {
                i1++;
                i2++;
            }
        }
        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }

            return result;
    }


    public static void main(String[] args) {
        Customer c1 = new Customer("Annesen", "Anne", 30);
        Customer c2 = new Customer("Børgesen", "Børge", 20);
        Customer c3 = new Customer("Larsen", "Lars", 50);
        Customer c4 = new Customer("Briansen", "Brian", 70);
        Customer c5 = new Customer("Karsensen", "Karsten", 90);
        ArrayList<Customer> list1 = new ArrayList<Customer>();
        list1.add(c2);
        list1.add(c1);
        list1.add(c3);
        list1.add(c4);
        list1.add(c5);
        Collections.sort(list1);

        Customer[] dårligeBetalere = {c1, c4, c5};


        System.out.println(Arrays.toString(dårligeBetalere));

        System.out.println(goodCustomers(list1, dårligeBetalere));
    }
}
