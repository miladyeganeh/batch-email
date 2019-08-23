package com.friendsurance.impl.model;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailRecipient;

public class Member extends User implements EmailRecipient {

    public Member(String email, boolean hasContract, int friendsNumber, int sentInvitationsNumber) {
        super(email, hasContract, friendsNumber, sentInvitationsNumber);
    }

    public static Member clone(String itemString){
        String[] items = itemString.split(",");

        return new Member("",true,0,0);
    }
}
