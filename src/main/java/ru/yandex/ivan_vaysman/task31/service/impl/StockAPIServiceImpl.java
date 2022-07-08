package ru.yandex.ivan_vaysman.task31.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.yandex.ivan_vaysman.Application;
import ru.yandex.ivan_vaysman.task31.domain.dto.CompanyShareDTO;
import ru.yandex.ivan_vaysman.task31.domain.entity.CompanyShare;
import ru.yandex.ivan_vaysman.task31.domain.entity.TradingCompany;
import ru.yandex.ivan_vaysman.task31.domain.mapper.CompanyShareMapper;
import ru.yandex.ivan_vaysman.task31.repository.CompanyShareRepository;
import ru.yandex.ivan_vaysman.task31.service.StockAPIService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class StockAPIServiceImpl implements StockAPIService {

  private final RestTemplateBuilder restTemplateBuilder;
  private final ObjectMapper mapper;
  private final CompanyShareRepository companyShareRepository;
  private final String QUOTE = "/quote?";

  @Value("${trading-company-url}")
  private String TRADING_COMPANY_URL;

  @Value("${api-token}")
  private String API_TOKEN;

  @Value("${company-share-url}")
  private String COMPANY_SHARE_URL;

  @Value("${display-percent}")
  private String DISPLAY_PERCENT;

  @Override
  public List<TradingCompany> getInfoAboutTradingCompany() {
    List<TradingCompany> response = new CopyOnWriteArrayList<>();
    ResponseEntity<String> tradingCompanyInfoResponse =
        restTemplateBuilder.build().getForEntity(TRADING_COMPANY_URL + API_TOKEN, String.class);
    try {
      response.addAll(
          mapper.readValue(tradingCompanyInfoResponse.getBody(), new TypeReference<>() {}));
    } catch (JsonProcessingException e) {
      log.error("Failed to deserialize object \n");
      e.printStackTrace();
    }
    return response;
  }

  @Async
  @Scheduled(fixedDelay = 20000)
  @Override
  public void getCurrentInfoAboutCompanyShare() throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(16);

    executorService.invokeAll(createCallables());
    executorService.shutdown();
  }

  public List<Callable<String>> createCallables() {
    List<Callable<String>> callables = new ArrayList<>();

    List<TradingCompany> tradingCompanies = getInfoAboutTradingCompany();

    for (TradingCompany tc : tradingCompanies) {
      final String url = COMPANY_SHARE_URL + tc.getSymbol() + QUOTE + API_TOKEN + DISPLAY_PERCENT;

      Callable<String> callable =
          () -> {
            String res =
                restTemplateBuilder
                    .build()
                    .getForEntity(
                        url,
                        String.class)
                    .getBody();
            try {
              CompanyShareDTO companyShareDTO = mapper.readValue(res, new TypeReference<>() {});
              CompanyShare companyShare = CompanyShareMapper.INSTANCE.unmap(companyShareDTO);
              companyShareRepository.save(companyShare);
            } catch (JsonProcessingException e) {
              log.error("Failed to deserialize object \n");
              e.printStackTrace();
            }
            return res;
          };
      callables.add(callable);
    }
    return callables;
  }
}
