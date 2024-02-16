package cz.firstpf.exchangerates.client;

import cz.firstpf.exchangerates.entity.ExchangeRate;

import java.util.List;

/**
 * REST Client consuming exchange rates API
 *
 * @author Jiri Jasonek
 **/

public interface ExchangeRatesClient {

    List<ExchangeRate> getExchangeRates();

}
