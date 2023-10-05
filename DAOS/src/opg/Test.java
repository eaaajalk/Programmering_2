package opg;

public class Test {
    public static void main(String[] args) {
            Stack stack = new Stack();
            Thread push = new Push(stack);
            Thread pop = new Pop(stack);
            push.start();
            pop.start();


    }
}
