package uz.bank.account.dto;

import lombok.*;

@Builder
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)

public class CurrencyDto {
    private Long id;
    private String currencyId;
    private String currencyName;

}
