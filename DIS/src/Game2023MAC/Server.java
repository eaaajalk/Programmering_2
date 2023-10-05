package Game2023MAC;

import Game2023MAC.game.Player;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ArrayList<Player> players = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(7070);
        Server server = new Server();
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            ServerThreads serverThread = new ServerThreads(connectionSocket);
            serverThread.start();
        }
    }
}
