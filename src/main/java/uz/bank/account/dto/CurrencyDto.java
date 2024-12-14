package uz.bank.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;


@Data
@Builder
@Component
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)

public class CurrencyDto {
    private Long id;
    private String currencyId;
    private String currencyName;

    public CurrencyDto(Long id, String currencyId, String currencyName) {
        this.id = id;
        this.currencyId = currencyId;
        this.currencyName = currencyName;

    }
}
