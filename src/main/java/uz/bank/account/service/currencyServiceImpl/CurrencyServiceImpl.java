package uz.bank.account.service.currencyServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.bank.account.dto.CurrencyDto;
import uz.bank.account.entity.Currency;
import uz.bank.account.mapper.CurrencyMapper;
import uz.bank.account.repository.CurrencyRepository;
import uz.bank.account.service.CurrencyService;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    @Override
    public CurrencyDto save(Currency currency) {
        return currencyMapper.toDto(currencyRepository.save(currency));
    }

    @Override
    public CurrencyDto findByCurrencyId(String currencyId) {
        return currencyMapper.toDto(currencyRepository.findByCurrencyId(currencyId)
                .orElseThrow(() -> new RuntimeException("Currency not found")));
    }

    @Override
    public CurrencyDto findByName(String currencyName) {
        return currencyMapper.toDto(currencyRepository.findByName(currencyName)
                .orElseThrow(() -> new RuntimeException("Currency not found")));
    }
}
