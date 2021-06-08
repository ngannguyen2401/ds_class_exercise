package sample;

import java.io.*;
import java.net.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class server {
    public static client xml2Object(String xml) throws Exception {
        client c = null;
        System.out.println(xml);
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(new InputSource(new StringReader(xml)));
            Element rootElement = (Element) doc.getDocumentElement();
            NodeList customers = rootElement.getChildNodes();
            for (int i = 0; i < customers.getLength(); i++) {
                Element client = (Element) customers.item(i);
                c = new client(
                        Integer.parseInt(client.getElementsByTagName("id").item(0).getTextContent()),
                        client.getElementsByTagName("name").item(0).getTextContent(),
                        Integer.parseInt(client.getElementsByTagName("age").item(0).getTextContent())

                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return c;
    }
    public static void main(String[] args) {
        int port = 999;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server running on port: " + port);
            while (true) {
                Socket client = server.accept();
                DataInputStream in = new DataInputStream(client.getInputStream());
                client c = xml2Object(in.readUTF());
                System.out.println(c);
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
