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
    private Answer generateAnswer(Element eElement) {
        Element answers = eElement.getElementsByTagName("Answer").item(INDEX);
        NodeList selectionValues = answers.getElementsByTagName("Selection");
        Answer answer = new Answer(); 

        for (int j = 0; j < selectionValues.getLength(); j++) {
            Node value = selectionValues.item(j);

            if (value.getNodeType() == Node.ELEMENT_NODE) {
                Element vElement = (Element) value;
                NodeList typeOfValues = value.getChildNodes();

                boolean val = Boolean.parseBoolean(vElement.getAttribute("value")));

                for (int k = 0; k < typeOfValues.getLength(); k++) {
                    Node answerNode = typeOfValues.item(k);
                    Element answerElement = (Element) answerNode;

                    if (answerElement.getTagName().equals("SingleValue")) {
                            answer.addValue(new SingleValue(typeElement.getAttribute("value"), val);
                        } else {
                            answer.addValue(new MultipleValue(typeElement.getAttribute("value"), val);
                        }
                }
                               
            
            } else return answer;
        }   
    return answer;

}
