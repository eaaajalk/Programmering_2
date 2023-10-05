package person;

public class Name {

    private String surname;
    private String lastname;

    public Name(String surname, String lastname) {
        this.surname = surname;
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return surname + " " + lastname;
    }
}
