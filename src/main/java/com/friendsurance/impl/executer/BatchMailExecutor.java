package com.friendsurance.impl.executer;

import com.friendsurance.impl.exceptions.JobExecutionException;
import com.friendsurance.impl.mailservice.QueueMailService;
import com.friendsurance.impl.model.InProcessMail;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//TODO Documentation
public class BatchMailExecutor {

    public static void main(String[] args) {

        BlockingQueue<InProcessMail> messages = new LinkedBlockingQueue<InProcessMail>();

        QueueMailService mailService = new QueueMailService(messages);

        Thread mailServiceThread = new Thread(mailService);
        mailServiceThread.start();

        Job job = new Job(messages);

        try {
            job.execute();
        } catch (JobExecutionException e) {
            System.exit(-1);
        }

        try {
            mailServiceThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
