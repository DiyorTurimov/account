package uz.bank.account.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import uz.bank.account.dto.AccountInfosDto;
import uz.bank.account.dto.AccountReq;
import uz.bank.account.entity.AccountInfos;


@Mapper(componentModel = "spring" )
public interface AccountMapper {
    AccountInfosDto toDto(AccountInfos accountInfos);

    AccountInfos toAccountInfos(AccountInfosDto accountInfosDto);

    AccountInfos toAccountInfosForReq(AccountReq accountReq);




}
