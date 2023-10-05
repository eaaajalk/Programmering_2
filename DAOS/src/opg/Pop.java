package opg;

import deadlock.kode.Message;

public class Pop extends Thread {

    private Stack stack;

    public Pop (Stack stack) {
        this.stack = stack;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                stack.pop();
                System.out.println("Popped");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
