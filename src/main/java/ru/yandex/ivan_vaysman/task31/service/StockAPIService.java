package ru.yandex.ivan_vaysman.task31.service;

import ru.yandex.ivan_vaysman.task31.domain.entity.CompanyShare;
import ru.yandex.ivan_vaysman.task31.domain.entity.TradingCompany;

import java.util.List;

public interface StockAPIService {

    List<TradingCompany> getInfoAboutTradingCompany();
    CompanyShare getCurrentInfoAboutCompanyShare();
}
