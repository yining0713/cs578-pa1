import java.io.*;
import java.net.*;

class TSClient {

	public static void main(String argv[]) throws Exception {
		String host = "localhost";
		if (argv.length > 0){
            host = argv[0];
        }
		String request;
		String response;

		Socket clientSocket = new Socket(host, 15614);
		DataOutputStream outToServer = new DataOutputStream(
			clientSocket.getOutputStream());

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
			clientSocket.getInputStream()));

		long t1 = System.currentTimeMillis();
		request = "" + t1;

		outToServer.writeBytes(request + '\n');
		response = inFromServer.readLine();
		long t3;
		long t2;
		t2 = Long.parseLong(response.split(";")[0]);
		t3 = Long.parseLong(response.split(";")[1]);
		long t4 = System.currentTimeMillis(); // local time
		long theta = (t2 - t1)/2 + (t3 - t4)/2;
		System.out.println("REMOTE_TIME " + (t4 + theta));

		System.out.println("LOCAL_TIME " + t4);

		long rtt = t4 - t3 + t2 - t1;

		System.out.println("RTT_ESTIMATE " + rtt);
	
		clientSocket.close();
	}
}