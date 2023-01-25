package com.aredah.exchangerateviewer.domain;

import java.math.BigDecimal;
import java.time.Instant;

public record Rate(String currencyFrom, String currencyTo, BigDecimal amount, Instant dateTime) {
}
