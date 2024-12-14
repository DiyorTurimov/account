package uz.bank.account.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import uz.bank.account.dto.AccountInfosDto;
import uz.bank.account.entity.AccountInfos;

@Mapper(componentModel = ComponentModel.SPRING, uses = CurrencyMapper.class, builder = @Builder)
public interface AccountMapper {
	AccountInfosDto toDto(AccountInfos accountInfos);

	AccountInfos toEntity(AccountInfosDto accountInfosDto);

}
