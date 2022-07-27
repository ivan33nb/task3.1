package ru.yandex.ivan_vaysman.task31.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.yandex.ivan_vaysman.task31.domain.entity.CompanyShare;

public interface CompanyShareRepository extends JpaRepository<CompanyShare, String> {

  @Query("select csh.companyName from CompanyShare csh order by csh.changePercent")
  Page<String> getTopFiveByPercentInStock(Pageable pageable);

  @Query("select csh.companyName from CompanyShare csh order by csh.latestPrice")
  Page<String> getTopFiveMostExpensiveTradingCompany(Pageable pageable);
}
