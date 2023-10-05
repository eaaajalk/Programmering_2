package socket.SocketEks2023;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;


public class TCPClient {


	public static void main(String[] args) throws Exception, IOException {
		// Opretter nogle personer
		Person p = new Person(1,"Jakob", "Aarhus");
		Person p1 = new Person(2,"Tine", "Odense");
		Person p2 = new Person(3,"Gitte", "Hobro");
		ArrayList<Person> plist = new ArrayList<>();
		plist.add(p);
		plist.add(p1);
		plist.add(p2);

		String sentence;
		String modifiedSentence;
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket = new Socket("localhost", 8787);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		sendPersoner(plist, outToServer);

			
	}
	public static void sendPersoner (ArrayList<Person> personerList, DataOutputStream outstream) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (Person p : personerList) {
			sb.append(p.getId()).append("#").append(p.getNavn()).append("#").append(p.getBy()).append("&");
		}
		String pakke = String.valueOf(sb) + '\n';
		System.out.println(pakke);
		outstream.writeBytes(pakke);
	}

}
