package uz.bank.account.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
public record AccountInfosDto(Long id,
                              String phone,
                              String clientId,
                              String accountNumber,
                              LocalDateTime createdAt,
                              LocalDateTime updatedAt,
                              String balance,
                              String clearBalance,
                              Boolean hasArrest,
                              CurrencyDto currency) {
}
