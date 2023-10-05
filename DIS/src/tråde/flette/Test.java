package tråde.flette;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            list.add(Math.abs(r.nextInt() % 10000));
        }
        //System.out.println(list);

        FletteSortering fletteSortering = new FletteSortering();

        SortThreads thread1 = new SortThreads(list, 0, list.size() / 2 - 1, fletteSortering);
        SortThreads thread2 = new SortThreads(list, list.size() / 2, list.size() - 1, fletteSortering);

        long l1,l2;
        l1 = System.nanoTime();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ignored) {
        }

        //fletteSortering.merge(list, 0, list.size() / 2 - 1, list.size() - 1);

        l2 = System.nanoTime();
        System.out.println();
        System.out.println("Køretiden var " + (l2-l1)/1000000);

        //System.out.println(list);

    }
}
