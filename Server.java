/*
 * Server.java
 *
 * Antonio Singh
 * 
 * May 9,2017
 *
 * This program along with the Server allow for a connection through sockets that functions like a chat.
 *
 */

/*** Simulated Socket operation in server side  ***/

import java.net.*;
import java.io.*;

public class Server{
	
	public static int port = 31;
	
	public static void main (String[] args) throws IOException {
		
		new Server().runServer();	
		
	}
	
	public void runServer() throws IOException{
		ServerSocket serverSocket = new ServerSocket (port);
		System.out.println("Server is running");
		
		while (true) {
		Socket socket = serverSocket.accept();
		new ServerThread(socket).start();
		}
		
	}

	public class ServerThread extends Thread {
		
		Socket socket;
		ServerThread(Socket socket){
			this.socket = socket;
		}
		
		public void run () {
		  
	    try {
	    //To declare Socket variable in server side
		
		 String message = null;
		 BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		 PrintWriter output = new PrintWriter(socket.getOutputStream(),true); //To output strings		  
			 
		 System.out.println("User " + bufferedReader.readLine() + " is now connected to the server");	 
			 
			 while ((message = bufferedReader.readLine()) != null){
				 
			 System.out.println("Message From Client: " + message);		
	
			 }

		socket.close();
	    }
		   catch(IOException e){
			 System.err.println(e);
		   }
	    }
	}



}

    




