package ru.yandex.ivan_vaysman.task31.service;

import ru.yandex.ivan_vaysman.task31.domain.entity.TradingCompany;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface StockAPIService {

  List<TradingCompany> getInfoAboutTradingCompany();

  void getCurrentInfoAboutCompanyShare() throws ExecutionException, InterruptedException;
}
