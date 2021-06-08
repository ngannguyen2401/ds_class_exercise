package sample;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
public class Doc2Object {

    static ArrayList<student> convertXml2Document(String xml) {
        ArrayList<student> studentTable = new ArrayList<student>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xml)));
            Element element = (Element) doc.getElementsByTagName("students").item(0);
            NodeList list = element.getChildNodes();
            for (int i=0; i<list.getLength(); i++) {
                String id = ((Element) list.item(i)).getElementsByTagName("id").item(0).getTextContent();
                String name = ((Element) list.item(i)).getElementsByTagName("name").item(0).getTextContent();
                String grade = ((Element) list.item(i)).getElementsByTagName("grade").item(0).getTextContent();

                studentTable.add(new student(Integer.parseInt(id), name, Float.parseFloat(grade)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentTable;
    }
}
