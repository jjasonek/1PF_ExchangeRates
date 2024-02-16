package cz.firstpf.exchangerates.service;

import cz.firstpf.exchangerates.client.ExchangeRatesClient;
import cz.firstpf.exchangerates.entity.ExchangeRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link ExchangeRatesService}
 *
 * @author Jiri Jasonek
 **/

@Service
@RequiredArgsConstructor
public final class ExchangeRatesServiceImpl implements ExchangeRatesService {

    private final ExchangeRatesClient exchangeRatesClient;

    @Override
    public List<ExchangeRate> getExchangeRates(boolean useDb) {
        return exchangeRatesClient.getExchangeRates();
    }
}
