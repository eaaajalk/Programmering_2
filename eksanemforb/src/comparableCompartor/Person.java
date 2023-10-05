package comparableCompartor;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int height;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }
    @Override
    public int compareTo(Person o) {
        return Integer.compare(getAge(), o.getAge());
    }
    public static HeightComparator heightComparator() {
        return new HeightComparator();
    }
    @Override
    public String toString() {
        return getName() + " " + getHeight() + " " + getAge();
    }
}
