package sample;

import java.io.IOException;
import java.rmi.*;

public interface Service extends Remote {
    public boolean selectMove(int x, int y, String player) throws RemoteException, IOException;

    public String isWin() throws RemoteException;

    public String getPlayerToken() throws RemoteException;

    public String displayBoard() throws RemoteException;
}
