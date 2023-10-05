package stack;
import stack.ArrayListStack;

public class StackDemo {
    public static void main(String[] args) {
          StackI s = new NodeStack();
       // StackI s = new ArrayStack(5);
        s.push("Tom");
        s.push("Diana");
        s.push("Harry");
        s.push("Thomas");
        s.push("Bob");
        s.push("Brian");
        System.out.println(s.peek());
        System.out.println(s.isEmpty() + " " + s.size());
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        System.out.println();
        System.out.println(s.isEmpty() + " " + s.size());
        System.out.println();


        System.out.println(checkParantes("(3+{5{99{*}}[23[{67}67]]})"));

        //-------- test af reverse --------

        Integer[] tal = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverse(tal);
        for (int i = 0; i < tal.length; i++) {
            System.out.print(tal[i] + " ");
        }
    }

    public static void reverse(Object[] tabel) {
        //StackI stack = new ArrayStack(tabel.length);
        StackI stack = new NodeStack();
        for (int i = 0; i < tabel.length; i++) {
            stack.push(tabel[i]);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            tabel[i] = stack.pop();
            i++;
        }
    }

    public static boolean checkParantes(String s) {
        ArrayListStack stack = new ArrayListStack();
        String left = "({[";
        String right = ")}]";
        boolean b = true;

        for (int i = 0; i < s.length() && b; i++) {
            char x = s.charAt(i);
            if (left.indexOf(x) != -1) {
                stack.push(x);
            } else if (right.indexOf(x) != -1) {
                if (stack.isEmpty()) {
                    b = false;
                } else {
                    char top = (char) stack.pop();
                    if (left.indexOf(top) != right.indexOf(x)) {
                        b = false;
                    }
                }
            }
        }

        if (b && !stack.isEmpty()) {
            b = false;
        }

        return b;
    }
}






