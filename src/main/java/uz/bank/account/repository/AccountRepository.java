package uz.bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import uz.bank.account.entity.AccountInfos;

@Repository
public interface AccountRepository extends JpaRepository<AccountInfos, Long> {

    AccountInfos findByClientId(String clientId);

    AccountInfos findByClientIdAndCurrencyId(String accountId, String currencyId);
}
