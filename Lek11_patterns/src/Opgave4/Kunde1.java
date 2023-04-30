package Opgave4;

import java.util.Comparator;

public class Kunde1 implements Comparable<Kunde1> {
    private String navn;
    private int nummer;

    public Kunde1(String navn, int nummer) {
        this.navn = navn;
        this.nummer = nummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String toString() {
        return navn + " " + nummer;
    }

    @Override
    public int compareTo(Kunde1 o) {
        return new CompareNummer().compare(this, o);
    }

    public static Comparator<Kunde1> compareNavn() {
        return new CompareNavn();
    }

    public static Comparator<Kunde1> compareNummer() {
        return new CompareNummer();
    }
}
