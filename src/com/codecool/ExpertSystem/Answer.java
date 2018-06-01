package com.codecool.ExpertSystem;

import java.util.ArrayList;
import java.util.List;

public class Answer {
  private List<Value> values = new ArrayList<>();

  public boolean evaluateAnswerByInput(String input) {

    for (Value value : values) {
      if (value.getInputPattern().contains(input)) {
        return value.getSelectionType();
      }
    }
    return false;
  }

  public void addValue(Value value) {
    values.add(value);
  }

  public List<Value> getValues() {
    return values;
  }
}
