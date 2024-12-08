package uz.bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bank.account.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {
    Currency findByCurrencyId(String currencyId);

    Currency findByName(String currencyName);
}
