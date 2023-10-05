package afleveringDictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryArrayList<K, V> implements Dictionary<K, V> {
    List<Item>[] tabel;
    private static int N = 10;

    public DictionaryArrayList() {
        tabel = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tabel[i] = new ArrayList<Item>();
        }
    }
    @Override
    public V get(K key) {
        V v = null;
        int i = key.hashCode() % N;
        List<Item> l = tabel[i];
        for (Item e : l) {
            if (e.key.equals(key)) {
                v = e.value;
            }
        }
        return v;
    }
    @Override
    public boolean isEmpty() {
        boolean empty = true;
        int i = 0;
        while (empty && i < N) {
            empty = (tabel[i]).isEmpty();
            i++;
        }
        return empty;
    }

    @Override
    public V put(K key, V value) {
        V v = null;
        boolean b = false;
        int i = key.hashCode() % N;
        List<Item> l = tabel[i];
        for (Item e : l) {
            if (e.key.equals(key)) {
                v = e.value;
                e.value = value;
                b = true;
            }
        }
        if (!b) {
            Item item = new Item();
            item.value = value;
            item.key = key;
            l.add(item);
        }
        return v;
    }

    @Override
    public V remove(K key) {
        V v = null;
        int i = key.hashCode() % N;
        List<Item> l = tabel[i];
        for (Item e : l) {
            if (e.key.equals(key)) {
                v = e.value;
                l.remove(e);
                return v;
            }
        }
        return v;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < N; i++) {
            counter += tabel[i].size();
        }
        return counter;
    }

    private class Item {
        K key;
        V value;
    }
}
