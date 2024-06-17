package com.mountain.monk;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SenderTest {

    @Autowired
    KafkaProducerService producerService;
    @Test
    public void testSender(){
        producerService.sendMessage("myTopics", "Hello World!!!!");

    }


}
