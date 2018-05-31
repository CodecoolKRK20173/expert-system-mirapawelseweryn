package com.codecool.ExpertSystem;

import java.util.*;

class RuleRepository {
  private List<Question> questions;
  private Iterator<Question> questionIterator;

  public RuleRepository() {
    this.questions = new ArrayList<Question>();
    this.questionIterator = new QuestionIterator((ArrayList<Question>) questions);
  }

  public void addQuestion(Question question) {
    this.questions.add(question);
  }

  public Iterator<Question> getIterator() {
    return this.questionIterator;
  }
}
