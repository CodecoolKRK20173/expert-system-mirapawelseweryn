// package com.codecool.ExpertSystem.Iterators;

import java.util.Iterator;
import java.util.List;

public class FactIterator implements Iterator<Fact> {

  protected List<Fact> facts;
  protected int indexPos;

  public FactIterator(List<Fact> facts) {
    this.facts = facts;
    this.indexPos = 0;
  }

  @Override
  public boolean hasNext() {
    if (this.facts.size() != indexPos) return true;
    this.indexPos = 0;
    return false;
  }

  @Override
  public Fact next() {
    return facts.get(this.indexPos++);
  }
}
