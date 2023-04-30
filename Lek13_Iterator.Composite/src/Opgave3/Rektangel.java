package Opgave3;

public class Rektangel extends FigurComponent {
    private String navn;
    private int s1;
    private int s2;

    public Rektangel(String navn, int s1, int s2) {
        this.navn = navn;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public String getNavn() {
        return navn;
    }

    @Override
    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String tegn() {
        return navn;
    }

    @Override
    public double getAreal() {
        return s1 * s2;
    }


}
