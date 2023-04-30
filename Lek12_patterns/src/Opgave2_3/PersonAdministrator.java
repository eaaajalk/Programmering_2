package Opgave2_3;

import java.util.HashSet;
import java.util.Set;

public class PersonAdministrator {

    private static PersonAdministrator instance;
    private Set<Person> personSet = new HashSet<>();

    private PersonAdministrator(){}

    public static PersonAdministrator getInstance() {
        if (instance == null) {
            instance = new PersonAdministrator();
        }
        return instance;
    }

    public void addPerson(Person person){
        personSet.add(person);
    }

    public void removePerson(Person person) {
        if (personSet.contains(person)) {
            personSet.remove(person);
        }
    }

    public Set<Person> getPersonSet() {
        return new HashSet<>(personSet);
    }


}
