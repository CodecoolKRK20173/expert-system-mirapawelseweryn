// package com.codecool.ExpertSystem;

// import com.codecool.ExpertSystem.*;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class FactParser extends XMLParser {
  // FactRepository factRepository;
  FactRepository factRepository;

  public FactParser(String filename) {
    super.loadXMLDocument(filename);
    this.factRepository = new FactRepository();
  }

  public FactRepository getFactRepository() {
    return this.factRepository;
  }

  public void parseFact() {
    super.document.getDocumentElement().normalize();
    NodeList factsList = super.document.getElementsByTagName("Fact");
    for (int i = 0; i < factsList.getLength(); i++) {
      Node nNode = factsList.item(i);
      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;

        String factId = eElement.getAttribute("id");
        String factDescription =
            eElement.getChildNodes().item(1).getAttributes().item(0).getTextContent();

        Fact newFact = new Fact(id, description);
        NodeList evals = eElement.getElementsByTagName("Eval");

        for (int j = 0; j < evals.getLength(); j++) {
          Element eval = (Element) evals.item(j);
          String factEvalId = eval.getAttribute("id");
          String factEvalValue = eval.getTextContent();
          newFact.setFactValueById(factEvalId, Boolean.valueOf(factEvalValue));
        }
        factRepository.addFact(newFact);
      }
    }
  }
}
