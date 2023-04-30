package DAOS_LEK6;

public class Person {

    private String navn;
    private String init;

    public Person(String navn, String init) {
        this.navn = navn;
        this.init = init;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }

    @Override
    public String toString() {
        return getNavn() + " (" + getInit() + ")";
    }
}
