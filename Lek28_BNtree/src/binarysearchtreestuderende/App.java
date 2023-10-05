package binarysearchtreestuderende;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bn = new BinarySearchTree<>();
        bn.add(45);
        bn.add(22);
        bn.add(11);
        bn.add(15);
        bn.add(30);
        bn.add(25);
        bn.add(77);
        bn.add(90);
        bn.add(88);
        System.out.println(Arrays.toString(bn.toArray()));
        System.out.println("max:");
        System.out.println(bn.max());
        System.out.println("min:");
        System.out.println(bn.min());
        System.out.println("Fjerner min:");
        System.out.println(bn.removeMin());
        System.out.println("Fjerner max:");
        System.out.println(bn.removeMax());






    }
}
