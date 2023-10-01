import java.io.*;
import java.net.*;

class TSServer {

	public static void main(String argv[]) throws Exception {
		String clientSentence;

		ServerSocket welcomeSocket = new ServerSocket(15614);

		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new
					InputStreamReader(connectionSocket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream
					(connectionSocket.getOutputStream());

			clientSentence = inFromClient.readLine();
			//time of receipt of the client's message
			long t2 = System.currentTimeMillis();

			//time of sending the response
			long t3 = System.currentTimeMillis();

			outToClient.writeBytes(t2 + ";" + t3 + ";\n");

		}
	}
}