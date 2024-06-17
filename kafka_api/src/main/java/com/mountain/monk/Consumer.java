package com.mountain.monk;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

//    @KafkaListener(topics = {"myTopics"})
//    public void listener(ConsumerRecord<String, String> record) {
//        String value = record.value();
//        log.info("【receive】:{}", value);
//    }
}

