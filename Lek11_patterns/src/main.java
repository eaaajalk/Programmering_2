public class main {
    public class DigPow {

        public static long digPow(int n, int p) {
            // your code
            int temp = 0;
            int result = -1;
            String nu = String.valueOf(n);
            for (int i = 0; i < nu.length(); i++) {
                int s = nu.charAt(i);
                temp = (int) Math.pow(nu.charAt(i),(p+i));
            }
            int res1 = temp + temp;

            int k = res1 / n;

            if (n*k == res1) {
                result = k;
            }

            return result;
        }

    }

}
