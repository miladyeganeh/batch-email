package com.friendsurance.impl.ruls;

import com.friendsurance.impl.model.Operation;
import com.friendsurance.impl.model.ValueWithOperation;

public class RuleParser implements Parser{

    private final static String RULE_SPLITTER_CHAR = " ";
    @Override
    public Rule parse(String ruleLine) {

        String[] ruleArray = ruleLine.split(RULE_SPLITTER_CHAR);

        if (ruleArray.length > 0){
            ValueWithOperation friendsCondition = new ValueWithOperation();
            ValueWithOperation invitationsCondition = new ValueWithOperation();
            Boolean hasContract = ruleArray[0].trim().equalsIgnoreCase("1");

            if (!ruleArray[2].isEmpty() && !ruleArray[3].isEmpty())
                friendsCondition = getCondition(ruleArray[2], ruleArray[3]);

            if (!ruleArray[5].isEmpty() && !ruleArray[6].isEmpty())
                invitationsCondition = getCondition(ruleArray[5], ruleArray[6]);

            Integer applyResult = Integer.parseInt(ruleArray[8]);

            return new Rule(applyResult, hasContract, friendsCondition, invitationsCondition);
        }

        return null;
    }

    private ValueWithOperation getCondition(String op, String value) {

        ValueWithOperation valueWithOperation = new ValueWithOperation();
        valueWithOperation.setOperation(Operation.convert(op));
        valueWithOperation.setValue(Integer.parseInt(value));

        return valueWithOperation;
    }
}
