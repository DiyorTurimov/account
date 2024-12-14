package uz.bank.account.dto;


import uz.bank.account.constant.paging.Direction;

public record PageableRequest<T>(
		Integer page,
		Integer size,
		Direction direction,
		T sortProperty
) {
}
