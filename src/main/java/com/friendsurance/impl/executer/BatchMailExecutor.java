package com.friendsurance.impl.executer;

import com.friendsurance.impl.exceptions.JobExecutionException;
import com.friendsurance.impl.mailservice.QueueMailService;
import com.friendsurance.impl.model.InProcessMail;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.*;

//TODO Documentation
public class BatchMailExecutor {

    public static void main(String[] args) {

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        ZonedDateTime nextRun = now.withHour(3).withMinute(0).withSecond(0);
        if(now.compareTo(nextRun) > 0)
            nextRun = nextRun.plusDays(1);

        Duration duration = Duration.between(now, nextRun);
        long initalDelay = duration.getSeconds();

        BlockingQueue<InProcessMail> messages = new LinkedBlockingQueue<InProcessMail>();
        QueueMailService mailService = new QueueMailService(messages);

        ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(mailService, initalDelay, TimeUnit.DAYS.toSeconds(1), TimeUnit.SECONDS);
    }
}
