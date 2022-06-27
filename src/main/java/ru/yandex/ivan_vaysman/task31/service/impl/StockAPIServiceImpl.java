package ru.yandex.ivan_vaysman.task31.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.yandex.ivan_vaysman.task31.domain.entity.TradingCompany;
import ru.yandex.ivan_vaysman.task31.repository.CompanyShareRepository;
import ru.yandex.ivan_vaysman.task31.service.StockAPIService;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@RequiredArgsConstructor
@Service
public class StockAPIServiceImpl implements StockAPIService {

    private final RestTemplateBuilder restTemplateBuilder;
    private final ObjectMapper mapper;
    private final CompanyShareRepository companyShareRepository;

    @Value("${trading-company-url}" + "${api-token}")
    private String tradingCompanyUrl;


    @Override
    public List<TradingCompany> getInfoAboutTradingCompany() {
        List<TradingCompany> response = new CopyOnWriteArrayList<>();
        ResponseEntity<String> tradingCompanyInfoResponse = restTemplateBuilder.build().getForEntity(tradingCompanyUrl, String.class);
        try {
            response.addAll(mapper.readValue(tradingCompanyInfoResponse.getBody(), new TypeReference<>() {}));
            System.out.println(response.get(0));
        } catch (JsonProcessingException e) {
            log.error("Failed to deserialize object \n");
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public void getCurrentInfoAboutCompanyShare() {
        List<TradingCompany> tradingCompanies = getInfoAboutTradingCompany();
    }

    @Scheduled(fixedRate = 20L)
    public void f(){
        getInfoAboutTradingCompany();
    }
}
