package uz.bank.account.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public record AccountResponse(String accountNumber,
                              LocalDateTime createdAt,
                              CurrencyDto currency) {

}
