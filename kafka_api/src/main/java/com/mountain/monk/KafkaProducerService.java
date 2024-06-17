package com.mountain.monk;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaProducerService {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;



    public void sendMessage(String topic, String message) {

        ProducerRecord<String,String> record=new ProducerRecord<>(topic,message);
        long timeStamp=System.currentTimeMillis()+5000L;
        record.headers().add(new RecordHeader("delay",String.valueOf(timeStamp).getBytes()));
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(record);

        future.addCallback(success -> log.info("发送消息成功!"), failure -> log.error("发送消息失败!失败原因是:{}", failure.getMessage()));

    }
}


