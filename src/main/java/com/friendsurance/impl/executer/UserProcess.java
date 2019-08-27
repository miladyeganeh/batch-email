package com.friendsurance.impl.executer;

import com.friendsurance.impl.model.Mail;
import com.friendsurance.impl.model.Member;
import com.friendsurance.impl.rules.Parser;
import com.friendsurance.impl.rules.Rule;
import com.friendsurance.impl.rules.RuleEngine;
import com.friendsurance.processing.ItemProcessing;
import com.friendsurance.processing.ItemReader;
import com.friendsurance.processing.ItemWriter;

import java.io.Reader;
import java.util.SortedSet;

/**
 * @author M.Yeganeh
 * Process data for sending email, get proper rules and users
 **/
public class UserProcess extends ItemProcessing<Member, Mail> {

    private RuleEngine ruleEngine;
    private Reader rulesReader;

    public UserProcess(ItemReader<Member> reader, ItemWriter<Mail> writer, Reader rulesReader) {
        super(reader, writer);
        this.rulesReader = rulesReader;
    }

    public void setRuleEngine(Parser parser){
        this.ruleEngine = new RuleEngine(parser, rulesReader);
        ruleEngine.initial();
    }

    protected Mail process(Member item) {

        if (item instanceof Member.NullMember)
            return null;

        SortedSet<Rule> applicableUserRules = (SortedSet<Rule>)ruleEngine.getApplicableRules(item);
        if (applicableUserRules.isEmpty())
            return null;

        return new Mail(item, applicableUserRules.first().getApplyResult());
    }
}
