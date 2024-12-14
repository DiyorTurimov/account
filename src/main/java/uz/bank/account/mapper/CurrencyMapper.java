package uz.bank.account.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import uz.bank.account.dto.CurrencyDto;
import uz.bank.account.entity.Currency;

@Mapper(componentModel = ComponentModel.SPRING, builder = @Builder)
public interface CurrencyMapper {
	CurrencyDto toDto(Currency currency);
	Currency toEntity(CurrencyDto currencyDto);
}
