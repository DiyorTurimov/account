package uz.bank.account.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bank.account.config.ResponseHandler;
import uz.bank.account.dto.AccountInfosDto;
import uz.bank.account.entity.AccountInfos;
import uz.bank.account.service.AccountService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")

public class AccountController {

    @Autowired
    private final AccountService accountService;

    private final ResponseHandler responseHandler;

    @GetMapping("/client/{clientId}")
    public ResponseEntity<?> byClientId(@PathVariable String clientId) {
        List<AccountInfosDto> accountInfosList = accountService.getAccountByClientId(clientId);
        if (accountInfosList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
       // return ResponseEntity.ok(accountInfosList);
        return responseHandler.responseEntity(accountInfosList);
    }



    // TODO get all accounts by clientId
    // TODO get pageable account list all

}
