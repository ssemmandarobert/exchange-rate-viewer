package com.aredah.exchangerateviewer.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RateControllerTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void helloWorldShouldReturnHelloWorldText(){
        String url = "http://localhost:"+port +"/test";
        Assertions.assertThat(this.testRestTemplate.getForObject(url,String.class))
                .contains("hello world Stack");
    }

}