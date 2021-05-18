package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args){

         try {
             ServerSocket socket = new ServerSocket(999);
             ImplementServer instance = new ImplementServer();

             while(true) {
                 Socket player = socket.accept();

                 Thread thread = new Thread(String.valueOf(new ServerThread(instance, player)));
                 thread.start();
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
