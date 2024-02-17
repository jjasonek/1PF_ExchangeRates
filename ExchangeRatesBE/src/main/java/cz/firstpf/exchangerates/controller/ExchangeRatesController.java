package cz.firstpf.exchangerates.controller;

import cz.firstpf.exchangerates.dto.ExchangeRateDto;
import cz.firstpf.exchangerates.service.ExchangeRatesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/exchangerates/api/v1")
public final class ExchangeRatesController {

    private final ExchangeRatesService exchangeRatesService;

    @GetMapping
    public ResponseEntity<List<ExchangeRateDto>> getExchangeRates(@RequestParam boolean useDb) {
        log.info(String.format("Processing request GET with using parameter useDb: %b.", useDb));
        List<ExchangeRateDto> exchangeRates = exchangeRatesService.getExchangeRates(useDb);
        return new ResponseEntity<>(exchangeRates, HttpStatus.OK);
    }

}
