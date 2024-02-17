package cz.firstpf.exchangerates.service;

import cz.firstpf.exchangerates.dto.ExchangeRateDto;

import java.util.List;

/**
 * Service calling {@link cz.firstpf.exchangerates.client.ExchangeRatesClient}
 *
 * @author Jiri Jasonek
 **/

public interface ExchangeRatesService {

    List<ExchangeRateDto> getExchangeRates(boolean useDb);

}
