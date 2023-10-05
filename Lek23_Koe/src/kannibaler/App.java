package kannibaler;

public class App {
    public static void main(String[] args) {


        Person p = new Person("Hans");
        Person p1 = new Person("Grethe");
        Person p2 = new Person("Ib");
        Person p3 = new Person("Signe");

        CirkulærListe list = new CirkulærListe();
        list.addPerson(p);
        list.addPerson(p1);
        list.addPerson(p2);
        list.addPerson(p3);

        System.out.println(list.randomStart().data);

        System.out.println();

        while (!list.isEmpty()) {
            System.out.println(list.remove(2).data);
        }



    }



}
