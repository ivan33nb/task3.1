package ru.yandex.ivan_vaysman.task31.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.yandex.ivan_vaysman.task31.domain.entity.CompanyShare;

import java.util.List;

public interface CompanyShareRepository extends JpaRepository<CompanyShare, Long> {

  @Query(
      nativeQuery = true,
      value = "select csh.company_name from company_share csh order by csh.change_percent limit 5")
  List<String> getTopFiveByPercentInStock();

  @Query(
      nativeQuery = true,
      value = "select csh.company_name from company_share csh order by csh.latest_price limit 5")
  List<String> getTopFiveMostExpensiveTradingCompany();
}
