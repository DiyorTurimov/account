package uz.bank.account.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bank.account.entity.Currency;
import uz.bank.account.service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping
    public ResponseEntity<Currency> addCurrency(@RequestBody Currency currency) {
       return ResponseEntity.ok(currencyService.save(currency));
    }

    // TODO курсы вал.т
    // TODO устаналивать курсы


}
