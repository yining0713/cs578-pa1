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

		long t1 = 0;
		long t2 = 0;
		long t3 = 0;
		long t4 = 0;
		long theta = 0;
		long rtt = 0;
		long bestRTT = 1000000;
		long bestTheta = 0;

		for (int i=0; i < 8; i++){
			Socket clientSocket = new Socket(host, 15614);
			DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());

			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

			t1 = System.currentTimeMillis();
			request = "" + t1;

			outToServer.writeBytes(request + '\n');
			response = inFromServer.readLine();

			t2 = Long.parseLong(response.split(";")[0]);
			t3 = Long.parseLong(response.split(";")[1]);
			t4 = System.currentTimeMillis(); // local time
			theta = (t2 - t1)/2 + (t3 - t4)/2;

			rtt = t4 - t3 + t2 - t1;

			if(rtt < bestRTT) {
				bestRTT = rtt;
				bestTheta = theta;
			}
		
			clientSocket.close();
			Thread.sleep(2000);
		}
		System.out.println("REMOTE_TIME " + (t4 + bestTheta));

		System.out.println("LOCAL_TIME " + t4);

		System.out.println("RTT_ESTIMATE " + bestTheta);
	}
}