package Opgave4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {


        Kunde1 k1 = new Kunde1("Hej", 123);
        Kunde1 k2 = new Kunde1("Abe", 987);
        Kunde1 k3 = new Kunde1("Ulla", 567);
        List<Kunde1> kunder = new ArrayList<>();
        kunder.add(k1);
        kunder.add(k2);
        kunder.add(k3);

        System.out.println("Printer kunder");
        for (Kunde1 k : kunder) {
            System.out.println(k);
        }

        System.out.println();

        kunder.sort(Kunde1.compareNummer());
        System.out.println("Printer kunder storteret efter nummer");

        for (Kunde1 k : kunder) {
            System.out.println(k);
        }
        System.out.println();

        kunder.sort(Kunde1.compareNavn());
        System.out.println("Printer kunder sorteret efter navn");
        for (Kunde1 k : kunder) {
            System.out.println(k);
        }

    }
}
