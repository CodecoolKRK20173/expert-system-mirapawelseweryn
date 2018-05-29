import java.io.*;

class RuleParser extends XMLParser {
    private RuleRepository ruleRepository;
    
    public XMLParser(String fileName){
        RuleRepository ruleRepository = new RuleRepository();
        super.loadXMLDocument(fileName);
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }
}