package uz.bank.account.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bank.account.entity.AccountInfos;

@Repository
public interface AccountRepository extends JpaRepository<AccountInfos, Long> {

    AccountInfos findByClientId(String clientId);

    AccountInfos findByClientIdAndCurrency_CurrencyId(String accountId, String currencyId);

	Optional<AccountInfos> findByAccountNumber(String accountNumber);
}
