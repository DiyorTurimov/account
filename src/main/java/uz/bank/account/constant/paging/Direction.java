package uz.bank.account.constant.paging;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Direction {
	ASC("asc"),
	DESC("desc"),
	NONE(null);

	private final String value;
}
