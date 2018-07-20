package com.example.provider;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

/**
 * @Author: yangjianguang
 * @Date: 2018/6/20
 */
public class ProviderBaseTest {
    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new ProviderController(), new Provider2Controller());
    }
}
