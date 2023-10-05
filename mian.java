public class mian {

    public static int[] arrayDiff(int[] a, int[] b) {
        // Your code here
        int x = 0;
        int[] c = new int[x];
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < b.length-1; j++) {
                if (a[i] == b[j]) {
                    x++;
                    c[x-1] = a[i];
                }
            }
        }
        return c;
    }
}
