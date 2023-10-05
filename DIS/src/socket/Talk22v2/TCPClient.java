package socket.Talk22v2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class TCPClient {

	public static void main(String[] args) throws Exception, IOException {

		String name;
		String inquiryMessage = "Snakke med";
		String inquiryAnswer;
		boolean ongoing = true;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 6969);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

		System.out.println("Indsæt navn og tryk enter");
		name = inFromUser.readLine();
		outToServer.writeBytes(inquiryMessage + " " + name + "?" + '\n');

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		inquiryAnswer = inFromServer.readLine();

		if (inquiryAnswer.equalsIgnoreCase("nej") || inquiryAnswer.equalsIgnoreCase("n")) {
			System.out.println("Modtager vil ikke snakke");
			clientSocket.shutdownOutput();
			clientSocket.shutdownInput();
		} else if (inquiryAnswer.equalsIgnoreCase("ja") || inquiryAnswer.equalsIgnoreCase("j")) {
			System.out.println("Modtager har godkendt anmodningen. I kan nu chatte");

			Thread out = new OutTråd(inFromUser, outToServer);
			Thread read = new ReadTråd(inFromServer);

				out.start();
				read.start();

				while (true) {

				}
//				String toCounterpartMessage;
//				String inFromCounterpartMessage;
//
//				toCounterpartMessage = inFromUser.readLine();
//				outToServer.writeBytes(toCounterpartMessage + '\n');
//				inFromCounterpartMessage = inFromServer.readLine();
//				System.out.println(inFromCounterpartMessage);


		}
		clientSocket.close();
	}


}
