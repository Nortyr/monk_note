package com.mountain.monk;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "myTopics", groupId = "myGroup")
    public void listen(ConsumerRecord<String,String> record, Acknowledgment ack) {
        String key=record.key();
        String value=record.value();
        int partition = record.partition();
        long offset = record.offset();
        Headers headers=record.headers();
        Header header=headers.lastHeader("delay");

        System.out.println("Received message: " + value + ", key: " + key + ", partition: " + partition + ", offset: " + offset);
        if(header!=null){
            System.out.println("headers " +header +" value:"+ new String(header.value()));
        }


        // 处理消息逻辑
        ack.acknowledge();
    }
}
