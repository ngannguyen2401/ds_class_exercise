package sample;

import java.io.*;
import java.net.Socket;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class client {
    public static String convertObject2XML(client c) {
        String xmlStr = null;
        try {
            DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dBuilderFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element root = doc.createElement("customers");
            Element client = doc.createElement("customer");
            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(String.valueOf(c.getID())));
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(c.getName()));
            client.appendChild(name);
            Element age = doc.createElement("age");
            age.appendChild(doc.createTextNode(String.valueOf(c.getAge())));
            client.appendChild(age);
            root.appendChild(client);
            doc.appendChild(root);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            xmlStr = writer.getBuffer().toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return xmlStr;
    }

    public static void main(String[] args) {
        String host = "localhost";
        int port = 999;

        try {
            Socket server = new Socket(host, port);
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            client customer1 = new client(42358, "Barry", 20);

            out.writeUTF(convertObject2XML(client1));
            // close
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
