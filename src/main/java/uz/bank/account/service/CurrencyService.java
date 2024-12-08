package uz.bank.account.service;

import org.springframework.stereotype.Service;
import uz.bank.account.entity.Currency;

@Service
public interface CurrencyService {
    Currency save(Currency currency);

    Currency findByCurrencyId(String currencyId);

    Currency findByName(String name);
}
