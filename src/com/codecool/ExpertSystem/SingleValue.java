package com.codecool.ExpertSystem;

import java.util.ArrayList;
import java.util.List;

public class SingleValue extends Value {

  private String param;
  private boolean selectionType;

  SingleValue(String param, boolean selectionType) {
    this.param = param;
    this.selectionType = selectionType;
  }

  @Override
  public List<String> getInputPattern() {
    List<String> list = new ArrayList<String>();
    list.add(param);
    return list;
  }

  @Override
  public boolean getSelectionType() {
    return selectionType;
  }
}
