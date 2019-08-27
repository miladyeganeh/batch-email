package com.friendsurance.impl.rules;

import com.friendsurance.backend.User;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * @author M.Yeganeh
 * For load rules and comparison
 **/
public class RuleEngine {

    private final Set<Rule> rules = new HashSet<>();
    private Parser parser;
    private Reader ruleReader;
    private RuleLoader ruleLoader;

    public RuleEngine(Parser parser, Reader reader) {
        this.parser = parser;
        this.ruleReader = reader;
        this.ruleLoader = new RuleLoader(parser);
    }

    public void initial(){
        loadRule();
    }

    public void loadRule(){
        List<Rule> loadedRules = new ArrayList<>();

        try {
            loadedRules = ruleLoader.load(ruleReader);
        } catch (IOException e) {
            System.out.println(e);
        }

        rules.addAll(loadedRules);
    }


    /**
     * This method is main method which provide matched rule for a user.
     * return {@link SortedSet} of {@link Rule}
     *
     * @param user
     * @return
     */
    public Set<Rule> getApplicableRules(User user){
        SortedSet<Rule> userRules = new TreeSet<>(new Rule.MaxPriorityRule());
        Iterator<Rule> iterator = getRules().iterator();
        while (iterator.hasNext()){
            Rule rule = iterator.next();
            if (rule.applies(user))
                userRules.add(rule);
        }

        return userRules;
    }

    public Set<Rule> getRules() {
        return rules;
    }
}
