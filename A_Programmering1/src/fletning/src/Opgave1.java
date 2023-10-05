package fletning.src;

import java.util.ArrayList;
import java.util.Collections;

public class Opgave1 {

    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * kunder fra både l1 og l2
     * Krav: l1 og l2 er sorterede
     */

    public static ArrayList fletAlleKunder(ArrayList<Customer> l1, ArrayList<Customer> l2){
        ArrayList<Customer> result = new ArrayList<Customer>();
        int i1 = 0;
        int i2 = 0;
        // flet sålænge der er noget i begge lister
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1).compareTo((l2.get(i2))) <= 0) {
                // l1's første tal er mindst
                result.add(l1.get(i1));
                i1++;
            }
            else { // s2's første tal er mindst
                result.add(l2.get(i2));
                i2++;
            }
        }
        // tøm den liste der ikke er tom
        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()) {
            result.add(l2.get(i2));
            i2++;
        }
        return result;
    }




    public static void main(String[] args) {
        Customer c1 = new Customer("Annesen", "Anne", 30);
        Customer c2 = new Customer("Børgesen", "Børge", 20);
        Customer c3 = new Customer("Larsen", "Lars", 50);
        ArrayList<Customer> list1 = new ArrayList<Customer>();
        list1.add(c2);
        list1.add(c1);
        list1.add(c3);
        Collections.sort(list1);

        Customer c4 = new Customer("Briansen", "Brian", 70);
        Customer c5 = new Customer("Karsensen", "Karsten", 90);
        ArrayList<Customer> list2 = new ArrayList<Customer>();
        list2.add(c4);
        list2.add(c5);
        Collections.sort(list2);

        System.out.println(fletAlleKunder(list1, list2));



    }
}
