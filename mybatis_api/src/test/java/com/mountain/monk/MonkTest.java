package com.mountain.monk;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonkTest {

    @Autowired
    private MonkService monkService;

    @Test
    public void send() {
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(1,2);

//        monkService.insertTest();
    }



}
