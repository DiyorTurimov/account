package uz.bank.account.controller;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/{id}")
	public ResponseEntity<Currency> getById(@PathVariable Integer id) {
		throw new EntityNotFoundException("Currency by id: " + id + " not found");
	}
    // TODO курсы вал.т
    // TODO устаналивать курсы


}
