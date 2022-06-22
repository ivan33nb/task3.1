package ru.yandex.ivan_vaysman.task31.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyShareDTO {
    private Long avgTotalVolume;
    private String calculationPrice;
    private BigDecimal change;
    private BigDecimal changePercent;
    private Long close;
    private String closeSource;
    private Date closeTime;
    private String companyName;
    private String currency;
}

/*
{"avgTotalVolume":31703432,"calculationPrice":"iexlasttrade",
"change":-0.84,"changePercent":-0.00334,"close":0,"closeSource":"olffaici",
"closeTime":null,"companyName":"Microsoft Corporation","currency":"USD",
"delayedPrice":null,"delayedPriceTime":null,"extendedChange":null,
"extendedChangePercent":null,"extendedPrice":null,"extendedPriceTime":null,"high":0,
"highSource":null,"highTime":null,"iexAskPrice":0,"iexAskSize":0,"iexBidPrice":0,"iexBidSize":0,
"iexClose":261.87,"iexCloseTime":1657491256477,"iexLastUpdated":1698423252880,"iexMarketPercent":0.032101383972385156,
"iexOpen":263.66,"iexOpenTime":1724219401151,"iexRealtimePrice":264.26,"iexRealtimeSize":302,
"iexVolume":817050,"lastTradeTime":1682879653861,"latestPrice":264.99,"latestSource":"IEX Last Trade",
"latestTime":"June 22, 2022","latestUpdate":1738621743656,"latestVolume":null,"low":0,"lowSource":" lcei e ItiaeErprXm",
"lowTime":1666735498154,"marketCap":1961064404929,"oddLotDelayedPrice":null,
"oddLotDelayedPriceTime":null,"open":0,"openTime":null,"openSource":"oifaficl",
"peRatio":27.1,"previousClose":264.06,"previousVolume":31299106,"primaryExchange":"AQDANS",
"symbol":"MSFT","volume":null,"week52High":356.4,"week52Low":251.5,"ytdChange":-0.2608224377805512,"isUSMarketOpen":false}
 */