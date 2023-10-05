package composite;

public abstract class Employee {

    private String navn;
    private String stilling;

    public Employee(String navn, String stilling) {
        this.navn = navn;
        this.stilling = stilling;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public String displayDetails() {
        return getNavn() + " " + getStilling();
    }
}
