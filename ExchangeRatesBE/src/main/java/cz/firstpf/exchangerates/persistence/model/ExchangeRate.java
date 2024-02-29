package cz.firstpf.exchangerates.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class for the exchange rates
 * I this simple example we don't need to override nighter equals() nor hashCode() methods.
 * The primary key {@link #hash} is counted from the DTO {@link cz.firstpf.exchangerates.dto.ExchangeRateDto}
 * Equality is tested only according to the primary key.
 * Don't use this approach in more complex cases.
 *
 * @author Jiri Jasonek
 **/

@Getter
@Setter
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
