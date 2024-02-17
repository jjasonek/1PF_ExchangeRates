package cz.firstpf.exchangerates.runner;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring boot application runner.
 *
 * @author Jiri Jasonek
 **/

@EnableJpaRepositories(basePackages = {"cz.firstpf.exchangerates.persistence.repository"})
@EntityScan(basePackages = {"cz.firstpf.exchangerates.persistence.model"})
@SpringBootApplication(scanBasePackages = {"cz.firstpf.exchangerates"})
public class ExchangeRatesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeRatesApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
