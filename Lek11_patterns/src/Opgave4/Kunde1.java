package Opgave4;

import java.util.Comparator;

public class Kunde1 implements Comparable<Kunde1> {
    private String navn;
    private int nummer;
    private Comparator<Kunde1> comparator;

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

    public void setComparator(Comparator<Kunde1> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Kunde1> getComparator() {
        return this.comparator;
    }

    @Override
    public int compareTo(Kunde1 o) {
        return getComparator().compare(this, o);
    }

    public static Comparator<Kunde1> compareNavn() {
        return new CompareNavn();
    }

    public static Comparator<Kunde1> compareNummer() {
        return new CompareNummer();
    }
}
