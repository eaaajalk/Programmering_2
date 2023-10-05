package webserver.Serverskeleton;
import java.net.*;
import java.io.*;
public class ServerThread extends Thread{
	Socket connSocket;
	common c;
	
	public ServerThread(Socket connSocket,common c) {
		this.connSocket = connSocket;
		this.c=c; // Til Web-server opgaven skal denne ikke anvendes
	}
	public void run() {
		try {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());


			String request = inFromClient.readLine();

			System.out.println(request);
			if (request != null) {
				String[] words = request.split("\\s");
				String w = words[1];

				String filePath = "/Users/piscatorem/Documents/Datamatiker/3 semester/sis/myWEB" + w;

				File file = new File(filePath);

				if (file.exists()) {

				outToClient.writeBytes("HTTP 200 OK"+ '\n');
				outToClient.writeBytes(ContentType(w) + '\n');
				outToClient.writeBytes("Connection: Close" + '\n' + '\n');

				byte[] fileContent = read(filePath);
				outToClient.write(fileContent);

				} else {
					System.out.println("Fil findes ikke");
				}

			}
			connSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String ContentType (String docuname) {
			//returns the Content-Type headerline for a given document-name
			if (docuname.endsWith(".html")) {
				return ("Content-Type: text/html");
			} else if (docuname.endsWith(".gif")) {
				return ("Content-Type: image/gif");
			} else if (docuname.endsWith(".png")) {
				return ("Content-Type: image/png");
			} else if (docuname.endsWith(".jpg")) {
				return ("Content-Type: image/jpg");
			} else if (docuname.endsWith(".js")) {
				return ("Content-Type: text/javascript");
			} else if (docuname.endsWith(".css")) {
				return ("Content-Type: text/css");
			} else {
				return ("Content-Type: text/plain");
			}
		}
		byte[] read (String aInputFileName) throws FileNotFoundException {
			// returns the content of a file in a binary array
			System.out.println("Reading in binary file named : " +
					aInputFileName);
			File file = new File(aInputFileName);
			System.out.println("File size: " + file.length());
			byte[] result = new byte[(int) file.length()];
			try {
				InputStream input = null;
				try {
					int totalBytesRead = 0;
					input = new BufferedInputStream(new FileInputStream(file));
					while (totalBytesRead < result.length) {
						int bytesRemaining = result.length - totalBytesRead;
						int bytesRead = input.read(result, totalBytesRead,
								bytesRemaining);
						//input.read() returns -1, 0, or more :
						if (bytesRead > 0) {
							totalBytesRead = totalBytesRead + bytesRead;
						}
					}
					System.out.println("Num bytes read: " + totalBytesRead);
				} finally {
					System.out.println("Closing input stream.");
					input.close();
				}
			} catch (FileNotFoundException ex) {
				throw ex;
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return result;
		}


	}
