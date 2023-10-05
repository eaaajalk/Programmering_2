package Aflevering.Opg2_Peterson;
public class MyThread2 extends Thread {
    private String navn;
    private Faelles faelles;

    public MyThread2 (String navn, Faelles faelles) {
        this.navn = navn;
        this.faelles = faelles;
    }

    public void run() {
        for (int j=0; j<100;j++) {

            Hovedklassen.setFlag(1, true);
            Hovedklassen.setTurn(0);
            while (Hovedklassen.getFlag(0) && Hovedklassen.getTurn() == 0) {}
            faelles.kritisksection();
            faelles.TagerRandomTid(200);

            Hovedklassen.setFlag(1, false);
        }
        System.out.println(faelles.getGlobal());
    }

}


