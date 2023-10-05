package person;

public class Person<T> implements Comparable<Person<T>> {

    private T name;

    public Person(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person<T> o) {
        Name n1 = (Name) this.name;
        Name n2 = (Name) o.getName();
        return n1.getSurname().compareTo(n2.getSurname());
    }

}
