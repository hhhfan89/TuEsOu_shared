package it.vitux.tuesou;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketServerConnection {

	private static SocketServerConnection socketServerConnection = new SocketServerConnection();
	
	private static  int PORT = 1500;
	private static  String ADDRESS = "";
	
	private DataOutputStream outputStream = null;	   
	private Socket clientSocket = null;


	private SocketServerConnection() {

	}

	public static SocketServerConnection getInstance() {
		return socketServerConnection;
	}
	

	public void updateLocation(int latitude, int longitude) throws IOException {
		openSocket();
		try {  
			if (clientSocket != null && clientSocket.isConnected() && outputStream != null) {
				String coordinates = latitude + "," + longitude + "\n";
				outputStream.writeBytes(coordinates);  
				outputStream.flush(); 
			} 
		}catch (IOException e) {
			System.err.println("IOException:  " + e);
		}catch (IllegalStateException e) {
			System.err.println("Socket is not connected: "  + e);
		}
	}
	
	public void openSocket() throws IOException {
		try {
			if (clientSocket == null && outputStream == null) {
				clientSocket = new Socket(ADDRESS, PORT);
				outputStream = new DataOutputStream(clientSocket.getOutputStream());
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: " + ADDRESS);
		}
	}

	public void stopSocket() throws IOException {
		try {
			outputStream.close();
			clientSocket.close();
			clientSocket = null;
			outputStream = null;
		}
		catch (SocketException e) {
			;
		}

	}


}
