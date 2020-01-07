package com.mq.consumer.sendthread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SendThreadPool {

    private static ThreadPoolExecutor executor = null;

    public static ThreadPoolExecutor getThread() {
        if (Objects.isNull(executor)) {
            executor = new ThreadPoolExecutor(10, 20, 10000, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(), new BasicThreadFactory.Builder().daemon(true).build());
        }
        return executor;
    }


}
