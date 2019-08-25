package com.friendsurance.impl.ruls;

import com.friendsurance.impl.model.Operation;
import com.friendsurance.impl.model.ValueWithOperation;

public class RuleParser implements Parser{

    private final static String RULE_SPLITTER_CHAR = " ";
    @Override
    public Rule parse(String ruleLine) {

        String[] ruleArray = ruleLine.split(RULE_SPLITTER_CHAR);

        if (ruleLine != null){
            Boolean hasContract = ruleArray[0].trim().equalsIgnoreCase("1");
            ValueWithOperation friendsCondition = getCondition(ruleArray[1], ruleArray[2]);
            ValueWithOperation invitationsCondition = getCondition(ruleArray[3], ruleArray[4]);
            Integer applyResult = Integer.parseInt(ruleArray[4]);

            return new Rule(applyResult, hasContract, friendsCondition, invitationsCondition);
        }

        return null;
    }

    private ValueWithOperation getCondition(String op, String value) {

        ValueWithOperation valueWithOperation = new ValueWithOperation();
        valueWithOperation.setOperation(Operation.valueOf(op));
        valueWithOperation.setValue(Integer.parseInt(value));

        return valueWithOperation;
    }
}
