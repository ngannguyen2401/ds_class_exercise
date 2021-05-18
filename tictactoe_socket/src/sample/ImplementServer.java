package sample;

import java.rmi.*;
import java.sql.*;

public class ImplementServer {
    private int numOfPlayer = 0;
    private int playerNum;
    private Game game;
    private String[] status = { "X", "O"};
    Connection dbConn;

    public ImplementServer() {
        this.dbConn = connectToDB("user", "password");
        game = new Game();
    }

    public static Connection connectToDB(String user, String password){

        String dbURL = "jdbc:mysql://localhost:3308/distributed?user=" + user + "&password=" + password;
         try {
             Connection conn = DriverManager.getConnection(dbURL);
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }

        return null;
    }

    public void auth (String username, String password) {

        try {
            PreparedStatement preparedStatement = dbConn.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    public boolean selectMove(int x, int y, String player) throws RemoteException {
        return game.setMove(x, y, player);
    }


    public String isWin(){
        return game.checkVictory();
    }


    public String displayBoard() throws RemoteException {
        return game.toString();
    }


    public String getPlayerToken() throws RemoteException {
        playerNum = numOfPlayer;
        numOfPlayer++;

        return status[playerNum];
    }
}
