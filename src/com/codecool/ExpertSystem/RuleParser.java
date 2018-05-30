import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class RuleParser extends XMLParser {
    private RuleRepository ruleRepository;
    private final int INDEX = 0;
    
    public RuleParser(String fileName){
        super.loadXMLDocument(fileName);
        RuleRepository ruleRepository = new RuleRepository();
        
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }
    public void createQuestion() {
        super.document.getDocumentElement().normalize();
        NodeList rulesList = super.document.getElementsByTagName("Rule");

        for (int i = 0; i < rulesList.getLength(); i++) {
		    Node rule = rulesList.item(i);
            if (rule.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) rule;
                this.ruleRepository.addQestion(new Question(eElement.getAttribute("id"), 
                                                            eElement.getElementsByTagName("Question").item(INDEX).getTextContent(),
                                                            generateAnswer(eElement)));
            }

        }
    }
    
}
