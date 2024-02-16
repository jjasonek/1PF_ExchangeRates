package cz.firstpf.exchangerates.service;

import cz.firstpf.exchangerates.entity.ExchangeRate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {
    @Override
    public List<ExchangeRate> getExchangeRates(boolean useDb) {
        return new ArrayList<> ();
    }
}
