package com.friendsurance.impl.mailservice;

import com.friendsurance.impl.model.InProcessMail;
import com.friendsurance.mail.EmailRecipient;
import com.friendsurance.mail.EmailService;

import java.util.concurrent.BlockingQueue;

/**
 * @author M.Yeganeh
 */
//Consumer
public class QueueMailService implements EmailService, Runnable {

    BlockingQueue<InProcessMail> messages;

    public QueueMailService(BlockingQueue<InProcessMail> messages) {
        this.messages = messages;
    }

    public void sendMail(EmailRecipient recipient, MailType mailType) {
        System.out.println("Send email to: " + recipient.getEmail() + " : Type: " + mailType);
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                processMessage(messages.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void processMessage(InProcessMail message){
        MailType mailType = MailType.values()[message.getEmailType()];
        sendMail(message.getEmailRecipient(), mailType);
    }
}
