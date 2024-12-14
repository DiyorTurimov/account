package uz.bank.account.exception.cause;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApplicationExceptionCause {

	ENTITY_NOT_FOUND_BY_ID("entity_not_found_by_id");

	private final String code;
}
