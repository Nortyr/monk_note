package com.mountain.monk;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider-demo")
public interface EchoFegin {

    @GetMapping("/echo")
     String echo();
}