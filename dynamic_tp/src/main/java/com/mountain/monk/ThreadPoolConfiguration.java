package com.mountain.monk;


import org.dromara.dynamictp.common.em.QueueTypeEnum;
import org.dromara.dynamictp.core.executor.DtpExecutor;
import org.dromara.dynamictp.core.support.ThreadPoolBuilder;
import org.dromara.dynamictp.core.support.ThreadPoolCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfiguration {

    @Bean
    public DtpExecutor dtpExecutor() {

        return ThreadPoolCreator.createDynamicFast("dynamic-tp-test-1");
    }

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return ThreadPoolBuilder.newBuilder()
                .threadPoolName("dynamic-tp-test-2")
                .corePoolSize(10)
                .maximumPoolSize(15)
                .keepAliveTime(15000)
                .timeUnit(TimeUnit.MILLISECONDS)
                .workQueue(QueueTypeEnum.SYNCHRONOUS_QUEUE.getName(), null, false)
                .buildDynamic();
    }
}

