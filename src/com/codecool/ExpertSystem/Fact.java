//package com.codecool.ExpertSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact{

    private final String ID;
    private final String DESCRIPTION;
    private Map<String, Boolean> valueId;

    
    Fact(String id, String description){
        this.ID = id;
        this.DESCRIPTION = description;
        this.valueId = new HashMap<>();
    }

    protected Set<String> getSetId(){
        return this.valueId.keySet();
    }

    protected void setFactValueById(String id, boolean valueId){
        this.valueId.put(id, value);
    }

    protected String getDescription(){
        return this.DESCRIPTION;
    }

    @Override
    public String toString(){
        return String.format("%s %s", ID, DESCRIPTION);
    
    }

    Map<String, Boolean> getValueID(){
        return valueId;
    }

}