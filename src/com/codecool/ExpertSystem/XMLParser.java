import java.io.*;
import javax.xml.parsers.*;

public abstract class XMLParser {
    private Document document;

    public void loadXMLDocument(String xmlPath) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            this.document = builder.parse(new FileInputStream(xmlPath));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

}