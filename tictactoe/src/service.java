
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface service extends Remote {
    public boolean setMove(int x, int y, String player) throws RemoteException, IOException;
    public String checkWin() throws RemoteException;
    public String getPlayerToken() throws RemoteException;
    public String displayBoard() throws RemoteException;


}