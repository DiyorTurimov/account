package uz.bank.account.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ErrorResponse<T>(String message,
							   HttpStatus code,
							   LocalDateTime timestamp,
							   T extra) {
}
