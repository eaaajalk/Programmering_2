package hashsetstudent;
    /**
     * This class implements a hash set using double hashing.
     */
    public class HashSetDoubleHashing {
        private Object[] buckets;
        private int currentSize;
        private static final String DELETED = "DELETED";

        /**
         * Constructs a hash set.
         *
         * @param bucketsLength the length of the buckets array
         */
        public HashSetDoubleHashing(int bucketsLength) {
            buckets = new Object[bucketsLength];
            currentSize = 0;
        }

        /**
         * Tests for set membership.
         *
         * @param x an object
         * @return true if x is an element of this set
         */
        public boolean contains(Object x) {
            int h1 = hashValue1(x);
            int h2 = hashValue2(x);
            int i = 0;
            while (buckets[(h1 + i * h2) % buckets.length] != null) {
                if (buckets[(h1 + i * h2) % buckets.length].equals(x)) {
                    return true;
                }
                i++;
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
            int h1 = hashValue1(x);
            int h2 = hashValue2(x);
            int i = 0;
            while (buckets[(h1 + i * h2) % buckets.length] != null && buckets[(h1 + i * h2) % buckets.length] != DELETED) {
                if (buckets[(h1 + i * h2) % buckets.length] == x) {
                    return false;
                }
                i++;
            }
            buckets[(h1 + i * h2) % buckets.length] = x;
            currentSize++;
            return true;
        }

        /**
         * Removes an object from this set.
         *
         * @param x an object
         * @return true if x was removed from this set, false if x was not an element of this set
         */
        public boolean remove(Object x) {
            int h1 = hashValue1(x);
            int h2 = hashValue2(x);
            int i = 0;
            while (buckets[(h1 + i * h2) % buckets.length] != null) {
                if (buckets[(h1 + i * h2) % buckets.length].equals(x)) {
                    buckets[(h1 + i * h2) % buckets.length] = DELETED;
                    return true;
                }
                i++;
            }
            return false;
        }

        /**
         * Gets the number of elements in this set.
         *
         * @return the number of elements
         */
        public int size() {
            return currentSize;
        }

        private int hashValue1(Object x) {
            int h = x.hashCode();
            if (h < 0) {
                h = -h;
            }
            return h % buckets.length;
        }

        private int hashValue2(Object x) {
            int h = x.hashCode();
            if (h < 0) {
                h = -h;
            }
            return 1 + (h % (buckets.length - 2)); // Using (buckets.length - 2) to ensure h2 is relatively prime to the size
        }

        // method only for test purpose
        public void writeOut() {
            for (int i = 0; i < buckets.length; i++) {
                System.out.println(i + "\t" + buckets[i]);
            }
        }
    }


