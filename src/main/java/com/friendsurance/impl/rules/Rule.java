package com.friendsurance.impl.rules;

import com.friendsurance.backend.User;
import com.friendsurance.impl.model.ValueWithOperation;

import java.util.Comparator;

/**
 * @author M.Yeganeh
 * This keep rules for us
 **/
public class Rule {

    private Integer applyResult;
    private Boolean hasContract;
    private ValueWithOperation friendsCondition;
    private ValueWithOperation invitationsCondition;

    public Rule(Integer applyResult, Boolean hasContract, ValueWithOperation friendsCondition,
                ValueWithOperation invitationsCondition) {
        this.applyResult = applyResult;
        this.hasContract = hasContract;
        this.friendsCondition = friendsCondition;
        this.invitationsCondition = invitationsCondition;
    }

    /**
     * checking rules for the given user.
     *
     * @param user
     * @return
     */
    public Boolean applies(User user){
        Boolean isMatched = hasContract.equals(user.hasContract()) && friendsCondition.isMatchedOperation(user.getFriendsNumber());
        isMatched = isMatched && invitationsCondition.isMatchedOperation(user.getSentInvitationsNumber());

        return isMatched;
    }

    public Integer getApplyResult() {
        return applyResult;
    }

    public void setApplyResult(Integer applyResult) {
        this.applyResult = applyResult;
    }

    public ValueWithOperation getFriendsCondition() {
        return friendsCondition;
    }

    public void setFriendsCondition(ValueWithOperation friendsCondition) {
        this.friendsCondition = friendsCondition;
    }

    public ValueWithOperation getInvitationsCondition() {
        return invitationsCondition;
    }

    public void setInvitationsCondition(ValueWithOperation invitationsCondition) {
        this.invitationsCondition = invitationsCondition;
    }

    public Boolean getContract() {
        return hasContract;
    }

    public void setContract(Boolean contract) {
        hasContract = contract;
    }

    public static class MaxPriorityRule implements Comparator<Rule>{
        @Override
        public int compare(Rule o1, Rule o2) {
            return o1.getApplyResult() > o2.getApplyResult() ? -1 : o1.getApplyResult() < o2.getApplyResult() ? 1 : 0;
        }
    }
}
