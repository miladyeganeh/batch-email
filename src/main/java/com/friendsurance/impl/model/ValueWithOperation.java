package com.friendsurance.impl.model;

public class ValueWithOperation {

    private Integer value;
    private Operation operation;

    public boolean isMatchedOperation(long num) {
        switch (this.operation) {
            case EQ:
                return num == value;
            case GT:
                return num > value;
            case LT:
                return num < value;
            default:
                return false;
        }
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
