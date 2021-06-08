package sample;

import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Object2Doc {

    public static String convertDoc2Xml(Document doc) {

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        String output = " ";
        try {
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            output = writer.getBuffer().toString();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static void convertObject2Doc(ArrayList<student> studentTable) throws ParserConfigurationException  {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement("students");
        doc.appendChild(root);

        for(student student : studentTable) {
            Element user = doc.createElement("student");
            Element id= doc.createElement("id");
            id.appendChild(doc.createTextNode(student.getId()+""));
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(student.getName()));
            Element age = doc.createElement("grade");
            age.appendChild(doc.createTextNode(student.getGrade()+""));
            user.appendChild(id);
            user.appendChild(name);
            user.appendChild(age);
            root.appendChild(user);
        }

    }
}
