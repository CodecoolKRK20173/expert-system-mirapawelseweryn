package com.codecool.ExpertSystem;

public class Main {
  public static void main(String[] args) {
    FactParser FACT_PARSER = new FactParser("src/com/codecool/ExpertSystem/Fact.xml");
    RuleParser RULE_PARSER = new RuleParser("src/com/codecool/ExpertSystem/Rules.xml");
    ESProvider esProvider = new ESProvider(FACT_PARSER, RULE_PARSER);
    //  esProvider.startApp();
  }
}
