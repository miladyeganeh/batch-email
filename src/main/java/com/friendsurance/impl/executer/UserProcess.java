package com.friendsurance.impl.executer;

import com.friendsurance.impl.model.InProcessMail;
import com.friendsurance.impl.model.Member;
import com.friendsurance.impl.ruls.Parser;
import com.friendsurance.impl.ruls.Rule;
import com.friendsurance.impl.ruls.RuleEngine;
import com.friendsurance.processing.ItemProcessing;
import com.friendsurance.processing.ItemReader;
import com.friendsurance.processing.ItemWriter;

import java.io.Reader;
import java.util.Set;
import java.util.SortedSet;

public class UserProcess extends ItemProcessing<Member, InProcessMail> {

    private RuleEngine ruleEngine;
    private Reader rulesReader;

    public UserProcess(ItemReader<Member> reader, ItemWriter<InProcessMail> writer, Reader rulesReader) {
        super(reader, writer);
        this.rulesReader = rulesReader;
    }

    public void setRuleEngine(Parser parser){
        this.ruleEngine = new RuleEngine(parser, rulesReader);
        ruleEngine.initial();
    }

    protected InProcessMail process(Member item) {

        if (item == null)
            return null;

        SortedSet<Rule> applicableUserRules = (SortedSet<Rule>)ruleEngine.getApplicableRules(item);
        if (applicableUserRules.isEmpty())
            return null;

        return new InProcessMail(item, applicableUserRules.first().getApplyResult());
    }
}
