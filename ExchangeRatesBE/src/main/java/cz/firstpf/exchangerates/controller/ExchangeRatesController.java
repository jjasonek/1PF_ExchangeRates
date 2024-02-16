package cz.firstpf.exchangerates.controller;

import cz.firstpf.exchangerates.entity.ExchangeRate;
import cz.firstpf.exchangerates.service.ExchangeRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * exchange rates controller
 *
 * @author Jiri Jasonek
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/exchangerates/api/v1")
public final class ExchangeRatesController {

    private final ExchangeRatesService exchangeRatesService;

    @GetMapping
    public ResponseEntity<List<ExchangeRate>> getExchangeRates(@RequestParam boolean useDb) {

        List<ExchangeRate> exchangeRates = exchangeRatesService.getExchangeRates(useDb);
        return new ResponseEntity<List<ExchangeRate>>(exchangeRates, HttpStatus.OK);
    }

}
