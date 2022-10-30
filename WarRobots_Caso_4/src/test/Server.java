package test;

import communication.SocketServer;

public class Server {
	public static void main(String[] args) {
		SocketServer server = new SocketServer();
		server.startListening();
	}
}
