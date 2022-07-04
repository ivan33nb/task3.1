package ru.yandex.ivan_vaysman.task31.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.yandex.ivan_vaysman.task31.domain.entity.CompanyShare;
import ru.yandex.ivan_vaysman.task31.repository.CompanyShareRepository;
import ru.yandex.ivan_vaysman.task31.service.StockInfoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StockInfoServiceImpl implements StockInfoService {

    private final CompanyShareRepository companyShareRepository;

    @Scheduled(fixedRate = 5000)
    @Override
    public void getTopFiveMostExpensiveTradingCompany() {
        List<CompanyShare> all = companyShareRepository.findAll();
    }

    @Scheduled(fixedRate = 5000)
    @Override
    public void getTopFiveGreatestChangePercentInStock() {

    }
}
