package webserver.Serverskeleton;
import java.net.*;
public class Server {
	
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		common c = new common("eksempel");
		ServerSocket welcomeSocket = new ServerSocket(6474);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			(new ServerThread(connectionSocket,c)).start();
		}
	}
}
