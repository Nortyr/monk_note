package com.mountain.monk;



import org.dromara.dynamictp.core.DtpRegistry;
import org.dromara.dynamictp.core.executor.DtpExecutor;
import org.dromara.dynamictp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executor;



@EnableDynamicTp

@SpringBootApplication
public class DynamicApplication {
    public static void main(String[] args) {

        SpringApplication.run(DynamicApplication.class, args);
        Executor dtpExecutor1 = DtpRegistry.getExecutor("tpExecutor");

    }

}
