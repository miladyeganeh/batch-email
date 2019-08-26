package com.friendsurance.impl.executer;


import com.friendsurance.impl.model.Mail;
import com.friendsurance.processing.ItemWriter;

import java.util.concurrent.BlockingQueue;

/**
 * @author M.Yeganeh
 * Write processed data to queue
 **/

public class QueueItemWriter implements ItemWriter<Mail> {

    private BlockingQueue<Mail> queuedMessages;

    public QueueItemWriter(BlockingQueue<Mail> waitingMessages) {
        this.queuedMessages = waitingMessages;
    }

    public void write(Mail item) {
        try {
            queuedMessages.put(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
