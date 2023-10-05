package personcollection;

import java.util.Iterator;

public class app {

    public static void main(String[] args) {



        PersonCollection pcol = new PersonCollection(2);

        Person p1 = new Person("Jens");
        Person p2 = new Person("Hans");




        pcol.add(p1);
        pcol.add(p2);

        for (Person person : pcol) {
            System.out.println(person);


        }




    }

}
