package com.example.provider;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.*;

import org.apache.tools.ant.filters.TokenFilter.ContainsString;
/**
 * @Author: yangjianguang
 * @Date: 2018/6/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ProviderControllerTests {
    private MockMvc mvc;
    @Before
    public  void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new ProviderController()).build();
    }

    @Test
    public  void provider() throws Exception {
        log.info("begin test ProviderControllerTests:provider()");
        mvc.perform(MockMvcRequestBuilders.get("/provider?provider=hello")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.provider").value(containsString("hello")));
    }

    @Test
    public  void anotherProvider() throws Exception {
        log.info("begin test ProviderControllerTests:anotherProvider()");
        mvc.perform(MockMvcRequestBuilders.get("/another-provider?provider=another")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.provider").value("another"));
    }
}
