package test;

import java.io.*;
import java.net.*;

public class testClient {

    public static void main (String[] args) throws IOException {
        Socket socket = new Socket("localhost", 777);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        printWriter.print("This is client testing");

        printWriter.flush();
    }
}
