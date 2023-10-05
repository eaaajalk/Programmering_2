package sortering;

import sortering.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class Opgave3 {

    public static void insertioneSortString(String[] list) {
        for (int i = 1; i < list.length; i++) {
            String next = list[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list[j - 1]) > 0) {
                    found = true;
                } else {
                    list[j] = list[j - 1];
                    j--;
                }
            }
            list[j] = next;
        }
    }
    public static void insertioneSortCustomer(ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {
            Customer next = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list.get(j-1)) > 0) {
                    found = true;
                } else {
                    Customer p = list.get(j-1);
                    list.set(j, p);
                    j--;
                }
            }
            list.set(j, next);
        }
    }

    public static void main(String[] args) {
        // Tester af String Array
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        insertioneSortString(s);
        System.out.println(Arrays.toString(s));

        // Tester Customer array
        Customer c = new Customer("Lars", "Hanse", 28);
        Customer c1 = new Customer("Hans", "Hansen", 50);
        Customer c2 = new Customer("Yrsa", "Sørense", 90);
        ArrayList<Customer> list = new ArrayList<Customer>();
        list.add(c);
        list.add(c1);
        list.add(c2);


       insertioneSortCustomer(list);
        System.out.println(list);

    }


}
