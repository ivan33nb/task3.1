package ru.yandex.ivan_vaysman.task31.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "company_share")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyShareDTO {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "avgTotalVolume")
    private Long avgTotalVolume;
    @Column(name = "calculationPrice")
    private String calculationPrice;
    @Column(name = "change")
    private BigDecimal change;
    @Column(name = "changePercent")
    private BigDecimal changePercent;
    @Column(name = "close")
    private Long close;
    @Column(name = "closeSource")
    private String closeSource;
    @Column(name = "closeTime")
    private Date closeTime;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "currency")
    private String currency;
    @Column(name = "delayedPrice")
    private BigDecimal delayedPrice;
    @Column(name = "delayedPriceTime")
    private Date delayedPriceTime;
    @Column(name = "extendedChange")
    private BigDecimal extendedChange;
    @Column(name = "extendedChangePercent")
    private BigDecimal extendedChangePercent;
    @Column(name = "extendedPrice")
    private BigDecimal extendedPrice;
    @Column(name = "highSource")
    private String highSource;
    @Column(name = "highTime")
    private Date highTime;
    @Column(name = "iexAskPrice")
    private BigDecimal iexAskPrice;
    @Column(name = "iexAskSize")
    private Long iexAskSize;
    @Column(name = "iexBidPrice")
    private BigDecimal iexBidPrice;
    @Column(name = "iexBidSize")
    private Long iexBidSize;
    @Column(name = "iexClose")
    private BigDecimal iexClose;
    @Column(name = "iexCloseTime")
    private Date iexCloseTime;
    @Column(name = "iexLastUpdated")
    private Date iexLastUpdated;
    @Column(name = "iexMarketPercent")
    private BigDecimal iexMarketPercent;
    @Column(name = "iexOpen")
    private BigDecimal iexOpen;
    @Column(name = "iexOpenTime")
    private Date iexOpenTime;
    @Column(name = "iexRealtimePrice")
    private BigDecimal iexRealtimePrice;
    @Column(name = "iexRealtimeSize")
    private Long iexRealtimeSize;
    @Column(name = "iexVolume")
    private Long iexVolume;
    @Column(name = "lastTradeTime")
    private Date lastTradeTime;
    @Column(name = "latestPrice")
    private BigDecimal latestPrice;
    @Column(name = "latestSource")
    private String latestSource;
    @Column(name = "latestTime")
    private Date latestTime;
    @Column(name = "latestUpdate")
    private Date latestUpdate;
    @Column(name = "latestVolume")
    private Long latestVolume;
    @Column(name = "low")
    private Long low;
    @Column(name = "lowSource")
    private String lowSource;
    @Column(name = "lowTime")
    private Date lowTime;
    @Column(name = "marketCap")
    private Long marketCap;
    @Column(name = "oddLotDelayedPrice")
    private BigDecimal oddLotDelayedPrice;
    @Column(name = "oddLotDelayedPriceTime")
    private Date oddLotDelayedPriceTime;
    @Column(name = "open")
    private Long open;
    @Column(name = "openTime")
    private Date openTime;
    @Column(name = "openSource")
    private String openSource;
    @Column(name = "peRatio")
    private BigDecimal peRatio;
    @Column(name = "previousClose")
    private BigDecimal previousClose;
    @Column(name = "previousVolume")
    private Long previousVolume;
    @Column(name = "primaryExchange")
    private String primaryExchange;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "volume")
    private Long volume;
    @Column(name = "week52High")
    private BigDecimal week52High;
    @Column(name = "week52Low")
    private BigDecimal week52Low;
    @Column(name = "ytdChange")
    private BigDecimal ytdChange;
    @Column(name = "isUSMarketOpen")
    private Boolean isUSMarketOpen;
}