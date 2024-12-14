package uz.bank.account.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(schema = "account_service", name = "account_infos")
public class AccountInfos {
    @Id
    private Long id;
    private String phone;

    @EqualsAndHashCode.Include
    private String clientId;

    @EqualsAndHashCode.Include
    private String accountNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
  /*  private String balance;
    private String clearBalance;
    private Boolean hasArrest;*/

    // balance -- с учтом все[ [олдов и овердрафтов
    // clearBalance -- су[ой остаток
    // hasArrest

    @ManyToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

}
