package Aflevering.Peterson;

public class Hovedklassen {

    private static int turn;
    private static boolean[] flag;

    public static void main(String[] args) {

        flag = new boolean[2];
        flag[0] = false;
        flag[1] = false;
        turn = 1;

        Faelles f = new Faelles();

        MyThread t1 = new MyThread("Tråd1" , f);
        MyThread2 t2 = new MyThread2("Tråd2", f);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println(f.getGlobal());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean getFlag(int index) {
        return flag[index];
    }

    public static int getTurn() {
        return turn;
    }

    public static void setFlag(int index, boolean b) {
        flag[index] = b;
    }

    public static void setTurn(int setValue) {
        turn = setValue;
    }
}
