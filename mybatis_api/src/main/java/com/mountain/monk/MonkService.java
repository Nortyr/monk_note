package com.mountain.monk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MonkService {

    @Autowired
    private MonkMapper monkMapper;
    @Autowired
    private TestMapper testMapper;
    @Autowired
    ApplicationContext applicationContext;

    @Transactional
    public void insertTest(){
        testMapper.insertTest();
        MonkService monkService=(MonkService)applicationContext.getBean("monkService");

        monkService.insertMonk();
    }

    @Async
    @Transactional
    public void insertMonk(){
        try{
            monkMapper.insertData();
            int i=1/0;
        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
