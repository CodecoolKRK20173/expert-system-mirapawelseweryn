package com.codecool.ExpertSystem;

import java.util.List;

public class MultiValue extends Value {

  private List<String> list;
  private boolean selectionType;

  MultiValue(List<String> list, boolean selectionType) {
    this.list = list;
    this.selectionType = selectionType;
  }

  public List<String> getInputPattern() {
    return list;
  }

  public boolean getSelectionType() {
    return selectionType;
  }
}
