package Game2023MAC;

import Game2023MAC.game.GameLogic;
import Game2023MAC.game.Player;
import Game2023MAC.game.pair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private static Socket socket;
    private static BufferedReader inFromServer;
    private static DataOutputStream outToServer;
    private ClientThread clientThread;

    public Client() throws IOException {
        socket = new Socket("localhost", 7070);
        inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outToServer = new DataOutputStream(socket.getOutputStream());
    }

    public void requestPlayerCreation(String playerName) {
        try {
            outToServer.writeBytes("NEWPLAYER " + playerName + '\n');
            String serverResponse = inFromServer.readLine();

            if (serverResponse != null) {
                if (serverResponse.startsWith("full")) {
                    System.out.println("Games is full");
                    socket.close();
                } else {
                    JSONObject jo = new JSONObject(serverResponse);
                    String name = jo.getString("name");
                    String direction = jo.getString("direction");
                    int score = jo.getInt("score");
                    int ypos = jo.getInt("ypos");
                    int xpos = jo.getInt("xpos");
                    pair p = new pair(xpos, ypos);
                    Player thisPlayer = new Player(name, p, direction);
                    GameLogic.makePlayers(thisPlayer);
                    clientThread = new ClientThread(socket, thisPlayer);
                    clientThread.start();
                    System.out.println(name + " joined the game!");
                }
            } else {
                System.err.println("Ingen server respons");
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    public void sendPlayerData(Player player) {

        System.out.println("SendPlayerData bliver kaldt med data:");
        try {
            JSONObject jsonPlayer = new JSONObject();
            jsonPlayer.put("name", player.getName());
            jsonPlayer.put("direction", player.getDirection());
            jsonPlayer.put("score", player.getPoint());
            jsonPlayer.put("ypos", player.getYpos());
            jsonPlayer.put("xpos", player.getXpos());
            outToServer.writeBytes(jsonPlayer.toString() + '\n');

            System.out.println(jsonPlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitGame(String playerName) throws IOException {
        clientThread.stopThread();
        clientThread.interrupt();
        outToServer.writeBytes("EXIT "  + playerName +  '\n');
        socket.close();
    }

}
