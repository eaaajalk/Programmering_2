package comparableCompartor;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        Person p1 = new Person("jens", 22, 180);
        Person p2 = new Person("anne", 50, 150);
        Person p3 = new Person("Åse", 98, 130);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        //sorteret efter standard - altså alder:
        System.out.println(list);

        //sorteret efter højde med comparator:
        list.sort(Person.heightComparator());
        System.out.println(list);

    }
}
