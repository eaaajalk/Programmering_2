package personcollection;

public class app {

    public static void main(String[] args) {


        PersonCollection pcol = new PersonCollection();

        Person p1 = new Person("Jens");
        Person p2 = new Person("Hans");

        pcol.add(p1);
        pcol.add(p2);
        System.out.println(pcol.get(1));




    }

}
