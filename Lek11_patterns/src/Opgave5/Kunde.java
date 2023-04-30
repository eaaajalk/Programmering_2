package Opgave5;

import java.util.ArrayList;

public class Kunde {
    private final ArrayList<BogTitel> bogTiteler = new ArrayList<>();
    private String navn;

    public Kunde(String navn) {
        this.navn = navn;
    }

    public ArrayList<BogTitel> getBogTiteler() {
        return new ArrayList<>(bogTiteler);
    }

    public void addBogtitel (BogTitel b) {
        if (!bogTiteler.contains(b)) {
            bogTiteler.add(b);
            b.addKunde(this);
        }
    }
    public void removeBogtitel (BogTitel b) {
        if (bogTiteler.contains(b)) {
            bogTiteler.remove(b);
        }
    }

}
