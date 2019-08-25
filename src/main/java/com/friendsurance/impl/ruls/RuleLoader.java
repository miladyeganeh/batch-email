package com.friendsurance.impl.ruls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RuleLoader {

    private Parser parser;

    public RuleLoader(Parser parser) {
        this.parser = parser;
    }

    public List<Rule> load(Reader reader) throws IOException {
        List<Rule> rules = new ArrayList<>();
        BufferedReader ruleBufferReader = new BufferedReader(reader);
        String ruleLine;

        while ((ruleLine = ruleBufferReader.readLine()) != null){
            if (ruleLine.trim().isEmpty()){
                continue;
            }else{
                try {
                    Rule rule = parser.parse(ruleLine);
                    rules.add(rule);
                } catch (Exception e) {
                    System.out.println("error in rule reading: " + ruleLine);
                }
            }
        }

        return rules;
    }
}
