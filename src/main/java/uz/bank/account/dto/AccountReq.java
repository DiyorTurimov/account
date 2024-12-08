package uz.bank.account.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AccountReq {

    private String clientId;
    private String currencyCode;

}
