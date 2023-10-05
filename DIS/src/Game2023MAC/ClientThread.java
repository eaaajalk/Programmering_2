package Game2023MAC;

import Game2023MAC.game.*;
import javafx.util.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.*;

public class ClientThread extends Thread {

    private Socket connectionSocket;
    private Player thisPlayer;
    private boolean running;


    public ClientThread(Socket connectionSocket, Player player) {
        this.connectionSocket = connectionSocket;
        this.thisPlayer = player;
        this.running = true;

    }
    public void run() {
        while (running) {
            try {
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                String playerData = inFromServer.readLine();
                if (playerData != null) {
                    if (playerData.startsWith("TREASURE")) {
                        System.out.println("Klient modtager treasure!");
                        String jsonPayload = playerData.replaceFirst("TREASURE ", "");
                        JSONObject treasureObject = new JSONObject(jsonPayload);
                        int xpos = treasureObject.getInt("xpos");
                        int ypos = treasureObject.getInt("ypos");
                        int id = treasureObject.getInt("id");
                        Treasure treasure = new Treasure(new pair(xpos, ypos));
                        treasure.setId(id);
                        GameLogic.treasures.add(treasure);
                        Gui.updateTreasureOnScreen();
                    } else {
                        System.out.println("ClientThread modtager data fra server her:");
                        System.out.println(playerData);
                        // Dekode JSON-dataen
                        JSONObject jsonPlayers = new JSONObject(playerData);
                        JSONArray playerArray = jsonPlayers.getJSONArray("players");
                        // Opret en liste til at holde spillerobjekterne
                        List<Player> receivedPlayers = new ArrayList<>();
                        // Gennemløb JSON-arrayen og opret spillerobjekter
                        for (int i = 0; i < playerArray.length(); i++) {
                            JSONObject playerJson = playerArray.getJSONObject(i);
                            String playerName = playerJson.getString("name");
                            int xpos = playerJson.getInt("xpos");
                            int ypos = playerJson.getInt("ypos");
                            String direction = playerJson.getString("direction");
                            int score = playerJson.getInt("score");
                            // Opret en ny spiller og tilføj den til listen
                            pair p = new pair(xpos, ypos);
                            Player player = new Player(playerName, p, direction);
                            player.setPoint(score);
                            if (playerName.equals(thisPlayer.getName())) {
                                thisPlayer = player;
                                receivedPlayers.add(player);
                            } else {
                                receivedPlayers.add(player);
                            }
                        }
                        GameLogic.me = thisPlayer;
                        GameLogic.players = receivedPlayers;


                    }


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void stopThread() {
        running = false;
    }
}
