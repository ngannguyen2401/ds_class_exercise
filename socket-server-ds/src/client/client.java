package client;

import java.io.*;
import java.net.*;

public class client {

    public static void main(String[] args) throws IOException{
        Socket socket = null;
        int port = 777;

        try {
            socket = new Socket(InetAddress.getLocalHost(), port);

            ObjectOutputStream outputStream =  new ObjectOutputStream(socket.getOutputStream());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
