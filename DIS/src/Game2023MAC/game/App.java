package Game2023MAC.game;

import java.lang.ref.Cleaner;
import java.net.*;
import java.io.*;

import Game2023MAC.Client;
import javafx.application.Application;

public class App {
	static String playerName;
	static Client gameClient;
	public static void main(String[] args) throws Exception{
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Indtast spillernavn");
		playerName = inFromUser.readLine();
		gameClient = new Client();
		gameClient.requestPlayerCreation(playerName);
		Application.launch(Gui.class);
	}

	public static Client getGameClient() {
		return gameClient;
	}
}
