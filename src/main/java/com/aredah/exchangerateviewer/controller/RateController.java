package com.aredah.exchangerateviewer.controller;

import com.aredah.exchangerateviewer.domain.Currency;
import com.aredah.exchangerateviewer.domain.Rate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

@RestController
public class RateController {

    @GetMapping(path = "/test")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.accepted().body("hello world Stack");
    }

    @GetMapping(path = "/rates")
    public List<Rate> getRates(){
        return Collections.singletonList(new Rate("EUR",
                "USD",
                BigDecimal.valueOf(1.0),
                Instant.now()));
    }

    @GetMapping(path = "/currencies")
    public List<Currency> getCurrencies(){
        return Collections.singletonList(new Currency("EURO","EUR", "978"));
    }
}
