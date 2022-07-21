package ru.yandex.ivan_vaysman.task31.service;

import java.util.List;

public interface StockInfoService {
    List<String> getTopFiveMostExpensiveTradingCompany();
    List<String> getTopFiveGreatestChangePercentInStock();
}
