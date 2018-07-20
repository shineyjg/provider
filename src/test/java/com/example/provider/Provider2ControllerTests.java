package com.example.provider;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @Author: yangjianguang
 * @Date: 2018/6/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log
public class Provider2ControllerTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void provider() {
        log.info("begin test Provider2ControllerTests:provider()");
        ProviderDTO providerDTO = restTemplate.getForObject("/provider2",ProviderDTO.class);
        log.info(providerDTO.toString());
        assertTrue(providerDTO.getId()>=0);
        assertTrue(providerDTO.getId()<1000);
        assertEquals("provider2", providerDTO.getProvider());
    }
}
