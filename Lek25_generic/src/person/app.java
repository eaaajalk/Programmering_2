package person;

import java.util.ArrayList;
import java.util.Collections;

public class app {

    public static void main(String[] args) {

        Person<Name> p = new Person<>(new Name("Jakob", "Krog"));
        Person<Name> p1 = new Person<>(new Name("Anne", "Hansen"));
        Person<Name> p2 = new Person<>(new Name("Lars", "Iversen"));

        ArrayList<Person<Name>> list = new ArrayList<>();
        list.add(p);
        list.add(p1);
        list.add(p2);

        for (Person<Name> O : list) {
            System.out.println(O.getName());
        }

        Collections.sort(list);
        for (Person<Name> O : list) {
            System.out.println(O.getName());
        }
    }
}
