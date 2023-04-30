package Opgave4;

public class Adaptor extends Vare {

    private Spiritus spiritus;

    public Adaptor(Spiritus spiritus) {
        super(spiritus.getPrisen(), spiritus.getBetgenelse());
        this.spiritus = spiritus;
    }

    public void setPris(int pris) {
        spiritus.setPrisen(pris);
    }

    public String getNavn() {
        return spiritus.getBetgenelse();
    }

    public void setNavn(String navn) {
        spiritus.setBetgenelse(navn);
    }

    @Override
    public double beregnMoms() {
        return spiritus.hentMoms();
    }
}

