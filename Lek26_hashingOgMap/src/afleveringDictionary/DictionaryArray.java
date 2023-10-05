package afleveringDictionary;
public class DictionaryArray<K, V> implements Dictionary<K, V> {
    private static final int DEFAULT_CAPACITY = 10;

    private Entry<K, V>[] table;
    private int size;

    public DictionaryArray() {
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
            entry = entry.next;
        }

        // Key not found, add a new entry
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;
        return null;
    }

    @Override
    public V remove(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        Entry<K, V> prevEntry = null;
        while (entry != null) {
            if (entry.key.equals(key)) {
                V value = entry.value;
                if (prevEntry != null) {
                    prevEntry.next = entry.next;
                } else {
                    table[index] = entry.next;
                }
                size--;
                return value;
            }
            prevEntry = entry;
            entry = entry.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return (hashCode & 0x7FFFFFFF) % table.length;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
