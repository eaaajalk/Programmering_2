package sortering;

import sortering.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class Oggave2 {

    // String array
    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void selectionSort(String[] list) {
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minPos]) < 0) {
                    minPos = j;
                }

            }
            swap(list, i, minPos);
        }
    }

    // Customer array
    private static void swapCustomer(ArrayList<Customer> list, int i, int j) {
        Customer temp = list.get(i);
        Customer temp1 = list.get(j);
        list.set(i, temp1);
        list.set(j, temp);
    }

    public static void selectionSortCustomer(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minPos)) < 0) {
                    minPos = j;
                }

            }
            swapCustomer(list, i, minPos);
        }
    }




    public static void main(String[] args) {
        // Tester af String Array
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        selectionSort(s);
        System.out.println(Arrays.toString(s));

        // Tester Customer array
        Customer c = new Customer("Lars", "Hanse", 28);
        Customer c1 = new Customer("Hans", "Hansen", 50);
        Customer c2 = new Customer("Yrsa", "Sørense", 90);
        ArrayList<Customer> list = new ArrayList<Customer>();
        list.add(c);
        list.add(c1);
        list.add(c2);

        selectionSortCustomer(list);
        System.out.println(list);

    }

}
