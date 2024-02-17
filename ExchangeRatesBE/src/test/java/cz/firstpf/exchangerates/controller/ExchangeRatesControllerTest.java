package cz.firstpf.exchangerates.controller;

import cz.firstpf.exchangerates.runner.ExchangeRatesApplication;
import cz.firstpf.exchangerates.service.ExchangeRatesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Web layer tests for {@link ExchangeRatesController}
 *
 * @author Jiri Jasonek
 */

@AutoConfigureMockMvc
@SpringBootTest(classes = ExchangeRatesApplication.class)
final class ExchangeRatesControllerTest {

    private static final String EXCHANGE_RATES_PATH = "/exchangerates/api/v1";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ExchangeRatesService exchangeRatesService;

    @Test
    void getExchangeRates_success() throws Exception {
        when(exchangeRatesService.getExchangeRates(anyBoolean())).thenReturn(new ArrayList<>());

        this.mockMvc.perform(get(EXCHANGE_RATES_PATH)
                        .param("useDb", String.valueOf(true))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[]"));
    }

    @Test
    void getExchangeRates_failsOnException() throws Exception {
        when(exchangeRatesService.getExchangeRates(anyBoolean())).thenThrow(new RuntimeException(""));

        this.mockMvc.perform(get(EXCHANGE_RATES_PATH)
                        .param("useDb", String.valueOf(true))
                )
                .andExpect(status().isInternalServerError());
    }

    @Test
    void getExchangeRates_failsOnMissingRequestParameter() throws Exception {

        this.mockMvc.perform(get(EXCHANGE_RATES_PATH))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void getExchangeRates_failsOnBadUrl() throws Exception {

        this.mockMvc.perform(get(""))
                .andExpect(status().isInternalServerError());
    }
}