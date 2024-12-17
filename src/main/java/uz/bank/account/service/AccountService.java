package uz.bank.account.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.bank.account.constant.paging.AccountFilter;
import uz.bank.account.dto.AccountInfosDto;
import uz.bank.account.dto.AccountReq;
import uz.bank.account.dto.PageableRequest;
import uz.bank.account.dto.PageableResponse;
import uz.bank.account.entity.AccountInfos;

@Service
public interface AccountService  {

    AccountInfosDto openAccount(AccountReq accountReq);

	AccountInfosDto getById(String accountNumber);

    PageableResponse<AccountInfosDto> getAccountsByClientID(PageableRequest<AccountFilter> pageableRequest);

    PageableResponse<AccountInfosDto> getAccountsByClientID(String clientId, PageableRequest<AccountFilter> pageableRequest);

//    Page<AccountInfos> getAllAccounts(Pageable pageable);
}
