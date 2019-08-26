package com.friendsurance.impl.executer;


import com.friendsurance.impl.exceptions.JobExecutionException;
import com.friendsurance.impl.model.InProcessMail;
import com.friendsurance.impl.model.Member;
import com.friendsurance.impl.ruls.RuleParser;
import com.friendsurance.processing.ItemReader;
import com.friendsurance.processing.ItemWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;

/**
 * @author M.Yeganeh
 */
//Producer
public class Job  {

    private BlockingQueue<InProcessMail> messages;
    private String usersInfoData = BatchMailExecutor.class.getClassLoader().getResource("src/main/resources/userInfoData.data").getPath();
    private String rulesPath = BatchMailExecutor.class.getClassLoader().getResource("src/main/resources/rules.r").getPath();

    public Job(BlockingQueue<InProcessMail> messages) {
        this.messages = messages;
    }

    public void execute() throws JobExecutionException {
        ItemWriter<InProcessMail> itemWriter = new QueueItemWriter(messages);

        try {
            ItemReader<Member> itemReader = new FileItemReader(usersInfoData);
            FileReader ruleReader = new FileReader(rulesPath);
            UserProcess mailSender = new UserProcess(itemReader, itemWriter, ruleReader);

            mailSender.setRuleEngine(new RuleParser());
            mailSender.doProcessing();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

