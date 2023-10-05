package Aflevering.Opg3_Moniter;


public class Hovedklassen {
    public static void main(String[] args) {
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
}
