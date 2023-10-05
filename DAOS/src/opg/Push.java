package opg;
public class Push extends Thread {
    private Stack stack;
    public Push(Stack stack) {
        this.stack = stack;
    }
    @Override
    public void run() {
        while (true) {
            try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                stack.push(i);
                System.out.println("Pushed: " + i);
            }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
