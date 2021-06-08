package sample;

import java.io.*;
import java.net.*;
import java.util.*;

public class db2 {
    public static void main(String[] args) {
        int port = 999;
        Socket socket = null;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server: " + server);
            DataInputStream streamIn = null;
            while (socket == null) {
                socket =  server.accept();
                streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream streamOut = new DataOutputStream(socket.getOutputStream());
                String xml = streamIn.readUTF();
                ArrayList<student> studentTable1 = Doc2Object.convertXml2Document(xml);
                ArrayList<student> studentTable2 = dao.getStudent("ds");
                ArrayList<student> synStudentTable = db2.mergeTable(studentTable1, studentTable2);
                streamOut.writeUTF(Object2Doc.convertObject2Doc(synStudentTable));
                dao.insertStudent("ds", synStudentTable);
                for (student s:synStudentTable) {
                    System.out.println(s);
                }
            }
            if (socket != null)
                socket.close();
            if (streamIn != null)
                streamIn.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    public static ArrayList<student> mergeTable(ArrayList<student> studentTable1, ArrayList<student> studentTable2){
        Set<student> set = new LinkedHashSet<>(studentTable1);
        set.addAll(studentTable2);
        ArrayList<student> combineTable = new ArrayList<student>(set);
        return combineTable;
    }
}
