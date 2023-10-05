package tråde.udskrivskriv;

import java.util.Scanner;

public class Indlæs extends Thread {

    private Common common;
    private Scanner sc;


    public Indlæs(Common common) {
        this.common = common;
    }
    @Override
    public void run() {
        sc = new Scanner(System.in);
        while (true) {
            try {
                String string = sc.next();
                Thread.sleep(0);
                common.setString(string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
