package hashsetstudent;

import java.util.ArrayList;

/**
 * This class implements a hash set using separate chaining with an ArrayList.
 */
public class HashSetChainingArrayList {
    private ArrayList<ArrayList<Object>> buckets;
    private int currentSize;

    /**
     * Constructs a hash set.
     *
     * @param bucketsLength the length of the buckets ArrayList
     */
    public HashSetChainingArrayList(int bucketsLength) {
        buckets = new ArrayList<>(bucketsLength);
        for (int i = 0; i < bucketsLength; i++) {
            buckets.add(new ArrayList<>());
        }
        currentSize = 0;
    }

    /**
     * Tests for set membership.
     *
     * @param x an object
     * @return true if x is an element of this set
     */
    public boolean contains(Object x) {
        int h = hashValue(x);
        ArrayList<Object> bucket = buckets.get(h);
        return bucket.contains(x);
    }

    /**
     * Adds an element to this set.
     *
     * @param x an object
     * @return true if x is a new object, false if x was already in the set
     */
    public boolean add(Object x) {
        int h = hashValue(x);
        ArrayList<Object> bucket = buckets.get(h);
        if (bucket.contains(x)) {
            return false;
        }
        bucket.add(x);
        currentSize++;
        rehash();
        return true;
    }

    /**
     * Removes an object from this set.
     *
     * @param x an object
     * @return true if x was removed from this set, false if x was not an element of this set
     */
    public boolean remove(Object x) {
        int h = hashValue(x);
        ArrayList<Object> bucket = buckets.get(h);
        boolean removed = bucket.remove(x);
        if (removed) {
            currentSize--;
        }
        return removed;
    }

    private int hashValue(Object x) {
        int h = x.hashCode();
        if (h < 0) {
            h = -h;
        }
        h = h % buckets.size();
        return h;
    }

    /**
     * Gets the number of elements in this set.
     *
     * @return the number of elements
     */
    public int size() {
        return currentSize;
    }

    private void rehash() {
        if (((double) currentSize / buckets.size()) >= 0.75) {
            ArrayList<ArrayList<Object>> oldBuckets = buckets;
            buckets = new ArrayList<>(2 * oldBuckets.size());
            for (int i = 0; i < buckets.size(); i++) {
                buckets.add(new ArrayList<>());
            }
            for (ArrayList<Object> bucket : oldBuckets) {
                for (Object element : bucket) {
                    int h = hashValue(element);
                    buckets.get(h).add(element);
                }
            }
        }
    }
}

