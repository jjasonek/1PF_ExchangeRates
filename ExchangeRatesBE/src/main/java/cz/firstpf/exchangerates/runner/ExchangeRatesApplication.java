package cz.firstpf.exchangerates.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring boot application runner.
 *
 * @author Jiri Jasonek
 **/

@EnableJpaRepositories("cz.firstpf.exchangerates.persistence.repository")
@EntityScan("cz.firstpf.exchangerates.persistence.model")
@SpringBootApplication(scanBasePackages = {"cz.firstpf.exchangerates"})
public class ExchangeRatesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeRatesApplication.class, args);
    }
}
