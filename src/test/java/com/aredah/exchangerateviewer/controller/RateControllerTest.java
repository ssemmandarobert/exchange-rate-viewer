package com.aredah.exchangerateviewer.controller;

import com.aredah.exchangerateviewer.domain.Currency;
import com.aredah.exchangerateviewer.domain.Rate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RateControllerTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void helloWorldShouldReturnHelloWorldText(){
        String url = "http://localhost:"+port +"/test";
        Assertions.assertThat(this.testRestTemplate.getForObject(url,String.class))
                .contains("hello world Stack");
    }


    @Test
    public void getRatesShouldReturnRatesList(){
        String url = "http://localhost:"+port +"/rates";
        List response = this.testRestTemplate.getForObject(url, List.class);

        Assertions.assertThat(response).isNotNull().isNotEmpty();
        Rate rate = objectMapper.convertValue(response.get(0),Rate.class);

        Assertions.assertThat(rate)
                .hasFieldOrPropertyWithValue("currencyFrom","EUR")
                .hasFieldOrPropertyWithValue("currencyTo","USD")
                .hasFieldOrPropertyWithValue("amount", BigDecimal.valueOf(1.0));

        Assertions.assertThat(rate.dateTime()).isNotNull();
    }


    @Test
    public void getCurrenciesShouldReturnCurrenciesList(){
        String url = "http://localhost:"+port +"/currencies";
        List response = this.testRestTemplate.getForObject(url, List.class);

        Assertions.assertThat(response).isNotNull().isNotEmpty();
        Currency currency = objectMapper.convertValue(response.get(0),Currency.class);

        Assertions.assertThat(currency)
                .hasFieldOrPropertyWithValue("name","EURO")
                .hasFieldOrPropertyWithValue("isoCode","EUR")
                .hasFieldOrPropertyWithValue("isoNum", "978");

    }

}