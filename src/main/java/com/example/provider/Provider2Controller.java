package com.example.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: yangjianguang
 * @Date: 2018/6/20
 */
@RestController
public class Provider2Controller {
    private final AtomicLong counter = new AtomicLong(new Random().nextInt(1000));

    @RequestMapping("/provider2")
    public ProviderDTO provider(@RequestParam(value="provider", defaultValue="provider2") String provider) {
        return new ProviderDTO(counter.incrementAndGet(), provider);
    }
}
