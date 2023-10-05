package socket.Talk22v2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

public class ReadTråd extends Thread {

    private BufferedReader inFromCounterpart;
    private boolean running;


    public ReadTråd(BufferedReader inFromCounterpart) {
        this.inFromCounterpart = inFromCounterpart;
        this.running = true;
    }

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            String message = "";
            try {
                message = inFromCounterpart.readLine();
                System.out.println(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

