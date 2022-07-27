package ru.yandex.ivan_vaysman.task31.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.yandex.ivan_vaysman.task31.repository.CompanyShareRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class StockInfoServiceImplTest {

  @Container
  public static MySQLContainer<?> mySqlDB =
      new MySQLContainer<>("mysql:5.7.37")
          .withInitScript("db/create-and-fill-test-table.sql");

  @DynamicPropertySource
  public static void properties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", mySqlDB::getJdbcUrl);
    registry.add("spring.datasource.username", mySqlDB::getUsername);
    registry.add("spring.datasource.password", mySqlDB::getPassword);
  }

  @Autowired private CompanyShareRepository companyShareRepository;

  @Test
  public void test() {

  }
}
