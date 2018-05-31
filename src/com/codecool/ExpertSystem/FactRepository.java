package com.codecool.ExpertSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {

  private List<Fact> facts;

  FactRepository() {
    this.facts = new ArrayList<>();
  }

  void addFact(Fact fact) {
    facts.add(fact);
  }

  Iterator<Fact> getIterator() {
    return new FactIterator(this.facts);
  }
}
