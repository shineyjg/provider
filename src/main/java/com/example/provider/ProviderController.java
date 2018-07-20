package com.example.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestHeader;
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
@Slf4j
public class ProviderController {
    private final AtomicLong counter = new AtomicLong(new Random().nextInt(1000));

    @RequestMapping("/provider")
    public ProviderDTO provider(@RequestHeader(value="DeployTag", defaultValue="") String deployTag, @RequestParam(value="provider", defaultValue="provider1") String provider) throws Exception {
//        throw new Exception("asdf");
        return new ProviderDTO(counter.incrementAndGet(), provider + ":" + deployTag);
    }

    @RequestMapping("/another-provider")
    public ProviderDTO anotherProvider(@RequestParam(value="provider", defaultValue="another provider") String provider) {
        return new ProviderDTO(counter.incrementAndGet(), provider);
    }
}
