package Opgave3;

public abstract class FigurComponent {
    public void addFigur(FigurComponent figurComponent) {
        throw new UnsupportedOperationException();
    }
    public void removeFigur(FigurComponent figurComponent) {
        throw new UnsupportedOperationException();
    }
    public void getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String tegn() {
        throw new UnsupportedOperationException();
    }
    public double getAreal() {
        throw new UnsupportedOperationException();
    }
    public String getNavn() {
        throw new UnsupportedOperationException();
    }
    public void setNavn(String navn) {
        throw new UnsupportedOperationException();
    }
}
