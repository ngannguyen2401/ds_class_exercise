package server;

import java.io.*;
import java.net.*;
import student.student;

public class server {
    public static void main(String[] args) throws IOException {
        int port = 777;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("Connected to" + socket.getRemoteSocketAddress());

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            student student = (student)inputStream.readObject();
            System.out.println("Server received");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
