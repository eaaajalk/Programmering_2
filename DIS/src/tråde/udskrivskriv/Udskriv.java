package tråde.udskrivskriv;

public class Udskriv extends Thread {

    private Common common;

    public Udskriv(Common common) {
        this.common = common;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(3000);
                System.out.println(common.getString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
