package uz.bank.account.service.accountserviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import uz.bank.account.dto.AccountReq;
import uz.bank.account.entity.AccountInfos;
import uz.bank.account.entity.Currency;
import uz.bank.account.mapper.AccountMapper;
import uz.bank.account.repository.AccountRepository;
import uz.bank.account.repository.CurrencyRepository;
import uz.bank.account.service.AccountService;
import uz.bank.account.util.AccountNumberGenerator;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CurrencyRepository currencyRepository;
    private final AccountMapper accountMapper;
    private final AccountNumberGenerator accountNumberGenerator;


    @Override
    public AccountInfos openAccount(AccountReq accountReq) {

        Currency currency = currencyRepository.findByCurrencyId(accountReq.getCurrencyCode());

        AccountInfos accountInfos = accountRepository
                .findByClientIdAndCurrencyId(accountReq.getClientId(), accountReq.getCurrencyCode());
        if(accountInfos != null){
            throw new DuplicateKeyException("account already exist");
        }

        String accountNumber = accountNumberGenerator.retrieve(accountReq.getCurrencyCode());

        // TODo save entity
            accountInfos.setAccountNumber(accountNumber);
        return accountRepository.save(accountMapper.toEntity(accountReq,currency));
    }
}
