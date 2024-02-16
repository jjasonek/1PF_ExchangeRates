package cz.firstpf.exchangerates.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Exchange rates entity
 *
 * @author Jiri Jasonek
 **/

final public class ExchangeRate {

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
