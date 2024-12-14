package uz.bank.account.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import uz.bank.account.dto.CurrencyDto;
import uz.bank.account.entity.Currency;

@Component
@Mapper(componentModel = "spring")
public interface  CurrencyMapper {

    CurrencyMapper currencyMapper = Mappers.getMapper(CurrencyMapper.class);

    CurrencyDto toDto(Currency currency);


}
