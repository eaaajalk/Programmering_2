package Aflevering.Opg3_Moniter;

import java.util.Random;

public class Faelles {

    private int global = 0;

    public synchronized void TagerRandomTid (int max) {
        Random r = new Random();
        int nymax = Math.abs(r.nextInt())% max +1;

        for (int i = 0; i < nymax; i++) {
            for (int j = 0; j < nymax; j++) {
                int k = i+j;
            }
            int l = i-10;
        }
    }

    public synchronized int getGlobal() {
        return global;
    }

    public synchronized void kritisksection() {
        int temp;
        temp = global;
        TagerRandomTid(200);
        global = temp + 1;
    }


}
