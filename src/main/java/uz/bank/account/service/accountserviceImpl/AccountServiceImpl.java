package uz.bank.account.service.accountserviceImpl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                .findByClientIdAndCurrency_CurrencyId(accountReq.getClientId(), accountReq.getCurrencyCode());
        if(accountInfos != null){
            throw new DuplicateKeyException("account already exist");
        }

        String accountNumber = accountNumberGenerator.retrieve(accountReq.getCurrencyCode());

        // TODo save entity
            accountInfos.setAccountNumber(accountNumber);
        return accountRepository.save(accountMapper.toEntity(accountReq,currency));
    }

	@Override
	public AccountInfos getById(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new EntityNotFoundException("Account by number: " + accountNumber + " not found"));
	}

	@Override
	public List<AccountInfos> getAccountByClientId(String clientId) {
		return null;
	}

	@Override
	public Page<AccountInfos> getAllAccounts(Pageable pageable) {
		return null;
	}
}
