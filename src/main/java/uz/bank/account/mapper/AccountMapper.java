package uz.bank.account.mapper;

import org.springframework.stereotype.Component;
import uz.bank.account.dto.AccountReq;
import uz.bank.account.entity.AccountInfos;
import uz.bank.account.entity.Currency;

import java.time.LocalDateTime;

@Component
public class AccountMapper {

    public AccountInfos toEntity(AccountReq req, Currency currency){
        return AccountInfos.builder()
                .clientId(req.getClientId())
                .currency(currency)
                .createdAt(LocalDateTime.now())
                .build();
    }

    // TODO toResponse

}
