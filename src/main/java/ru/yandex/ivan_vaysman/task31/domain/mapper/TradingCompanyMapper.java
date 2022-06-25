package ru.yandex.ivan_vaysman.task31.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.yandex.ivan_vaysman.task31.domain.dto.TradingCompanyDTO;
import ru.yandex.ivan_vaysman.task31.domain.entity.TradingCompany;

@Mapper
public interface TradingCompanyMapper {

    TradingCompanyMapper INSTANCE = Mappers.getMapper(TradingCompanyMapper.class);

    TradingCompany unmap(TradingCompanyDTO dto);
    TradingCompanyDTO map(TradingCompany tradingCompany);
}
