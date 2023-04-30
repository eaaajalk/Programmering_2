package linkedlist.opgave2sortedlinkedlist;

import java.sql.SQLOutput;

public class opg2App {

    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.addElement("c");
        list.addElement("a");
        list.addElement("b");

        list.udskrivElements();

        System.out.println("\ncount elements:");
        System.out.println(list.countElements());

        System.out.println("\nremove last:");
        System.out.println(list.removeLast());
        list.udskrivElements();

        System.out.println("\nremove 'a':");
        list.removeElement("a");
        list.udskrivElements();


        SortedLinkedList list2 = new SortedLinkedList();
        list2.addElement("a");
        list2.addElement("d");
        list2.addElement("c");

        System.out.println("\nadd all:");
        list.addAll(list2);
        list.udskrivElements();

        System.out.println("\nRekusiv tælller: " + list.countElements2());

        list.addElement("h");
        System.out.println("\nRekusiv tælller: " + list.countElements2());






    }




}
