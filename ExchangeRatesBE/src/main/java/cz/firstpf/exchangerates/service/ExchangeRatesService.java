package cz.firstpf.exchangerates.service;

import cz.firstpf.exchangerates.entity.ExchangeRate;

import java.util.List;

/**
 * Service calling {@link cz.firstpf.exchangerates.client.ExchangeRatesClient}
 *
 * @author Jiri Jasonek
 **/

public interface ExchangeRatesService {

    List<ExchangeRate> getExchangeRates(boolean useDb);

}
