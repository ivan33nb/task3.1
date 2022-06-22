package ru.yandex.ivan_vaysman.task31.service;

import ru.yandex.ivan_vaysman.task31.domain.entity.CompanyShare;
import ru.yandex.ivan_vaysman.task31.domain.entity.TradingCompany;

public interface StockAPIService {
    TradingCompany getInfoAboutTradingCompany();
    CompanyShare getCurrentInfoAboutCompanyShare();
}
