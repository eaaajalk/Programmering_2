package stack;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        ArrayList<Integer> test = new ArrayList<>();

        test.add(2);
        test.add(1);
        test.add(9);
        test.add(50);

        System.out.println(test);
        System.out.println(test.get(0));

        System.out.println(test.get(test.size()-1));
    }
}
