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

                String id = eElement.getAttribute("id");
                String question = eElement.getElementsByTagName("Question").item(INDEX).getTextContent();
                Answer answer = new Answer();

                Element answers = (Element) eElement.getElementsByTagName("Answer").item(INDEX);
                NodeList selectionValues = answers.getElementsByTagName("Selection"); 

                for (int j = 0; j < selectionValues.getLength(); j++) {
                    Element vElement = (Element) selectionValues.item(j);
                    NodeList typeOfValues = vElement.getChildNodes();

                    boolean val = Boolean.parseBoolean(vElement.getAttribute("value"));

                        for (int k = 0; k < typeOfValues.getLength(); k++) {
                            Node answerNode = typeOfValues.item(k);
                            if (answerNode.getNodeType() == Node.ELEMENT_NODE){
                                Element answerElement = (Element) answerNode;

                                if (answerElement.getTagName().equals("SingleValue")) {
                                        answer.addValue(new SingleValue(answerElement.getAttribute("value"), val));
                                    } else {
                                        answer.addValue(new MultiValue(answerElement.getAttribute("value"), val));
                                    }
                            }
                            
                        }
                               
            
                } 
            ruleRepository.addQuestion(new Question(id, question, answer));
            } 
        }
    }
    
    
}
