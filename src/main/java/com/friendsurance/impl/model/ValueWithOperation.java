package com.friendsurance.impl.model;

/**
 * @author M.Yeganeh
 **/
public class ValueWithOperation {

    private Integer value;
    private Operation operation;

    public Boolean isMatchedOperation(long num) {
        switch (this.operation) {
            case EQ:
                return num == value;
            case GT:
                return num > value;
            case LT:
                return num < value;
            default:
                return Boolean.FALSE;
        }
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
