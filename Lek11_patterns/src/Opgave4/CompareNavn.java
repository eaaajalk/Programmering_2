package Opgave4;

import java.util.Comparator;

public class CompareNavn implements Comparator<Kunde1> {

    @Override
    public int compare(Kunde1 o1, Kunde1 o2) {
        return o1.getNavn().compareTo(o2.getNavn());
    }

}
