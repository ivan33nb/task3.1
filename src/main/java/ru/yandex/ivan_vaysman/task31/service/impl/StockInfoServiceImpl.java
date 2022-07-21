package ru.yandex.ivan_vaysman.task31.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.ivan_vaysman.task31.repository.CompanyShareRepository;
import ru.yandex.ivan_vaysman.task31.service.StockInfoService;

@RequiredArgsConstructor
@Service
public class StockInfoServiceImpl implements StockInfoService {

  private final CompanyShareRepository companyShareRepository;

  @Override
  public String getTopFiveMostExpensiveTradingCompany() {
    return companyShareRepository.getTopFiveMostExpensiveTradingCompany().toString();
  }

  @Override
  public String getTopFiveGreatestChangePercentInStock() {
    return companyShareRepository.getTopFiveByPercentInStock().toString();
  }
}
