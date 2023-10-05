package sortering;

import sortering.model.Customer;

import java.util.ArrayList;
import java.util.Collections;

public class TestSort {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Jan");
        list.add("Bent");
        list.add("Thomas");
        list.add("Karsten");
        list.add("Dan");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        // Det er muligt med comparable interface

        Customer c = new Customer("Lars", "Hanse", 28);
        Customer c1 = new Customer("Hans", "Hansen", 50);
        Customer c2 = new Customer("Yrsa", "Sørense", 90);
        ArrayList<Customer> list1 = new ArrayList<Customer>();
        list1.add(c);
        list1.add(c1);
        list1.add(c2);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);
    }
}
