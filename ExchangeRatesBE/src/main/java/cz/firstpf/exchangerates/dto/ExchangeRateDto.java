package cz.firstpf.exchangerates.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Exchange rates entity
 *
 * @author Jiri Jasonek
 **/

@Getter
@Setter
@EqualsAndHashCode
final public class ExchangeRateDto {

    String shortName;
    LocalDateTime validFrom;
    String name;
    String country;
    BigDecimal move;
    BigDecimal amount;
    BigDecimal valBuy;
    BigDecimal valSell;
    BigDecimal valMid;
    BigDecimal currBuy;
    BigDecimal currSell;
    BigDecimal currMid;
    int version;
    BigDecimal cnbMid;
    BigDecimal ecbMid;
}
