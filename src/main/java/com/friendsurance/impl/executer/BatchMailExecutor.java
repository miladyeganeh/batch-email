package com.friendsurance.impl.executer;

import com.friendsurance.impl.mailservice.QueueMailService;
import com.friendsurance.impl.model.Mail;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.*;

/**
 * @author M.Yeganeh
 * Entry point
 **/
public class BatchMailExecutor {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        ZonedDateTime nextRun = now.withHour(3).withMinute(0).withSecond(0);
        if(now.compareTo(nextRun) > 0)
            nextRun = nextRun.plusDays(1);

        Duration duration = Duration.between(now, nextRun);
        long initalDelay = duration.getSeconds();

        BlockingQueue<Mail> messages = new LinkedBlockingQueue<Mail>();
        QueueMailService mailService = new QueueMailService(messages);

        ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(mailService, 0, 5, TimeUnit.SECONDS); //For testing
//        executorService.scheduleAtFixedRate(mailService, initalDelay, TimeUnit.DAYS.toSeconds(1), TimeUnit.SECONDS); // run every 3AM
    }
}
