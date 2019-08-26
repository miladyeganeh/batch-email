package com.friendsurance.impl.mailservice;

import com.friendsurance.impl.exceptions.JobExecutionException;
import com.friendsurance.impl.executer.Job;
import com.friendsurance.impl.model.Mail;
import com.friendsurance.mail.EmailRecipient;
import com.friendsurance.mail.EmailService;

import java.util.concurrent.BlockingQueue;

/**
 * @author M.Yeganeh
 * Consume data that will be produce
 */
public class QueueMailService implements EmailService, Runnable {

    BlockingQueue<Mail> messages;

    public QueueMailService(BlockingQueue<Mail> messages) {
        this.messages = messages;
    }

    public void sendMail(EmailRecipient recipient, MailType mailType) {
        System.out.println("Send email to: " + recipient.getEmail() + " : Type: " + mailType);
    }

    public void run() {

        Job job = new Job(messages);
        try {
            job.execute();
        } catch (JobExecutionException e) {
            e.printStackTrace();
        }

        while (!Thread.currentThread().isInterrupted()){
            try {
                if (!messages.isEmpty())
                    processMessage(messages.take());
                else
                    break;
            } catch (InterruptedException e) {

            }
        }
    }

    public void processMessage(Mail message) throws InterruptedException {
        MailType mailType = MailType.values()[message.getEmailType()];
        sendMail(message.getEmailRecipient(), mailType);
    }
}
