package ru.yandex.ivan_vaysman.task31.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradingCompany {
  private String symbol;
  private String exchange;
  private String exchangeSuffix;
  private String exchangeName;
  private String exchangeSegment;
  private String exchangeSegmentName;
  private String name;
  private Date date;
  private String type;
  private String iexId;
  private String region;
  private String usd;
  private boolean isEnabled;
  private String figi;
  private String cik;
  private String lei;
}
