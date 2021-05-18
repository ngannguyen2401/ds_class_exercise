package sample;

import java.io.*;
import java.net.Socket;

public class ServerThread {
    ImplementServer instance = null;
    Socket player = null;

    public ServerThread(ImplementServer instance, Socket player) {
    }

    public void run() {
        try {
            DataOutputStream output = new DataOutputStream(player.getOutputStream());
            DataInputStream input = new DataInputStream(player.getInputStream());

            output.writeUTF("Username: ");
            String username = input.readUTF();

            output.writeUTF("Password: ");
            String password = input.readUTF();

            if(!instance.auth(username, password)){
                output.writeUTF("Account does not exist, please try again");
                player.close();
            }

            String status = instance.getPlayerToken();
            System.out.println(status);

            String msg = instance.displayBoard();

            boolean canMove = true;

            while(instance.isWin() == null) {
                msg = !canMove ? "Wait for your opponent\n": "";
                msg += instance.displayBoard() + "Player" + status + " can move now: \n";
                output.writeUTF(msg);

                canMove = true;
                String in = input.readUTF();

                int x = Integer.valueOf(in.split(" ")[0]);
                int y = Integer.valueOf(in.split(" ")[0]);

                if (!instance.selectMove(x, y, status))
                    canMove = false;
            }
            if (instance.isWin().equals("Draw"))
                output.writeUTF("Draw!");
            else
                output.writeUTF("Player" + instance.isWin() + " win");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
