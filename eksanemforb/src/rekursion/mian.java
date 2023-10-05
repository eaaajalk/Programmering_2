package rekursion;

import array.Main;

import java.util.ArrayList;
import java.util.List;

public class mian {


    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    public static int max(List<Integer> l) {
        return max(l, 0);
    }
    private static int max(List<Integer> l, int index) {
        if (index == l.size() - 1) {
            return l.get(index);
        } else {
            int currentNum = l.get(index);
            int maxRest = max(l, index + 1);
            return Math.max(currentNum, maxRest);
        }
    }



    // returnerer fibonacci sekvensen
    public static void fibonacci() {
        System.out.print("0" + " ");
        fibonacci(1, 1);
    }
    private static void fibonacci(int i, int j) {
        if (i < 50) {
            System.out.print("" + i + " ");
            fibonacci(j, i+j);
        }
    }

    // returnerer resultatet af x opløftet i n potens
    public static int potens(int x, int n){
        if (n != 1) {
            return x * potens(x, n-1);
        }
        return x;
    }






    public static void main(String[] args) {
        System.out.println(sum(5));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(9);
        System.out.println(max(list));
        fibonacci();
        System.out.println(potens(5, 4));
    }


}
