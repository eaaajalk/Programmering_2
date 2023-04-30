package Opgave3;

public class Trekant extends FigurComponent {
    private String navn;
    private double h;
    private double g;

    public Trekant(String navn, double h, double g) {
        this.navn = navn;
        this.h = h;
        this.g = g;
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
        return 0.5 * h * g;
    }
}
