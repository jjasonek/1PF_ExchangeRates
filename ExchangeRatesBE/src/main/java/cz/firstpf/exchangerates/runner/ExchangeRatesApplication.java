package cz.firstpf.exchangerates.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application runner.
 *
 * @author Jiri Jasonek
 **/

@SpringBootApplication(scanBasePackages = {"cz.firstpf.exchangerates"})
public class ExchangeRatesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeRatesApplication.class, args);
    }
}
