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
import java.util.Scanner;

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

    public static void main(String[] args) {
        new KafkaConsumerService().minWindow("ADOBECODEBANC","ABC");
    }
    public String minWindow(String s, String t) {
        Map<Character,Integer> targetMap=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i),targetMap.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character,Integer> map=new HashMap<>();
        String result="";
        int l=0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            while(check(map,targetMap)){
                result="".equals(result)||result.length()>(i-l+1)?s.substring(l,i+1):result;
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;

            }
        }
        int end=s.length()-1;
        while(check(map,targetMap)){
            result="".equals(result)||result.length()>(end-l+1)?s.substring(l,s.length()+1):result;
            map.put(s.charAt(l),map.get(s.charAt(l))-1);
            l++;

        }
        return result;

    }

    private boolean check(Map<Character, Integer> map, Map<Character, Integer> targetMap) {
        if(map.size()<targetMap.size()){
            return false;
        }
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            if(!map.containsKey(entry.getKey())||map.getOrDefault(entry.getKey(),0)<targetMap.get(entry.getKey())){
                return false;
            }
        }
        return true;
    }
}
