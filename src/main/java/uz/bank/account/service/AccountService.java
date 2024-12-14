package uz.bank.account.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.bank.account.dto.AccountInfosDto;
import uz.bank.account.dto.AccountReq;
import uz.bank.account.entity.AccountInfos;

import java.util.List;

@Service
public interface AccountService  {

    AccountInfosDto openAccount(AccountReq accountReq);

	AccountInfosDto getById(String accountNumber);

    List<AccountInfosDto> getAccountByClientId(String clientId);

    Page<AccountInfos> getAllAccounts(Pageable pageable);
}
