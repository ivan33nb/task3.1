package ru.yandex.ivan_vaysman.task31.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.ivan_vaysman.task31.domain.entity.CompanyShare;

public interface CompanyShareRepository extends JpaRepository<CompanyShare, Long> {
}
