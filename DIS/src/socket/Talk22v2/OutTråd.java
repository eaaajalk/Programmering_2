package socket.Talk22v2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

public class OutTråd extends Thread {

    private BufferedReader inFromUser;
    private DataOutputStream outTo;
    private boolean running;

    public OutTråd(BufferedReader inFromUser, DataOutputStream outTo) {
        this.inFromUser = inFromUser;
        this.outTo = outTo;
        this.running = true;
    }
    public void stopThread() {
        running = false;
    }
    @Override
    public void run() {
        while (running) {
            String message;
            try {
                message = inFromUser.readLine();
                outTo.writeBytes(message + '\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

