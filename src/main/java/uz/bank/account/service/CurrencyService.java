package uz.bank.account.service;

import org.springframework.stereotype.Service;
import uz.bank.account.dto.CurrencyDto;
import uz.bank.account.entity.Currency;

@Service
public interface CurrencyService {
    CurrencyDto save(Currency currency);

    CurrencyDto findByCurrencyId(String currencyId);

    CurrencyDto findByName(String name);
}
