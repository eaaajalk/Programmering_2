package Aflevering.Peterson;

import java.util.Random;

public class Faelles {

    private int global = 0;

    public void TagerRandomTid(int max) {
        Random r = new Random();
        int nymax = Math.abs(r.nextInt()) % max + 1;
        for (int i = 0; i < nymax; i++) {
            for (int j = 0; j < nymax; j++) {
                int k = i + j;
            }
            int l = i - 10;
        }
    }

    public int getGlobal() {
        return global;
    }

    public void kritisksection() {
        int temp;
        temp = global;
        TagerRandomTid(200);
        global = temp + 1;
    }
}