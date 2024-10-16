package com.mountain.monk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderDemoMain {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDemoMain.class, args);
    }

    @RefreshScope
    @RestController
    public class EchoController {

        @Value("${self.name}")
        private String name;

        @GetMapping(value = "/echo")
        public String echo() {
            return "Hello Nacos Discovery test "+name ;
        }
    }
}