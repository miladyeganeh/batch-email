package com.friendsurance.impl.model;

import com.friendsurance.backend.User;
import com.friendsurance.impl.exceptions.InvalidDataFormatException;
import com.friendsurance.mail.EmailRecipient;

/**
 * @author M.Yeganeh
 **/
public class Member extends User implements EmailRecipient {

    public Member(String email, boolean hasContract, int friendsNumber, int sentInvitationsNumber) {
        super(email, hasContract, friendsNumber, sentInvitationsNumber);
    }

    public static Member clone(String itemString) throws InvalidDataFormatException {
        String[] items = itemString.split(",");

        if (items.length < 4)
            throw new InvalidDataFormatException();
        String email = items[0].trim();
        String contractString = items[1].trim();
        boolean hasContract = contractString.equalsIgnoreCase("true");
        int friendsNumber = Integer.parseInt(items[2].trim());
        int sentInvitationsNumber = Integer.parseInt(items[2].trim());

        return new Member(email,hasContract,friendsNumber,sentInvitationsNumber);
    }

    public static class NullMember extends Member {

        public NullMember(String email, boolean hasContract, int friendsNumber, int sentInvitationsNumber) {
            super(email, hasContract, friendsNumber, sentInvitationsNumber);
        }
    }
}
