package sample;

import java.io.*;
import java.net.*;
import java.util.*;
public class db1 {
    public static void main(String args[]) throws IOException{
        String server = "localhost";
        int port = 999;
        Socket socket = new Socket(server, port);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream streamIn = new DataInputStream(socket.getInputStream());
        DataOutputStream  streamOut = new DataOutputStream(socket.getOutputStream());
        streamOut.writeUTF(Object2Doc.convertObject2Doc(dao.getStudent("ds")));
        while (true) {
            String xml = streamIn.readUTF();
            ArrayList<student> studentTable2 = Doc2Object.convertXml2Document(xml);
            for (student s:studentTable2) {
                System.out.println(s);
            }
            dao.insertStudent("ds", studentTable2);
            break;
        }
        console.close();
        streamOut.close();
        socket.close();
    }
}
