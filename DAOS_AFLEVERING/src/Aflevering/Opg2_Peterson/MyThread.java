package Aflevering.Opg2_Peterson;
public class MyThread extends Thread {
    private String navn;
    private Faelles faelles;

    public MyThread(String navn, Faelles faelles) {
        this.navn = navn;
        this.faelles = faelles;
    }

    public void run() {
        for (int j = 0; j < 100; j++) {
            Hovedklassen.setFlag(0, true);
            Hovedklassen.setTurn(1);
            while (Hovedklassen.getFlag(1) && Hovedklassen.getTurn() == 1) {}

            faelles.kritisksection();
            faelles.TagerRandomTid(200);

            Hovedklassen.setFlag(0, false);
            Hovedklassen.setTurn(1);
        }
        System.out.println(faelles.getGlobal());
    }
}



