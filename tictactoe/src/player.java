import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class player {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            Registry registry = LocateRegistry.getRegistry("local host", 999);
            service stub = (service) registry.lookup("service");

            String username;
            String password;
            System.out.println("----- Login Page -----");
            System.out.println("Username: ");
            username = scanner.nextLine();
            System.out.println("Password: ");
            password = scanner.nextLine();


            String status = stub.getPlayerToken();
            System.out.println("Player's status: ");
            System.out.println(status);

            while (stub.checkWin() == null) {
                System.out.println("It's Player" + status + "turn now!");
                System.out.println("Player" + status + "please choose: ");
                System.out.println(" -- X coordinate: ");
                int x = scanner.nextInt();
                System.out.println(" -- Y coordinate: ");
                int y = scanner.nextInt();

                if (!stub.setMove(x, y, status)) {
                    System.out.println("Please wait for your opponent to move!");
                }

                System.out.println(stub.displayBoard());

            }

            if (stub.checkWin().equals("draws"))
                System.out.println("It's a draw");
            else
                System.out.println("Player" + stub.checkWin() + " won the match");

        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }

    }

