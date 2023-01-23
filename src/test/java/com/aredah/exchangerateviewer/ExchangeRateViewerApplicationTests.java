package com.aredah.exchangerateviewer;

import com.aredah.exchangerateviewer.controller.RateController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExchangeRateViewerApplicationTests {

    @Autowired
    RateController rateController;
    @Test
    void contextLoads() {
        Assertions.assertNotNull(rateController);
    }

}
