package socket.SocketEks2023;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket welcomSocket = new ServerSocket(8787);
		ArrayList<Person> list = new ArrayList<>();

		while(true){
			Socket connectionSocket = welcomSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			ModtagPersoner(list, inFromClient);

			System.out.println(list);
			for (Person person : list) {
				System.out.println(person.getNavn());
			}
		}
	}

	/// nedenstående skal i en tråd

	public static void ModtagPersoner(ArrayList<Person> plist, BufferedReader instream) throws IOException {
		String pakke = instream.readLine();
		// debugging
		System.out.println(pakke);

		String[] personer = pakke.split("&");
		for (int i = 0; i < personer.length - 1; i++) {
			String[] attributter = personer[i].split("#");
			for (int j = 0; j < attributter.length; j++) {
				Person p = new Person(Integer.parseInt(attributter[0]), attributter[1], attributter[2]);
				plist.add(p);
			}
		}
	}
}
