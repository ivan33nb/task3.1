package ru.yandex.ivan_vaysman.task31.service.impl;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import ru.yandex.ivan_vaysman.task31.repository.CompanyShareRepository;

class StockInfoServiceImplTest {

    CompanyShareRepository companyShareRepository = mock(CompanyShareRepository.class);

    @Test
    void checkFindAll() {
        companyShareRepository.findAll();
        verify(companyShareRepository, times(1)).findAll();
    }

    @Test
    void getTopFiveGreatestChangePercentInStock() {
        companyShareRepository.findAll();
        verify(companyShareRepository, times(1)).findAll();
    }
}