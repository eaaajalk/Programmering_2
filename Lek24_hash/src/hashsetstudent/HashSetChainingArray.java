package hashsetstudent;

import java.util.Arrays;

/**
 * This class implements a hash set using separate chaining with an array.
 */
public class HashSetChainingArray {
    private Object[][] buckets;
    private int[] sizes;
    private int currentSize;

    /**
     * Constructs a hash set.
     *
     * @param bucketsLength the length of the buckets array
     */
    public HashSetChainingArray(int bucketsLength) {
        buckets = new Object[bucketsLength][];
        sizes = new int[bucketsLength];
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
        Object[] bucket = buckets[h];
        if (bucket == null) {
            return false;
        }
        for (Object element : bucket) {
            if (element.equals(x)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds an element to this set.
     *
     * @param x an object
     * @return true if x is a new object, false if x was already in the set
     */
    public boolean add(Object x) {
        int h = hashValue(x);
        Object[] bucket = buckets[h];
        if (bucket == null) {
            bucket = new Object[1];
            bucket[0] = x;
            buckets[h] = bucket;
            sizes[h] = 1;
            currentSize++;
            rehash();
            return true;
        }
        for (Object element : bucket) {
            if (element.equals(x)) {
                return false;
            }
        }
        Object[] newBucket = Arrays.copyOf(bucket, sizes[h] + 1);
        newBucket[sizes[h]] = x;
        buckets[h] = newBucket;
        sizes[h]++;
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
        Object[] bucket = buckets[h];
        if (bucket == null) {
            return false;
        }
        for (int i = 0; i < sizes[h]; i++) {
            if (bucket[i].equals(x)) {
                if (sizes[h] == 1) {
                    buckets[h] = null;
                } else {
                    System.arraycopy(bucket, i + 1, bucket, i, sizes[h] - i - 1);
                    bucket[sizes[h] - 1] = null;
                }
                sizes[h]--;
                currentSize--;
                return true;
            }
        }
        return false;
    }

    private int hashValue(Object x) {
        int h = x.hashCode();
        if (h < 0) {
            h = -h;
        }
        h = h % buckets.length;
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
        if (((double) currentSize / buckets.length) >= 0.75) {
            int newLength = buckets.length * 2;
            Object[][] newBuckets = new Object[newLength][];
            int[] newSizes = new int[newLength];

            for (int i = 0; i < buckets.length; i++) {
                Object[] bucket = buckets[i];
                if (bucket != null) {
                    for (Object element : bucket) {
                        int h = hashValue(element);
                        Object[] newBucket = newBuckets[h];
                        if (newBucket == null) {
                            newBucket = new Object[1];
                            newBucket[0] = element;
                            newBuckets[h] = newBucket;
                            newSizes[h] = 1;
                        } else {
                            Object[] expandedBucket = Arrays.copyOf(newBucket, newSizes[h] + 1);
                            expandedBucket[newSizes[h]] = element;
                            newBuckets[h] = expandedBucket;
                            newSizes[h]++;
                        }
                    }
                }
            }

            buckets = newBuckets;
            sizes = newSizes;
        }
    }
}
