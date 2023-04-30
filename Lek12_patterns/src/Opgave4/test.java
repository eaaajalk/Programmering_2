package Opgave4;

import java.sql.SQLOutput;

public class test {

    public static void main(String[] args) {

        Vare v1 = new ElVare(100, "Pendel");
        Vare v2 = new FoedeVare(50, "Hel Kylling");
        Spiritus vodka = new Spiritus(100, "Vodka");

        Vare v3 = new Adaptor(vodka);
        System.out.println(v3.beregnMoms());
        System.out.println(v1.beregnMoms());
        System.out.println(v2.beregnMoms());




    }
}
