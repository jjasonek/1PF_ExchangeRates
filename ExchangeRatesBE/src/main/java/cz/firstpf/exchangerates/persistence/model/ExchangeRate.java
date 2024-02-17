package cz.firstpf.exchangerates.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class for the exchange rates
 *
 * @author Jiri Jasonek
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exchange_rates")
@Entity
public final class ExchangeRate {

    @Id
    private long hash;

    private String shortName;
    private LocalDateTime validFrom;
    private String name;
    private String country;
    private BigDecimal move;
    private BigDecimal amount;
    private BigDecimal valBuy;
    private BigDecimal valSell;
    private BigDecimal valMid;
    private BigDecimal currBuy;
    private BigDecimal currSell;
    private BigDecimal currMid;
    private int version;
    private BigDecimal cnbMid;
    private BigDecimal ecbMid;
}
