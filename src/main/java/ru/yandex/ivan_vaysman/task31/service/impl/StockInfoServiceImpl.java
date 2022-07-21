package ru.yandex.ivan_vaysman.task31.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.yandex.ivan_vaysman.task31.repository.CompanyShareRepository;
import ru.yandex.ivan_vaysman.task31.service.StockInfoService;

@RequiredArgsConstructor
@Service
public class StockInfoServiceImpl implements StockInfoService {

  private final CompanyShareRepository companyShareRepository;

  @Async
  @Scheduled(cron = "${cron.show-info}")
  @Override
  public void getTopFiveMostExpensiveTradingCompany() {
    System.out.println(
        "Top five most expensive trading company -> \n"
            + companyShareRepository.getTopFiveMostExpensiveTradingCompany());
  }

  @Async
  @Scheduled(cron = "${cron.show-info}")
  @Override
  public void getTopFiveGreatestChangePercentInStock() {
    System.out.println(
        "Top five greatest change percent in stock -> \n"
            + companyShareRepository.getTopFiveByPercentInStock());
  }
}
