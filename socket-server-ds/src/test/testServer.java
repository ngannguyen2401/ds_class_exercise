package test;

import java.io.*;
import java.net.*;

public class testServer{

    public static void main(String[] args) throws IOException {
        int port = 777;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();

        System.out.println("System connected to port" + port);
    }

}
