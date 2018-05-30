//package com.codecool.ExpertSystem;

import com.sun.org.apache.xerces.internal.parsers.XMLParser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser{
    private FactRepository factRepository;

    public FactParser(String filename){
        super(loadXMLDocument(fileName));
        FactRepository factRepository = new FactRepository();
    }


    public FactRepository getFactRepository(){
        return this.factRepository;
    }
}