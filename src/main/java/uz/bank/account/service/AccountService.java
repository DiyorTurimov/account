package uz.bank.account.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.bank.account.dto.AccountReq;
import uz.bank.account.entity.AccountInfos;

import java.util.List;

@Service
public interface AccountService  {

    AccountInfos openAccount(AccountReq accountReq);

	AccountInfos getById(String accountNumber);

    List<AccountInfos> getAccountByClientId(String clientId);

    Page<AccountInfos> getAllAccounts(Pageable pageable);
}
