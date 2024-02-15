package cz.firstpf.exchangerates.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application runner.
 *
 * @author Jiri Jasonek
 *
 **/

@SpringBootApplication
public class ExchangeratesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeratesApplication.class, args);
    }
}
