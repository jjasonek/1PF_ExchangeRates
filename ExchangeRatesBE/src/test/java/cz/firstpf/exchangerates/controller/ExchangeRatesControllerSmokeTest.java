package cz.firstpf.exchangerates.controller;

import cz.firstpf.exchangerates.runner.ExchangeRatesApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Smoke Test for {@link ExchangeRatesController}
 *
 * @author Jiri Jasonek
 */

@SpringBootTest(classes = ExchangeRatesApplication.class)
final class ExchangeRatesControllerSmokeTest {

    @Autowired
    private ExchangeRatesController exchangeRatesController;

    @Test
    void contextLoads() {
        assertThat(exchangeRatesController).isNotNull();
    }
}