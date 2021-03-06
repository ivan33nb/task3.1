package ru.yandex.ivan_vaysman.task31.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.yandex.ivan_vaysman.task31.repository.CompanyShareRepository;
import ru.yandex.ivan_vaysman.task31.service.StockInfoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StockInfoServiceImpl implements StockInfoService {

  private final CompanyShareRepository companyShareRepository;

  @Override
  public List<String> getTopFiveMostExpensiveTradingCompany() {
    return companyShareRepository
        .getTopFiveMostExpensiveTradingCompany(PageRequest.of(0, 5))
        .getContent();
  }

  @Override
  public List<String> getTopFiveGreatestChangePercentInStock() {
    return companyShareRepository.getTopFiveByPercentInStock(PageRequest.of(0, 5)).getContent();
  }
}
