package cz.firstpf.exchangerates.client;

import cz.firstpf.exchangerates.entity.ExchangeRate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of {@link ExchangeRatesClient}
 *
 * @author Jiri Jasonek
 **/

@Component
public final class ExchangeRatesClientImpl implements ExchangeRatesClient {

    private static final String BASE_URL = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates";
    private static final String WEB_API_KEY_NAME = "web-api-key";
    private static final String WEB_API_KEY_VALUE = "c52a0682-4806-4903-828f-6cc66508329e";
    private static final RestClient restClient = RestClient.create();
    private static final URI uri = UriComponentsBuilder
            .fromUriString(BASE_URL)
            .queryParam(WEB_API_KEY_NAME, "{WEB_API_KEY_NAME}")
            .build(WEB_API_KEY_VALUE);

    @Override
    public List<ExchangeRate> getExchangeRates() {

        return Arrays.stream(
                        Objects.requireNonNull(restClient.get()
                                .uri(uri)
                                .retrieve()
                                .body(ExchangeRate[].class))
                )
                .toList();
    }
}
