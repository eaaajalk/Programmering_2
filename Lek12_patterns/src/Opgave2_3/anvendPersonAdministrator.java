package Opgave2_3;

public class anvendPersonAdministrator {

    public static void main(String[] args) {
        PersonAdministrator personAdministrator = PersonAdministrator.getInstance();

        Person p1 = new Person("Jan");
        Person p2 = new Person("Ole");
        personAdministrator.addPerson(p1);
        personAdministrator.addPerson(p2);
        System.out.println(personAdministrator.getPersonSet());
        personAdministrator.removePerson(p1);
        System.out.println(personAdministrator.getPersonSet());

    }

}
