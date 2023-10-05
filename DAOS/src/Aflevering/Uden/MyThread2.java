package Aflevering.Uden;
public class MyThread2 extends Thread{
    private String navn;
    private Faelles faelles;

    public MyThread2(String navn, Faelles faelles) {
        this.navn = navn;
        this.faelles = faelles;
    }

    public void run() {
        for (int j=0; j<100;j++) {
            faelles.kritisksection();
            faelles.TagerRandomTid(200);
        }
        System.out.println(faelles.getGlobal());
    }

}


