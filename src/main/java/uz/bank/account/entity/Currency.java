package uz.bank.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "account_service" ,name = "currencies")
public class Currency {

    @Id
    private Long id;
    private String currencyId;
    private String currencyName;

}
