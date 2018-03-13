/*
 * Client.java
 *
 * Antonio Singh
 * 
 * May 9,2017
 *
 * This program along with the Server allow for a connection through sockets that functions like a chat.
 *
 */


/*** Simulated Socket operation in client side  ***/

import java.net.*;
import java.io.*;


class Client{

	
	public static void main (String[] args) throws UnknownHostException, IOException{
	    
		String serverAddress = args[0];   //For input IP address of server side when compile Client.class
		System.out.println(serverAddress);
		System.out.println("Print Username:");

		try {
		Socket socket = new Socket (serverAddress,31);
		PrintWriter clientOutput = new PrintWriter(socket.getOutputStream(),true); 
		BufferedReader clientInput = new BufferedReader (new InputStreamReader(System.in));
		BufferedReader serverInput = new BufferedReader (new InputStreamReader(socket.getInputStream()));

		while (true) {
			
			String readerInput = clientInput.readLine();
			clientOutput.println(readerInput);
		
			if (readerInput.equals ("Exit"))

			break;


		}

		} catch (UnknownHostException u) {

		System.err.println("Unknown Host Exception Now Exiting");
		System.exit(1);

		}

		catch (IOException e) {

		System.err.println("IO Exception Error Now Exiting");
		System.exit(1);

		}
	}
}		

