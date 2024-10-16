package com.mountain.monk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients    // 开启远程调用

public class ConsumerDemoMain {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDemoMain.class, args);
    }

    @RestController
    public class EchoController {

        @Autowired
        private EchoFegin echoFegin;

        @GetMapping(value = "/echo")
        public String echo() {
            return echoFegin.echo();
        }
    }
}