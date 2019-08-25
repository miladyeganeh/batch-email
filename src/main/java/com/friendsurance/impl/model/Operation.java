package com.friendsurance.impl.model;

public enum Operation {
    GT(">"),
    EQ("="),
    LT("<");

    public String value;

    Operation(String value) {
        this.value = value;
    }
}
