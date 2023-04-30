package Opgave5;

public class Indkoeber implements Observer{

    private String navn;

    public Indkoeber(String navn) {
        this.navn = navn;
    }

    @Override
    public void update(Subject s) {
        if (s instanceof BogTitel) {
            BogTitel bog = (BogTitel) s;
            if (bog.getAntal() < 6) {
                System.out.println("Kære " + navn + ". Der skal bestilles 10 stk af " + bog.getTitel());
                System.out.println();
                ((BogTitel) s).indkoebTilLager(10);
            }
        }

    }
}
