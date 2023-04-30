package Opgave3;

import java.util.List;

public class Figur extends FigurComponent {
    private String navn;
    private List<FigurComponent> figurer;

    public Figur(String navn, List<FigurComponent> figurer) {
        this.navn = navn;
        this.figurer = figurer;
    }

    @Override
    public String getNavn() {
        String navn = "";
        for (FigurComponent figur : figurer) {
            navn = figur.getNavn();
        }
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
        double totalAreal = 0.0;
        for (FigurComponent figur : figurer) {
            totalAreal += figur.getAreal();
        }
        return totalAreal;
    }
}
