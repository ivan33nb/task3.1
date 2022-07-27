package ru.yandex.ivan_vaysman.task31.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.yandex.ivan_vaysman.task31.domain.dto.CompanyShareDTO;
import ru.yandex.ivan_vaysman.task31.domain.entity.CompanyShare;

@Mapper
public interface CompanyShareMapper {
  CompanyShareMapper INSTANCE = Mappers.getMapper(CompanyShareMapper.class);

  CompanyShare unmap(CompanyShareDTO dto);

  CompanyShareDTO map(CompanyShare company);
}
