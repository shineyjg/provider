package com.example.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: yangjianguang
 * @Date: 2018/6/20
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ProviderApplication {
    public static void main(String[] args) {
        log.error("main() test log info");
        SpringApplication.run(ProviderApplication.class, args);
    }
}
