package uz.bank.account.constant.paging;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountFilter {
	ID("id"),
	PHONE("phone"),
	CLIENT_ID("clientId"),
	ACCOUNT_NUMBER("accountNumber"),
	CREATE_DATE("createdAt"),
	UPDATE_DATE("updatedAt");

	private final String propertyName;
}
