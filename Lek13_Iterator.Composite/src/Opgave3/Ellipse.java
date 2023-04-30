package Opgave3;

public class Ellipse extends FigurComponent {
    private String navn;
    private double r1;
    private double r2;

    public Ellipse(String navn, double r1, double r2) {
        this.navn = navn;
        this.r1 = r1;
        this.r2 = r2;
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
        return Math.PI * r1 * r2;
    }
}
