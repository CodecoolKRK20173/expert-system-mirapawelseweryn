package com.codecool.ExpertSystem;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class RuleParser extends XMLParser {
  private RuleRepository ruleRepository;
  private NodeList rulesList;

  private final int INDEX = 0;

  public RuleParser(String fileName) {
    super.loadXMLDocument(fileName);
    this.ruleRepository = new RuleRepository();
    createQuestions();
  }

  public RuleRepository getRuleRepository() {
    return this.ruleRepository;
  }

  public void createQuestions() {
    super.document.getDocumentElement().normalize();
    rulesList = super.document.getElementsByTagName("Rule");
    for (int i = 0; i < rulesList.getLength(); i++) {
      Element rule = (Element) rulesList.item(i);
      Element elementQuestion = (Element) rule.getElementsByTagName("Question").item(0);
      NodeList selectionValues = rule.getElementsByTagName("Selection");
      String id = rule.getAttribute("id");
      String question = elementQuestion.getTextContent();
      Answer answer = new Answer();
      chooseValue(answer, selectionValues);
      this.ruleRepository.addQuestion(new Question(id, question, answer));
    }
  }

  private void chooseValue(Answer answer, NodeList selectionValues) {
    for (int i = 0; i < selectionValues.getLength(); i++) {
      Element selection = (Element) selectionValues.item(i);
      Boolean answerType = selection.getAttribute("value").equals("true");
      NodeList values = selection.getElementsByTagName("SingleValue");
      Value value;
      if (values.getLength() <= 0) {
        value = multiValueChoice(answerType, selection);
      } else value = singleValueChoice(answerType, values);
      answer.addValue(value);
    }
  }

  private Value multiValueChoice(Boolean answerType, Element selection) {
    Node params = selection.getElementsByTagName("MultipleValue").item(0).getAttributes().item(0);
    List<String> paramsInList = Arrays.asList(params.getNodeValue().split(","));
    MultiValue multiValue = new MultiValue(paramsInList, answerType);
    return (Value) multiValue;
  }

  private Value singleValueChoice(Boolean answerType, NodeList values) {
    String param = values.item(0).getAttributes().item(0).getNodeValue();
    SingleValue singleValue = new SingleValue(param, answerType);
    return (Value) singleValue;
  }

  // public void createQuestion() {
  //   super.document.getDocumentElement().normalize();
  //   NodeList rulesList = super.document.getElementsByTagName("Rule");
  //   for (int i = 0; i < rulesList.getLength(); i++) {
  //     System.out.println("i" + i);
  //     Node rule = rulesList.item(i);
  //     if (rule.getNodeType() == Node.ELEMENT_NODE) {
  //       Element eElement = (Element) rule;
  //       String id = eElement.getAttribute("id");
  //       String question = eElement.getElementsByTagName("Question").item(INDEX).getTextContent();
  //       Answer answer = new Answer();
  //       Element answers = (Element) eElement.getElementsByTagName("Answer").item(INDEX);
  //       NodeList selectionValues = answers.getElementsByTagName("Selection");
  //       for (int j = 0; j < selectionValues.getLength(); j++) {
  //         System.out.println("j" + j);
  //         Element vElement = (Element) selectionValues.item(j);
  //         NodeList typeOfValues = vElement.getChildNodes();
  //         boolean val = Boolean.parseBoolean(vElement.getAttribute("value"));
  //         for (int k = 0; k < typeOfValues.getLength(); k++) {
  //           System.out.println("k" + k);
  //           Node answerNode = typeOfValues.item(k);
  //           if (answerNode.getNodeType() == Node.ELEMENT_NODE) {
  //             Element answerElement = (Element) answerNode;
  //             if (answerElement.getTagName().equals("SingleValue")) {
  //               answer.addValue(new SingleValue(answerElement.getAttribute("value"), val));
  //               this.ruleRepository.addQuestion(new Question(id, question, answer));
  //             } else {
  //               answer.addValue(new MultiValue(answerElement.getAttribute("value"), val));
  //               this.ruleRepository.addQuestion(new Question(id, question, answer));
  //             }
  //           }
  //         }
  //       }
  //     }
  //   }
  // }
}
