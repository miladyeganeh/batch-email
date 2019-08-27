package com.friendsurance.impl.rules;

/**
* This is for pars rule files
* @author M.Yeganeh
**/
public interface Parser {

    Rule parse(String ruleLine) throws Exception;
}
