package com.friendsurance.impl.model;

import com.friendsurance.mail.EmailRecipient;

public class InProcessMail {
    private EmailRecipient emailRecipient;
    private int emailType;

    public InProcessMail(EmailRecipient emailRecipient, int emailType) {
        this.emailRecipient = emailRecipient;
        this.emailType = emailType;
    }

    public EmailRecipient getEmailRecipient() {
        return emailRecipient;
    }

    public int getEmailType() {
        return emailType;
    }
}
