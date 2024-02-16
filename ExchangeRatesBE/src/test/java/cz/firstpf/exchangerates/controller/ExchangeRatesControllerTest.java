package cz.firstpf.exchangerates.controller;

import cz.firstpf.exchangerates.runner.ExchangeRatesApplication;
import cz.firstpf.exchangerates.service.ExchangeRatesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExchangeRatesController.class)
@ContextConfiguration(classes = ExchangeRatesApplication.class)
class ExchangeRatesControllerTest {

    private static final String EXCHANGE_RATES = "/exchangerates/api/v1";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ExchangeRatesService exchangeRatesService;

    @Test
    void getExchangeRates_success() throws Exception {
        when(exchangeRatesService.getExchangeRates(true)).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get(EXCHANGE_RATES)
                        .param("useDb", String.valueOf(true))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[]"));
//                .andExpect(jsonPath("$").value(Collections.EMPTY_LIST));
    }
}