package uz.bank.account.service.currencyServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.bank.account.entity.Currency;
import uz.bank.account.repository.CurrencyRepository;
import uz.bank.account.service.CurrencyService;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public Currency save(Currency currency) {
        return  currencyRepository.save(currency);
    }

    @Override
    public Currency findByCurrencyId(String currencyId) {
        return currencyRepository.findByCurrencyId(currencyId);
    }

    @Override
    public Currency findByName(String currencyName) {
        return currencyRepository.findByName(currencyName);
    }
}
