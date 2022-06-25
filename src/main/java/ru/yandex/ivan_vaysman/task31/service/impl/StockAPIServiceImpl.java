package ru.yandex.ivan_vaysman.task31.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.yandex.ivan_vaysman.task31.domain.dto.TradingCompanyDTO;
import ru.yandex.ivan_vaysman.task31.domain.entity.CompanyShare;
import ru.yandex.ivan_vaysman.task31.domain.entity.TradingCompany;
import ru.yandex.ivan_vaysman.task31.domain.mapper.TradingCompanyMapper;
import ru.yandex.ivan_vaysman.task31.service.StockAPIService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class StockAPIServiceImpl implements StockAPIService {

    private final RestTemplateBuilder restTemplateBuilder;
    private final ObjectMapper mapper;

    @Value("${trading-company-url}")
    private String tradingCompanyUrl;

    @Override
    public TradingCompany getInfoAboutTradingCompany() {
        ResponseEntity<String> tradingCompanyInfoResponse = restTemplateBuilder.build().getForEntity(tradingCompanyUrl, String.class);
        try {
            List<TradingCompanyDTO> list = mapper.readValue(tradingCompanyInfoResponse.getBody(), new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            log.error("Failed to deserialize object \n");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CompanyShare getCurrentInfoAboutCompanyShare() {
        return null;
    }

    @Scheduled(fixedRate = 20L)
    public void f(){
        getInfoAboutTradingCompany();
    }
}
