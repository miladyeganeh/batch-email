package com.friendsurance.impl.model;

import com.friendsurance.mail.EmailRecipient;

/**
 * @author M.Yeganeh
 * This class keeps email data for sending
 **/
public class Mail {

    private EmailRecipient emailRecipient;
    private int emailType;

    public Mail(EmailRecipient emailRecipient, int emailType) {
        this.emailRecipient = emailRecipient;
        this.emailType = emailType;
    }

    public Mail() {
    }

    public EmailRecipient getEmailRecipient() {
        return emailRecipient;
    }

    public int getEmailType() {
        return emailType;
    }
}
