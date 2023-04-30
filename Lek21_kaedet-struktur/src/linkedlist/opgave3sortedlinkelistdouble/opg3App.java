package linkedlist.opgave3sortedlinkelistdouble;

import linkedlist.opgave2sortedlinkedlist.SortedLinkedList;

public class opg3App {
    public static void main(String[] args) {
        SortedLinkedListDouble list = new SortedLinkedListDouble();
        list.addElement("c");
        list.addElement("a");
        list.addElement("b");

        list.udskrivElements();

        System.out.println("\ncount elements:");
        System.out.println(list.countElements());


        System.out.println("\nremove 'a':");
        System.out.println(list.removeElement("a"));
        list.udskrivElements();

        System.out.println("\nudskriv bagfra:");
        list.udskrivBagfra();


    }

}
