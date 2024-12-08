package uz.bank.account.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
public record AccountResponse(String accountNumber,
                              CurrencyDto currency) {

}
