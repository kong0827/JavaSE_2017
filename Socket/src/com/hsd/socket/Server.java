package com.hsd.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(12345);
		System.out.println("在等来");
		Socket s = ss.accept();
		System.out.println("等到了");
	}
	

}
