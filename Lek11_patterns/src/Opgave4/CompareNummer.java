package Opgave4;

import java.util.Comparator;

public class CompareNummer implements Comparator<Kunde1> {
    @Override
    public int compare(Kunde1 o1, Kunde1 o2) {
        return Integer.compare(o1.getNummer(), o2.getNummer());
    }
}
