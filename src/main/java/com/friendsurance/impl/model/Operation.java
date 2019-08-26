package com.friendsurance.impl.model;

/**
 * @author M.Yeganeh
 **/
public enum Operation {

    GT(">"),
    EQ("="),
    LT("<");

    public String value;

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Operation convert(String op){
        for (Operation operation: Operation.values()){
            if (operation.getValue().equals(op))
                return operation;
        }

        return Operation.EQ;
    }
}
