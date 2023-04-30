package Opgave5;

import java.util.ArrayList;

public class Saelger implements Observer{

    private Subject subject;
    private String navn;

    public Saelger(String navn) {
        this.navn = navn;
    }

    @Override
    public void update(Subject s) {
        if (s instanceof BogTitel) {
            BogTitel bog = (BogTitel) s;
            System.out.println("Kære " + navn + ". Et eksemplar af " + bog.getTitel() + " er blevet solgt.");

            ArrayList<String> mersalg = new ArrayList<>();
            ArrayList<Kunde> kunder = bog.getKunder();

            for (Kunde k : kunder) {
                ArrayList<BogTitel> titler = k.getBogTiteler();
                for (BogTitel bogTitel : titler) {
                    if (!bogTitel.getTitel().equals(bog.getTitel())) {
                        if (!mersalg.contains(bogTitel.getTitel())) {
                            mersalg.add(bogTitel.getTitel());
                        }
                    }
                }
            }
            if (mersalg.size() > 0) {
                System.out.println("Andre kunder har også købt:");
                for (int i = 0; i < mersalg.size(); i++) {
                    System.out.println(mersalg.get(i));
                }
                System.out.println();
            }
        }
    }
}
