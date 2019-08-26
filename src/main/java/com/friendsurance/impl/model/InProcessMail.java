package com.friendsurance.impl.model;

import com.friendsurance.mail.EmailRecipient;

public class InProcessMail {

    private EmailRecipient emailRecipient;
    private int emailType;

    public InProcessMail(EmailRecipient emailRecipient, int emailType) {
        this.emailRecipient = emailRecipient;
        this.emailType = emailType;
    }

    public InProcessMail() {
    }

    public EmailRecipient getEmailRecipient() {
        return emailRecipient;
    }

    public int getEmailType() {
        return emailType;
    }

    public static class PoisonPillInProcessMail extends InProcessMail {
    }
}
