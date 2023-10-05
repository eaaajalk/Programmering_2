package opgave1;

import java.util.HashMap;
import java.util.HashSet;

public class App {

    public static void main(String[] args) {


        Bil b1 = new Bil("AB1234", "Mazda", "6", "Rød");
        Bil b2 = new Bil("AB1234", "Mazda", "6", "Rød");
        Bil b3 = new Bil("CD9876", "Opel", "Kadet", "Sort");
        Bil b4 = new Bil("HD1234", "BMW", "X1", "Hvid");

        HashSet<Bil> set = new HashSet<>();
        set.add(b1);
        set.add(b2);
        set.add(b3);
        set.add(b4);

        System.out.println(set.size());
        System.out.println(set);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "hej");
        map.put(1, "hejsa");

        System.out.println(map.get(1));



    }

}
