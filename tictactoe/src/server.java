
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class server {
    public static void main(String[] args) {

        try {
            Game game = new Game();
            service stub = (service)UnicastRemoteObject.exportObject(game, 999);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Game Service ", stub);

            System.out.println("Ready");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
    }

