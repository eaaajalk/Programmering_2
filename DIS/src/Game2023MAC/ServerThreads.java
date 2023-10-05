package Game2023MAC;

import Game2023MAC.game.GameLogic;
import Game2023MAC.game.Player;
import Game2023MAC.game.Treasure;
import Game2023MAC.game.pair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class ServerThreads extends Thread {
    Socket connectionSocket;
    List<Treasure> treasures;
    BufferedReader inFromClient;
    DataOutputStream outToClient;
    private final Timer timer;
    private final Random random;


    public ServerThreads(Socket connectionSocket) throws IOException {
        this.connectionSocket = connectionSocket;
        this.treasures = GameLogic.treasures;
        inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        timer = new Timer();
        random = new Random();
    }
    public void run() {

        while (true) {
            try {
                String playerData = inFromClient.readLine();
                if (playerData != null) {
                    if (playerData.startsWith("NEWPLAYER ")) {
                        System.out.println("Received data from client: " + playerData);
                        if (GameLogic.players.size() < 10) {
                            String playerName = playerData.substring(9);
                            pair p = GameLogic.getRandomFreePosition();
                            Player newPlayer = new Player(playerName, p, "up");
                            GameLogic.players.add(newPlayer);
                            JSONObject jsonPlayer = new JSONObject();
                            jsonPlayer.put("name", newPlayer.getName());
                            jsonPlayer.put("direction", "up");
                            jsonPlayer.put("score", newPlayer.getPoint());
                            jsonPlayer.put("ypos", newPlayer.getYpos());
                            jsonPlayer.put("xpos", newPlayer.getXpos());
                            outToClient.writeBytes(jsonPlayer.toString() + '\n');
                        } else {
                            outToClient.writeBytes("full" + '\n');
                        }
                    } else if (playerData.startsWith("EXIT")) {
                        String playerName = playerData.substring(4);
                        for (Player player : GameLogic.players) {
                            if (player.getName().equals(playerName)) {
                                GameLogic.players.remove(player);
                            }
                        }
                    } else {
                        // Opdaterer spillers data:
                        System.out.println("ServerThread modtager PlayerData her!");
                        JSONObject jo = new JSONObject(playerData);
                        String name = jo.getString("name");
                        String direction = jo.getString("direction");
                        int score = jo.getInt("score");
                        int ypos = jo.getInt("ypos");
                        int xpos = jo.getInt("xpos");
                        pair p = new pair(xpos, ypos);
                        for (Player player : GameLogic.players) {
                            if (player.getName().equals(name)) {
                                player.setDirection(direction);
                                player.setPoint(score);
                                player.setLocation(p);
                            }
                            sendDataToPlayers();
                        }
                    }
                }

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        generateTreasures();
                    }
                }, 30000); // Første køring efter 30 sek

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void sendDataToPlayers() throws IOException {
        // Opret JSON-pakke af playersList
        JSONObject jsonPlayers = new JSONObject();
        JSONArray playerArray = new JSONArray();
        for (Player p : GameLogic.players) {
            JSONObject playerObj = new JSONObject();
            playerObj.put("name", p.getName());
            playerObj.put("xpos", p.getXpos());
            playerObj.put("ypos", p.getYpos());
            playerObj.put("direction", p.getDirection());
            playerObj.put("score", p.getPoint());
            playerArray.put(playerObj);
        }

        jsonPlayers.put("players", playerArray);
        // Send JSON-dataen til klienten
        try {
            outToClient.writeBytes(jsonPlayers.toString() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateTreasures() {
                Treasure treasure = new Treasure(GameLogic.getRandomFreePosition());
                treasure.createID();
                treasures.add(treasure);
                JSONObject treasureObject = new JSONObject();
                treasureObject.put("xpos", treasure.getLocation().getX());
                treasureObject.put("ypos", treasure.getLocation().getY());
                treasureObject.put("id", treasure.getId());
                try {
                    outToClient.writeBytes("TREASURE " + treasureObject.toString() + '\n');
                    System.out.println("Treasure sent from server!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                int randomInterval = random.nextInt(21) + 20; // 20-40 sekunder
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        generateTreasures(); //
                    }
                }, randomInterval * 1000); // Konverter sekunder til millisekunder
            }




}





