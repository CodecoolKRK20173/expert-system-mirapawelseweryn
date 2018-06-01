package com.codecool.ExpertSystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ESProvider {

  private FactRepository factRepository;
  private RuleRepository ruleRepository;
  private Map<String, Boolean> answers;
  private static Scanner userInput = new Scanner(System.in);

  public ESProvider(FactParser factParser, RuleParser ruleParser) {
    this.factRepository = factParser.getFactRepository();
    this.ruleRepository = ruleParser.getRuleRepository();
  }

  public void collectAnswers() {
    Iterator<Question> iter = ruleRepository.getIterator();
    this.answers = new HashMap<>();
    while (iter.hasNext()) {
      Question q = iter.next();
      String questionId = q.getId();
      System.out.println(q.getQuestion());
      String userAnswer = userInput.nextLine();
      Boolean answerExist = isInputCorrect(userAnswer, q);
      while (!answerExist) {
        if (isInputCorrect(userAnswer, q)) {
          break;
        } else System.out.println("Please write correct answer: ");
        userAnswer = userInput.nextLine();
      }
      Boolean validation = getAnswerByQuestion(userAnswer, q);
      answers.put(questionId, validation);
    }
  }

  public boolean getAnswerByQuestion(String userAnswer, Question q) {
    return q.getEvaluatedAnswer(userAnswer);
  }

  private boolean isInputCorrect(String userAnswer, Question q) {
    List<Value> answerValues = q.getAnswer().getValues();
    for (int i = 0; i < answerValues.size(); i++) {
      for (int j = 0; j < answerValues.get(i).getInputPattern().size(); j++) {
        String value = answerValues.get(i).getInputPattern().get(j);
        if (userAnswer.equals(value)) {
          return true;
        }
      }
    }
    return false;
  }

  public void evaluate() {
    Iterator<Fact> factIterator = factRepository.getIterator();
    while (factIterator.hasNext()) {
      Fact currentlyCheckedFact = factIterator.next();
      // System.out.println(currentlyCheckedFact.getDescription());

      if (testMatch(currentlyCheckedFact)) {
        System.out.println("You should buy a " + currentlyCheckedFact.getDescription());
      }
    }
  }

  private boolean testMatch(Fact fact) {
    Set<String> factValueIdSet = fact.getSetId();

    for (String id : factValueIdSet) {
      if (!this.answers.get(id).equals(fact.getValueById(id))) {
        return false;
      }
    }

    return true;
  }
}
