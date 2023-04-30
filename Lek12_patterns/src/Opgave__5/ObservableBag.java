package Opgave__5;

import java.util.*;

public class ObservableBag implements Bag, Iterable<String> {

    private final Map<String, Integer> map;
    private final List<Observer> observers = new ArrayList<>();

    public ObservableBag() {
        map = new HashMap<>();
    }

    @Override
    public void registerObserver(Observer o) {
            observers.add((Observer) o);
    }

    @Override
    public void removeObserver(Observer o) {
            observers.remove(o);
    }

    @Override
    public void add(String s) {
        int i = 0;
        if (map.containsKey(s)) {
            i = map.get(s);
            map.put(s,i+1);
        } else {
            map.put(s, 1);
        }
        notifyObservers(s, i + 1);
    }

    @Override
    public void remove(String s) {
        int i = map.get(s);
        if (i > 1) {
            map.put(s, i - 1);
        } else if (i == 1) {
            map.remove(s, 1);
        }
        notifyObservers(s,  i - 1);
    }

    @Override
    public int getCount(String s) {
        if (map.get(s) == null) {
            return 0;
        } else {
            return map.get(s);
        }
    }

    private void notifyObservers(String s, int count) {
        for (Observer observer : observers) {
            observer.update(s, count);
        }
    }
    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }
}




