package com.friendsurance.impl.executer;


import com.friendsurance.impl.model.InProcessMail;

import java.util.concurrent.BlockingQueue;

/**
 * @author M.Yeganeh
 */
//Producer
public class Job  {
    private BlockingQueue<InProcessMail> messages;

    public Job(BlockingQueue<InProcessMail> messages) {
        this.messages = messages;
    }

    public void execute(){

    }
}

