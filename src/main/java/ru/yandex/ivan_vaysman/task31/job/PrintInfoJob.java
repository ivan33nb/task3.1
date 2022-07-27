package ru.yandex.ivan_vaysman.task31.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.yandex.ivan_vaysman.task31.service.StockInfoService;

@Slf4j
@RequiredArgsConstructor
@Component
public class PrintInfoJob {

  private final StockInfoService stockInfoService;

  @Async
  @Scheduled(cron = "${cron.show-info}")
  public void getTopFiveMostExpensiveTradingCompany() {
    log.info(
        "Top five most expensive trading company -> \n{}",
        stockInfoService.getTopFiveMostExpensiveTradingCompany());
  }

  @Async
  @Scheduled(cron = "${cron.show-info}")
  public void getTopFiveGreatestChangePercentInStock() {
    log.info(
        "Top five greatest change percent in stock -> \n{}",
        stockInfoService.getTopFiveGreatestChangePercentInStock());
  }
}
