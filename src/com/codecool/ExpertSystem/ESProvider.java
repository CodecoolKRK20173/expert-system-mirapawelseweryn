package com.codecool.ExpertSystem;

import java.util.Map;

public class ESProvider {

  private FactRepository factRepository;
  private RuleRepository ruleRepository;
  private Map<String, Boolean> answers;

  public ESProvider(FactParser factParser, RuleParser ruleParser) {
    this.factRepository = factParser.getFactRepository();
    this.ruleRepository = ruleParser.getRuleRepository();
  }

  // public void collectAnswers() {}
  //
  // public boolean getAnswerByQuestion(String questionId) {}
  //
  // public String evaluate() {}
}
