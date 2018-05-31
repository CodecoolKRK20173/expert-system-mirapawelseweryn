package com.codecool.ExpertSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {
  private List<Value> values = new ArrayList<>();

  public boolean evaluateAnswerByInput(String input) {
    List<String> valuesStr = new ArrayList<>();
    valuesStr = Arrays.asList(input.split(","));

    for (Value value : values) {
      for (String str : valuesStr) {
        if (value.getInputPattern().contains(str)) {
          return value.getSelectionType();
        }
      }
    }
    return false;
  }

  public void addValue(Value value) {
    values.add(value);
  }
}
