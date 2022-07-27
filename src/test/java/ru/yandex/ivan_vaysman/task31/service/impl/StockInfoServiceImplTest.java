package ru.yandex.ivan_vaysman.task31.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.yandex.ivan_vaysman.task31.domain.entity.CompanyShare;
import ru.yandex.ivan_vaysman.task31.repository.CompanyShareRepository;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class StockInfoServiceImplTest {

  @Container
  private static final MySQLContainer<?> mySqlDB =
      new MySQLContainer<>("mysql:5.7.37").withInitScript("db/create-and-fill-test-table.sql");

  @DynamicPropertySource
  public static void properties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", mySqlDB::getJdbcUrl);
    registry.add("spring.datasource.username", mySqlDB::getUsername);
    registry.add("spring.datasource.password", mySqlDB::getPassword);
  }

  @Autowired private CompanyShareRepository companyShareRepository;

  @Test
  public void checkContainerIsRunning() {
    assertTrue(mySqlDB.isRunning());
  }

  @Test
  public void checkFindAllNotEmpty() {
    List<CompanyShare> companyShareList = companyShareRepository.findAll();
    assertFalse(companyShareList.isEmpty());
  }

  @Test
  public void checkAmountOfElement() {
    List<CompanyShare> companyShareList = companyShareRepository.findAll();
    assertEquals(companyShareList.size(), 9);
  }

  @Test
  public void checkSaveObject() {
    List<CompanyShare> companyShareListBeforeSave = companyShareRepository.findAll();

    CompanyShare companyShare = new CompanyShare();
    companyShare.setSymbol("tenth");

    companyShareRepository.save(companyShare);

    List<CompanyShare> companyShareListAfterSave = companyShareRepository.findAll();

    assertNotEquals(companyShareListBeforeSave.size(), companyShareListAfterSave.size());
    assertEquals(companyShareListBeforeSave.size() + 1, companyShareListAfterSave.size());
  }

  @Test
  public void checkFindById() {
    CompanyShare companyShare = companyShareRepository.findById("first").orElse(null);
    assertNotNull(companyShare);
    assertEquals(companyShare.getSymbol(), "first");
  }
}
