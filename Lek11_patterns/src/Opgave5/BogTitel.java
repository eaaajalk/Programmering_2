package Opgave5;

import java.util.ArrayList;
import java.util.Iterator;

public class BogTitel implements Subject {

    private final ArrayList<Observer> observers = new ArrayList<>();
    private final ArrayList<Kunde> kunder = new ArrayList<>();

    private String titel;
    private int antal;

    public BogTitel(String titel, int antal) {
        this.titel = titel;
        this.antal = antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getTitel() {
        return titel;
    }

    public int getAntal() {
        return antal;
    }

    public void indkoebTilLager(int antal) {
        setAntal(getAntal() + antal);
    }

    public void etKoeb(Kunde k) {
        addKunde(k);
        k.addBogtitel(this);
        setAntal(getAntal()-1);
        notifyObservers();
    }
    public void notifyObservers () {
        for (Observer o : observers) {
            o.update(this);
        }
    }
    @Override
    public void addObserver(Observer o) {
        addObersver(o);
    }

    @Override
    public void removeObserver(Observer o) {
       removeObersver(o);
    }

    public ArrayList<Observer> getObservers() {
        return new ArrayList<>(observers);
    }

    public void addObersver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    public void removeObersver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    public ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

    public void addKunde(Kunde k) {
        if (!kunder.contains(k)) {
            kunder.add(k);
            k.addBogtitel(this);
        }
    }

    public void removeKunde(Kunde k) {
        if (kunder.contains(k)) {
            kunder.remove(k);
        }
    }
}
