package uz.bank.account.service.accountserviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.bank.account.dto.AccountInfosDto;
import uz.bank.account.dto.AccountReq;
import uz.bank.account.dto.CurrencyDto;
import uz.bank.account.entity.AccountInfos;
import uz.bank.account.entity.Currency;
import uz.bank.account.mapper.AccountMapper;
import uz.bank.account.repository.AccountRepository;
import uz.bank.account.repository.CurrencyRepository;
import uz.bank.account.service.AccountService;
import uz.bank.account.util.AccountNumberGenerator;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CurrencyRepository currencyRepository;
    private final AccountMapper accountMapper;
    private final AccountNumberGenerator accountNumberGenerator;


    @Override
    public AccountInfosDto openAccount(AccountReq accountReq) {

        Currency currency = currencyRepository.findByCurrencyId(accountReq.getCurrencyCode())
                .orElseThrow(() -> new EntityNotFoundException("Currency not found"));

        Optional<AccountInfos> optionalAccountInfos = accountRepository
                .findByClientIdAndCurrency_CurrencyId(accountReq.getClientId(), accountReq.getCurrencyCode());
        if (optionalAccountInfos.isPresent()) {
            throw new DuplicateKeyException("Account already exists");
        }

        String accountNumber = accountNumberGenerator.retrieve(accountReq.getCurrencyCode());

        AccountInfos accountInfos = accountMapper.toAccountInfosForReq(accountReq);

        accountInfos.setAccountNumber(accountNumber);

        return accountMapper.toDto(accountRepository.save(accountInfos));
    }

    @Override
    public AccountInfosDto getById(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(accountInfos -> accountMapper.toDto(accountInfos))
                .orElseThrow(() -> new EntityNotFoundException("Account by number: " + accountNumber + " not found"));
    }

    @Override
    public List<AccountInfosDto> getAccountByClientId(String clientId) {
        return null;
    }

    @Override
    public Page<AccountInfos> getAllAccounts(Pageable pageable) {
        return null;
    }
}
