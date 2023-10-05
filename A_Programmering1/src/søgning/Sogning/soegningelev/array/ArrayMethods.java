package søgning.Sogning.soegningelev.array;

public class ArrayMethods {
    public void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            }
            else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }

    /**
     *
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public int[] fyldArrayA() {
        int[] result = new int[10];
        return result;
    }
    
    /**
     *
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public int[] fyldArrayB() {
        int[] result = new int[10];
        //TODO
        return result;
    }
    
    /**
     *
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public int[] fyldArrayC() {
        int[] result = new int[10];
        //TODO
        return result;
    }

    /**
     *
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
     */
    public int[] fyldArrayD() {
        int[] result = new int[10];
        //TODO
        return result;
    }

    /**
     *
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
     */
    public int[] fyldArrayE() {
        int[] result = new int[10];
        //TODO
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
     */
    public int[] fyldArrayF() {
        int[] result = new int[10];
        //TODO
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
     */
    public int[] fyldArrayG() {
        int[] result = new int[10];
        //TODO
        return result;
    }
    
    public int findMax(int[] tabel) {
        int max = -1;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        return max;
    }
}
