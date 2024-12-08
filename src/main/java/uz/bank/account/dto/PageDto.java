package uz.bank.account.dto;

import java.util.List;
import lombok.Builder;

@Builder
public record PageDto<T>(Integer page, // 1
						 Integer totalPages, // 57
						 Integer size, // 30
						 List<T> data) {

}
