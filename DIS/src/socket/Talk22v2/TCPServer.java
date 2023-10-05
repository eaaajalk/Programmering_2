package socket.Talk22v2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {


		ServerSocket welcomeSocket = new ServerSocket(6969);
		String callInquiry;
		String inquiryAnswer;
		boolean ongoing = true;

		while (ongoing) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			// Printer forespørgelse fra modpart
			callInquiry = inFromClient.readLine();
			System.out.println(callInquiry);
			// Læser svar fra bruger
			inquiryAnswer = inFromUser.readLine();

			if (inquiryAnswer.equalsIgnoreCase("nej") || inquiryAnswer.equalsIgnoreCase("n")) {
				outToClient.writeBytes("n" + '\n');
				connectionSocket.shutdownInput();
				connectionSocket.shutdownOutput();
				connectionSocket.close();
			} else if (inquiryAnswer.equalsIgnoreCase("ja") || inquiryAnswer.equalsIgnoreCase("j")) {
				outToClient.writeBytes("j" + '\n');

				Thread read = new ReadTråd(inFromClient);
				Thread out = new OutTråd(inFromUser, outToClient);
				read.start();
				out.start();
				while (ongoing) {

//					String inFromClientMessage = inFromClient.readLine();
//					String toClientMessage;
//						System.out.println(inFromClientMessage);
//						toClientMessage = inFromUser.readLine();
//						outToClient.writeBytes(toClientMessage + '\n');
				}
			}
			connectionSocket.close();
		}
	}
}
