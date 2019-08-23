package com.friendsurance.impl.executer;


import com.friendsurance.impl.model.InProcessMail;
import com.friendsurance.processing.ItemWriter;

import java.util.concurrent.BlockingQueue;

public class QueueItemWriter implements ItemWriter<InProcessMail> {

    private BlockingQueue<InProcessMail> queuedMessages;

    public QueueItemWriter(BlockingQueue<InProcessMail> waitingMessages) {
        this.queuedMessages = waitingMessages;
    }

    public void write(InProcessMail item) {
        try {
            queuedMessages.put(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
